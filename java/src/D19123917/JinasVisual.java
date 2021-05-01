package D19123917;

import java.util.ArrayList;
import ie.tudublin.*;
import processing.core.PImage;


public class JinasVisual extends Visual
{
    Star [] stars = new Star[50]; // Create an array named stars
    PImage [] images = new PImage[7];
    ArrayList<Monster> m = new ArrayList<Monster>();
    Monster monster;

    float average;
    float hh, hw;
    float c, c2;
    float speed;

    Boolean paused = false;
    Boolean bla = false;

    int cols, rows;
    int scl = 20;
    int w = 2000;
    int h = 1600;

    float flying = 0;
    float[][] terrain;


    public void settings()
    {
        size(800, 800, P3D);

        hw = width / 2; // Half width
        hh = height / 2; // Half height

        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this);
        }

        cols = w / scl;
        rows = h/ scl;
        terrain = new float[cols][rows];
    }   

    public void setup()
    {
        startMinim();
        surface.setResizable(true);
        loadAudio("Dare.mp3");
        getAudioPlayer().play();
        colorMode(HSB, 100);
        //println(getAp().length()); 

        monster = new Monster(this, hw, hh, c, 0.5f);
        m.add(monster);

        monster= new Monster(this, 100, 150, c, 0.4f);
        m.add(monster);    
        
        monster= new Monster(this, 600, 100, c, 0.3f);
        m.add(monster); 

        images[0] = loadImage("1.png");
        images[1] = loadImage("2.png");
        images[2] = loadImage("3.png");
        images[3] = loadImage("4.png");
        images[4] = loadImage("5.png");
        images[5] = loadImage("6.png");
    }

    public void spawnMonster()
    {
        float ran = random(1, width);
        monster = new Monster(this, ran, height - (hh / 2), c, 0.3f);
        m.add(monster);
        frameRate(20);
    }

    public void removeMonster()
    {
        float ran = random(1, width);
        monster = new Monster(this, ran, height - (hh / 2), c, 0.3f);
        m.remove(monster);
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
                paused = true;
            }
            else
            {
                getAp().rewind(); // Rewind
                getAp().play(); // Play 
                paused = false;
            }
        }
    }

    float la = 0;

    public void draw()
    {   
        float sum = 0;

        // Iterate over all the elementsthe audio buffer
        for(int i = 0; i < getAb().size(); i++) // ab is an array list of audio buffer so ab.size() gives us the size of array buffer
        {
            sum += abs(getAb().get(i)); // This is how you look inside the arraylist and get element i out of the arraylist
            //println(getAb().size());
            if(sum > 1 && sum < 10)
            {
                //bla = true;
            }
        }
        
        average = sum / (float) getAb().size();
        la = lerp(la, average, 0.1f); // Lerped average
        println(la);

        switch(which)
        {
            case 0: 
            {
                
                background(0);
                speed = 10;

                //float c = map(average, 0, 1, 0, 255);
                
                fill(0, 0, 100);
                circle(width / 2, 0, 200);

                
                //println(" " + average);
                if(average * 1000 > 50)
                {
                    //fill(0, 0, 100);
                    //circle(width / 2, 0, 200);
                    triangle(hw, 0, hw - 200, height, hw + 200, height);

                    //triangle(hw, 0, -w, h, w, h);

                    //spawnMonster();
                }
                else if(average * 1000 > 60)
                {
                    //fill(0, 0, 100);
                    //triangle(hw, 0, width, height, width, hh / 2);
                }
                else
                {
                    //fill(0, 0, 100);
                    triangle(hw, 0, 0, hh / 2, 0, height);
                    triangle(hw, 0, width, height, width, hh / 2);
                    
                }

                
                // Draw stars
                translate(width/2, 0);
                for(int i = 0; i < stars.length; i++)
                {
                    if((frameCount % 3) == 0)
                    {
                        stars[i].update();
                    }
                    stars[i].show();
                }

                // Draw elmo
                translate(-width/2, 0);
                for(int i = 0; i < m.size(); i++)
                {
                    Monster mo = m.get(i);
                    
                
                    mo.render();
                    mo.update();
                }

                if(la * 1000 > 100 && la * 1000 < 130)
                {
                    spawnMonster();
                }
                else
                {
                    removeMonster();
                }
                

                if(bla == true)
                {
                    //spawnMonster();
                }


                if(average * 1000 > 70 && average * 1000 < 80)
                {
                    //spawnMonster();
                }

                break;
            }
            case 1:
            {
                flying -= 0.1;

                float yoff = flying;
                for (int y = 0; y < rows; y++)
                {
                    float xoff = 0;
                    for (int x = 0; x < cols; x++)
                    {
                        terrain[x][y] = map(noise(xoff, yoff), 0, 1, -100, 100);
                        xoff += 0.2;
                    }
                    yoff += 0.2;
                }

                background(0);
                stroke(255);
                noFill();
              
                translate(width/2, height/2+50);
                rotateX(PI/3);
                translate(-w/2, -h/2);
                for (int y = 0; y < rows-1; y++)
                {
                     beginShape(TRIANGLE_STRIP);
                    for (int x = 0; x < cols; x++)
                    {
                        vertex(x*scl, y*scl, terrain[x][y]);
                        vertex(x*scl, (y+1)*scl, terrain[x][y+1]);
                        //rect(x*scl, y*scl, scl, scl);
                    }
                  endShape();
                }
                break;

            }
            case 2:
            {
                int s = mouseX / 5 + 1;
                frameRate(s);
                background(255);
                int imageNum = frameCount % 6;
                //translate(hw, hh);
                image(images[imageNum], 0, 0);
                
                break;
            }
            case 3:
            {
            }
            case 4:
            {
                float r = 1f; // radius
                int numPoints = 3; // no. of points that we are gonna calculate on the outside of a spiral
                float thetaInc = TWO_PI / (float)numPoints;
                strokeWeight(2);
                stroke(255);
                float lastX = width / 2; 
                float lastY = height / 2;
                for(int i = 0; i < 1000; i++) // Calculate 1000 points on the outside of a spiral -> doing that for 1000 times
                {
                    float c = map(i, 0, 300, 0, 255) % 255.0f;
                    stroke(c, 255, 255, 100);
                    float theta = i * (thetaInc + la * 5);
                    float x = width / 2 + sin(theta) * r; // Calculating the points on the outside of the circle 
                    float y = height / 2 - cos(theta) * r;
                    r += 0.5f + la; // Increase the radius by some small amount
                    numPoints++;
                    //point(x, y);
                    line(lastX, lastY, x, y); // Drawing a line from previously calculated to the current calculated point
                    lastX = x;
                    lastY = y;
                }
                break;
            }
            case 5:
            {
                
            }
        }
        
    }
    
}