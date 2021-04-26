package D19123917;

import ie.tudublin.*;

public class Elmo extends Visual
{
    float i = 0;
    
    public void settings()
    {
        //size(512, 512, P3D);
        size(800, 800, P3D);
    }   

    public void setup()
    {
        startMinim();
        surface.setResizable(true);
        loadAudio("POPSTAR.mp3");
        getAudioPlayer().play();
        colorMode(HSB);
    }

    int which = 0;
    public void keyPressed()
    {
        if(keyCode >= '0' && keyCode <= '5')
        {
            which = keyCode - '0';
        }
        if(keyCode == ' ') // If i push the space bar 
        {
            if(getAp().isPlaying()) // If audioplayer is already playing
            { 
                getAp().pause(); // Pause the audio
            }
            else
            {
                getAp().rewind(); // Rewind
                getAp().play(); // Play 
            }
        }
    }

    float la = 0;

    public void draw()
    {   
        background(0);
        stroke(255);

        float average = 0;
        float sum = 0;

        float hw = width / 2; // Half width
        float hh = height / 2; // Half height 

        // Iterate over all the elementsthe audio buffer
        for(int i = 0; i < getAb().size(); i++) // ab is an array list of audio buffer so ab.size() gives us the size of array buffer
        {
            sum += abs(getAb().get(i)); // This is how you look inside the arraylist and get element i out of the arraylist
        }
        
        average = sum / (float) getAb().size();
        la = lerp(la, average, 0.1f); // Lerped average

        switch(which)
        {
            case 0: 
            {
                float c = map(average, 0, 1, 0, 255);
                
                noStroke(); 

                //i++;
                pushMatrix();
                fill(c, 255, 255); // Elmo left arm
                translate(hw - 50, hh + 40);
                //rotate(i);
                rotate(10);
                rect(0, 0, 400 + (la * 500), 70 + (la * 500), 50);
                popMatrix();

                pushMatrix();
                translate(hw, hh - 20);
                rotate(100);
                rect(0, 0, 400 + (la * 500), 70 + (la * 500), 50); // Elmo right arm 
                popMatrix();

                fill(c, 255, 255); // Elmo upper body
                arc(hw, hh + 250, 300 + (la * 500), 700 + (la * 500), PI, TWO_PI);

                fill(c, 255, 255); // Elmo face    
                ellipse(hw, hh - 200, 300 + (la * 500), 300 + (la * 500));                

                fill(255); // Elmo eye balls
                ellipse(hw - 50, hh - 350, 80 + (la * 500), 80 + (la * 500)); 
                ellipse(hw + 50, hh - 350, 80 + (la * 500), 80 + (la * 500));

                fill(0); // Elmo pupils
                ellipse(hw - 50, hh - 350, 20 + (la * 500), 20 + (la * 500));
                ellipse(hw + 50, hh - 350, 20 + (la * 500), 20 + (la * 500));

                fill(33,363,234); // Elmo nose
                ellipse(hw, hh - 300, 70 + (la * 500), 90 + (la * 500)); 

                fill(0); // Elmo mouth
                arc(hw, hh - 180, 250 + (la * 500), 220 + (la * 500), 0, PI); 
                /*quad(halfW - 40, halfH - 80, halfW - 80, halfH, halfW / 2, halfH, halfW / 2, halfH - 80); // Left arm
                quad(halfW + 40, halfH - 80, halfW + 80, halfH, halfW / 2, halfH, halfW + (halfW / 2), halfH - 80); // Right arm*/

                
                
                
                
                
                break;
            }
            case 1:
            {
            
            }
            case 2:
            {
            
            }
            case 3:
            {
            
            }
            case 4:
            {
            
            }
            case 5:
            {
            
            }
        }
    }

}