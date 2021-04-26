package D19123917;

public class Boogie
{
    class Boogie
    {
        JinasVisual jv;
        
        PImage[] images;
        int imageCount;
        int frame;
        float x, y;
  
        Boogie(float x, float y)
        {
            this.x  = x;
            this.y = y;
            imageCount = 8;
            frame = 0;
            images =  new PImage[imageCount];
            
            for(int i = 0; i < imageCount; i++){
            String filename = "png/Run ("+i+").png";
            images[i] = loadImage(filename);
            images[i].resize(680/2, 472/2);
        }
   }
  
   void run(){
       image(images[frame], this.x, this.y);
       frame = (frame + 1) % imageCount;
       delay(70);
   }
}
void mousePressed(){
     dino = new Dino(mouseX - 150, mouseY - 100);
     dance = true;
}

}
