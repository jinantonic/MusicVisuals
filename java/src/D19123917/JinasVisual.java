package D19123917;

import ie.tudublin.*;


public class JinasVisual extends Visual
{
    Star [] stars = new Star[100];
    
    public void settings()
    {
        //size(800, 800, P3D);
        size(400, 400);
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star();
        }
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
                background(0);
                //float c = map(average, 0, 1, 0, 255);
                for(int i = 0; i < stars.length; i++)
                {
                    stars[i].update();
                    stars[i].show();
                }
            

                
                
                
                
                
                
                
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