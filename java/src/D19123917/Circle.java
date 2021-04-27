package D19123917;

import processing.core.PVector;

public class Circle
{
    JinasVisual jv;

    

    public Circle(JinasVisual jv)
    {
        this.jv = jv;
    }

    PVector pos= new PVector(jv.random(50, jv.width-50), jv.random(50, jv.height-50));
    PVector velocity = new PVector(jv.random(-0.05, 0.05), jv.random(-0.01, 0.01));
    PVector amplitude = new PVector(130, 130);
   
    public void move()
    {
        pos.add(velocity);
    }

    public void display()
    {
     
        float x = jv.sin(pos.x) * amplitude.x;
        float y = jv.sin(pos.y) * amplitude.y;
   
        jv.pushMatrix();
        jv.translate(jv.width/2, jv.height/2);
        fill(#DBA350);
        //가운데점에서 서클에 연결되는 라인 그리기
        jv.line(0, 0, x, y);

        for(int i = 0; i < getAb().size(); i++) // ab is an array list of audio buffer so ab.size() gives us the size of array buffer
        {
            sum += abs(getAb().get(i)); // This is how you look inside the arraylist and get element i out of the arraylist
        }

        //진동하는 서클그리기
        for(int i =0; i < jv.getAb().size() - 1; i++)
        {
            //stroke(255, 255-(song.right.get(i)*200), 255 - (song.left.get(i)*200));
             ellipse(x, y, 15+(song.right.get(i)*50), 15+(song.left.get(i)*50));
        }
        jv.popMatrix();
    }
}
   
  