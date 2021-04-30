package D19123917;

public class Star
{
    JinasVisual jv;

    float x, y, z, pz;
    float sx, sy, px, py;

    
    public Star(JinasVisual jv)
    {
        this.jv = jv;
    }

    public Star()
    {
        x = jv.random(-jv.width / 8, jv.width / 8);
        y = jv.random(jv.height * 0.01f, jv.height * 0.1f);
        z = jv.random(jv.width);
        
    }

    public void update()
    {
        if(!jv.paused)
        {   
            z = z - jv.speed;

            
            if(z < 1)
            {


                z = jv.random(jv.width);
                x = jv.random(-jv.width / 8, jv.width / 8);
                y = jv.random(jv.height * 0.01f, jv.height * 0.1f);
                pz = z;

            }
            sx = JinasVisual.map(x / z, 0, 1, 0, jv.width);
            sy = JinasVisual.map(y / z, 0, 1, 0, jv.height);

            px = JinasVisual.map(x / pz, 0, 1, 0, jv.width);
            py = JinasVisual.map(y / pz, 0, 1, 0, jv.height);


        }
    }


    public void show()
    {
        jv.fill(255);
        jv.noStroke();

        /*for(int i = 0; i < 1000; i++) // Calculate 1000 points on the outside of a spiral -> doing that for 1000 times
        {
            jv. c = JinasVisual.map(i, 0, 300, 0, 255) % 255.0f;
            jv. c2 = JinasVisual.map(i, 0, 300, 0, 255) % 100.0f;
        }   */  
        
        
        //float r = JinasVisual.map(z, 0, jv.width, 16, 0);
        //jv.ellipse(sx, sy, r, r);

        

        jv.stroke(255);
        jv.line(px, py, sx, sy);
        
    }

}
