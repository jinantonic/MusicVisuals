package D19123917;

public class Monster
{
    JinasVisual jv;

    float x, y;
    float c;
    float w, h;
    float s; // scale



    public Monster(JinasVisual jv, float x, float y, float c, float w, float h, float s)
    {
        this.jv = jv;
        this.x = x;
        this.y = y;
        this.c = c;
        this.w = w;
        this.h = h;
        this.s = s;
    }

    public void update()
    {

    }
    
    public void render()
    {
        jv.noStroke(); 

        //i++;
        jv.pushMatrix();
        jv.fill(c, 255, 255); // Elmo left arm
        jv.translate(x - 50, y + 200);
        //rotate(i);
        jv.rotate(10);
        jv.rect(0, 0, 300 + (jv.la * 500), 70 + (jv.la * 500), 50);
        jv.popMatrix();

        jv.pushMatrix();
        jv.translate(x, y + 140);
        jv.rotate(100);
        jv.rect(0, 0, 300 + (jv.la * 500), 70 + (jv.la * 500), 50); // Elmo right arm 
        jv.popMatrix();

        jv.fill(c, 255, 255); // Elmo upper body
        jv.arc(x, y + 400, 300 + (jv.la * 500), 600 + (jv.la * 500), JinasVisual.PI, JinasVisual.TWO_PI);

        jv.fill(c, 255, 255); // Elmo face    
        jv.ellipse(x, y - 35, 300 + (jv.la * 500), 300 + (jv.la * 500));                

        jv.fill(255); // Elmo eye balls
        jv.ellipse(x - 50, y - 200, 80 + (jv.la * 500), 80 + (jv.la * 500)); 
        jv.ellipse(x + 50, y - 200, 80 + (jv.la * 500), 80 + (jv.la * 500));

        jv.fill(0); // Elmo pupils
        jv.ellipse(x - 50, y - 200, 20 + (jv.la * 500), 20 + (jv.la * 500));
        jv.ellipse(x + 50, y - 200, 20 + (jv.la * 500), 20 + (jv.la * 500));

        jv.fill(33,363,234); // Elmo nose
        jv.ellipse(x, y - 150, 70 + (jv.la * 500), 90 + (jv.la * 500)); 

        jv.fill(0); // Elmo mouth
        jv.arc(x, y - 30, 250 + (jv.la * 500), 220 + (jv.la * 500), 0, JinasVisual.PI); 
        
    }





    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getC() {
        return c;
    }
    public void setC(float c) {
        this.c = c;
    }
    public float getW() {
        return w;
    }
    public void setW(float w) {
        this.w = w;
    }
    public float getH() {
        return h;
    }
    public void setH(float h) {
        this.h = h;
    }
    public float getS() {
        return s;
    }
    public void setS(float s) {
        this.s = s;
    }

    
}
