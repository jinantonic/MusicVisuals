package D19123917;

public class Monster
{
    JinasVisual jv;

    float x, y;
    float c;
    float w, h;
    float s; // scale
    float ws; // width scale
    float i = 0;
    

    public Monster(JinasVisual jv, float x, float y, float c, float s)
    {
        this.jv = jv;
        this.x = x;
        this.y = y;
        this.c = c;
        this.s = s;
        this.w = (jv.width * 0.625f) * s;
        this.h = w * 0.1f;
        this.ws = w * 0.6f;
    }

    public void update()
    {
        if(!jv.paused)
        {
            c = JinasVisual.map(jv.average, 0, 1, 0, 255);
            if((jv.frameCount % 4) == 0)
            {
                i += 0.1f; // i++;
                //JinasVisual.println("VALUE " + i); 
            }
        }
    }
    
    public void render()
    {
        jv.noStroke();

        jv.fill(x);
        jv.triangle(jv.width / 2, 0, x - ws + (jv.la * w), y + (w * 0.8f), x + ws + (jv.la * w), y + (w * 0.8f));

        jv.pushMatrix();
        jv.fill(c, 255, 255); // Left arm
        jv.translate(x - x / 15, y + (w * 0.4f));
        jv.rotate(i);
        jv.rect(0, 0, (ws * 1.1f) + (jv.la * w), ((ws * 0.23f) + (jv.la * w)), 50);
        jv.popMatrix();

        jv.pushMatrix();
        jv.translate(x + x / 15, y + (w * 0.4f));
        jv.rotate(-i);
        jv.rect(0, 0, (ws * 1.1f) + (jv.la * w), (ws * 0.23f) + (jv.la * w), 50); // Right arm 
        jv.popMatrix();

        // Upper body
        jv.arc(x, y + (w * 0.8f), ws + (jv.la * w), (ws * 2) + (jv.la * w), JinasVisual.PI, JinasVisual.TWO_PI);

        // Face    
        jv.ellipse(x, y - (w * 0.07f), ws + (jv.la * w), ws + (jv.la * w));                

        jv.fill(255); // Eye balls
        jv.circle(x - (w * 0.1f), y - (w * 0.4f), (int)((ws * 0.26) + (jv.la * w)));
        jv.circle(x + (w * 0.1f), y - (w * 0.4f), (int)((ws * 0.26) + (jv.la * w)));

        jv.fill(0); // Pupils
        jv.circle(x - (w * 0.1f), y - (w * 0.4f), (int)((ws * 0.06) + (jv.la * w)));
        jv.circle(x + (w * 0.1f), y - (w * 0.4f), (int)((ws * 0.06) + (jv.la * w)));
        
        jv.fill(33,363,234); // Nose
        jv.ellipse(x, y - (w * 0.3f), (int)((ws * 0.23) + (jv.la * w)), (int)((ws * 0.3) + (jv.la * w))); 

        jv.fill(0); // Mouth
        jv.arc(x, y - (w * 0.06f), (int)((ws * 0.83) + (jv.la * w)), (int)((ws * 0.73) + (jv.la * w)), 0, JinasVisual.PI); 
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
