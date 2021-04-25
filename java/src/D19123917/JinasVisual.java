package D19123917;

import ie.tudublin.*;
import processing.core.PImage;

public class JinasVisual extends Visual
{
    PImage[] images = new PImage[4];
    
    public void settings()
    {
        //size(512, 512, P3D);
        size(800, 800, P3D);
    }   

    public void setup()
    {

        images[0] = loadImage("0.png");
        images[1] = loadImage("1.png");
        images[2] = loadImage("2.png");
        images[3] = loadImage("3.png");

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

        float average = 0;
        float sum = 0;

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
                //float c = map(average, 0, 1, 0, 255);
                int s = mouseX / 5 + 1;
                frameRate(s);
                background(255);

                int num = frameCount % 4;
                image(images[num], 0, 0);

                
                
                
                
                
                
                
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