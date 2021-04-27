package D19123917;

import ie.tudublin.*;
import processing.core.PImage;


public class JinasVisual extends Visual
{
    Star [] stars = new Star[800]; // Create an array named stars
    PImage [] images = new PImage[7];

    float speed;

    int cols, rows;
    int scl = 20;
    int w = 2000;
    int h = 1600;

    float flying = 0;

    float[][] terrain;


    public void settings()
    {
        size(800, 800, P3D);
        //size(400, 400);
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
        loadAudio("POPSTAR.mp3");
        getAudioPlayer().play();
        colorMode(HSB);

        images[0] = loadImage("1.png");
        images[1] = loadImage("2.png");
        images[2] = loadImage("3.png");
        images[3] = loadImage("4.png");
        images[4] = loadImage("5.png");
        images[5] = loadImage("6.png");

        
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
                speed = map(mouseX, 0, width, 0, 20);
                background(0);
                //translate(hw, hh);
                //float c = map(average, 0, 1, 0, 255);
                for(int i = 0; i < stars.length; i++)
                {
                    stars[i].update();
                    stars[i].show();
                }

                float c = map(average, 0, 1, 0, 255);
                noStroke(); 

                //i++;
                pushMatrix();
                fill(c, 255, 255); // Elmo left arm
                translate(hw - 50, hh + 200);
                //rotate(i);
                rotate(10);
                rect(0, 0, 300 + (la * 500), 70 + (la * 500), 50);
                popMatrix();

                pushMatrix();
                translate(hw, hh + 140);
                rotate(100);
                rect(0, 0, 300 + (la * 500), 70 + (la * 500), 50); // Elmo right arm 
                popMatrix();

                fill(c, 255, 255); // Elmo upper body
                arc(hw, hh + 400, 300 + (la * 500), 600 + (la * 500), PI, TWO_PI);

                fill(c, 255, 255); // Elmo face    
                ellipse(hw, hh - 35, 300 + (la * 500), 300 + (la * 500));                

                fill(255); // Elmo eye balls
                ellipse(hw - 50, hh - 200, 80 + (la * 500), 80 + (la * 500)); 
                ellipse(hw + 50, hh - 200, 80 + (la * 500), 80 + (la * 500));

                fill(0); // Elmo pupils
                ellipse(hw - 50, hh - 200, 20 + (la * 500), 20 + (la * 500));
                ellipse(hw + 50, hh - 200, 20 + (la * 500), 20 + (la * 500));

                fill(33,363,234); // Elmo nose
                ellipse(hw, hh - 150, 70 + (la * 500), 90 + (la * 500)); 

                fill(0); // Elmo mouth
                arc(hw, hh - 30, 250 + (la * 500), 220 + (la * 500), 0, PI); 
                
                break;
            }
            case 1:
            {
                
                flying -= 0.1;

                float yoff = flying;
                for (int y = 0; y < rows; y++) {
                    float xoff = 0;
                    for (int x = 0; x < cols; x++) {
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
                for (int y = 0; y < rows-1; y++) {
                  beginShape(TRIANGLE_STRIP);
                  for (int x = 0; x < cols; x++) {
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
                translate(hw, hh);
                image(images[imageNum], 0, 0);
                break;
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