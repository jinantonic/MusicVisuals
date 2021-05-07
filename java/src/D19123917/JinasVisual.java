package D19123917;

import java.util.ArrayList;
import ie.tudublin.*;


public class JinasVisual extends Visual
{
    
    Star [] stars = new Star[50]; // Create an array named stars, which will be filled with 50 elements made from Star class
    
    ArrayList<Monster> m = new ArrayList<Monster>(); // Create an arraylist of a monster
    
    Monster monster; // Moster object

    float average;
    float hh, hw;
    float c;
    float speed; // Control the speed of the stars

    Boolean paused = false;

    int cols, rows;
    int scl = 20;
    int w = 2000;
    int h = 1600;

    
    public void settings()
    {
        size(800, 800, P3D);

        hw = width / 2; // Half width
        hh = height / 2; // Half height

        // Run for 50 times, creating the new star
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this);
        } // end for
    } // end settings() 


    public void setup()
    {
        startMinim();
        surface.setResizable(true);
        loadAudio("Dare.mp3");
        getAudioPlayer().play(); 
        colorMode(HSB, 100);

        monster = new Monster(this, hw, hh - hh * 0.1f, c, 0.5f, true);
        m.add(monster);

        monster= new Monster(this, hw / 4, hh - hh / 3, c, 0.4f, true);
        m.add(monster);    
        
        monster= new Monster(this, width - hw / 3, hh - hh * 0.4f, c, 0.3f, true);
        m.add(monster); 
    } // end setup()


    public void spawnMonster()
    {
        if(! paused)
        {
            float ran = random(1, width);
            float run = random(hh + hh * 0.5f, height);
            monster = new Monster(this, ran, run, c, 0.2f, false);
            m.add(monster);
            frameRate(40);
        } // end if
    } // end spawnMonster()


    public void keyPressed()
    {
        if(keyCode == ' ') // If i push the space bar 
        {
            if(getAp().isPlaying()) // If audioplayer is already playing
            { 
                getAp().pause(); // Pause the audio
                paused = true;
            } // end inner if
            else
            {
                //getAp().rewind(); // Rewind
                getAp().play(); // Play 
                paused = false;
            } // end else
        } // end outer if
    } // end keyPressed()


    float la = 0; // Set lerped average as 0

    public void draw()
    {   
        float sum = 0;

        // Iterate over all the elementsthe audio buffer
        for(int i = 0; i < getAb().size(); i++) // ab is an array list of audio buffer so ab.size() gives us the size of array buffer
        {
            sum += abs(getAb().get(i)); // This is how you look inside the arraylist and get element i out of the arraylist
        } // end for
        
        average = sum / (float) getAb().size();
        la = lerp(la, average, 0.1f); // Lerped average

        background(0);
        speed = 10;
        
        // Draw the disco ball
        float c2 = map(la, 0, 0.5f, 0, 255);
        fill(255, 0, 25 + c2);
        ellipse(width / 2, 0, 250, 200);

        // Draw spotlights
        if(average * 1000 > 70)
        {
            triangle(hw, 0, hw - 200, height, hw + 200, height);
        } // end if
        
        else
        {
            triangle(hw, 0, 0, hh / 2, 0, height);
            triangle(hw, 0, width, height, width, hh / 2);
        } //end else


        // Draw stars
        pushMatrix();
        translate(width/2, 0); // Translate the composition
        for(int i = 0; i < stars.length; i++)
        {
            if((frameCount % 3) == 0)
            {
                stars[i].update();
            } // end if

            stars[i].show();
        } // end for
        popMatrix();

        
        // Draw elmo
        for(int i = 0; i < m.size(); i++)
        {
            Monster mo = m.get(i);
            mo.render();
            mo.update();
        } // end for


        if(la * 100 > 19 && la * 100 < 20)
        {
            spawnMonster();
        } // end if
        
    } // end draw()
} // end JinasVisual