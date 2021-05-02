package D19123917;

public class Star
{
    JinasVisual jv;

    float x, y, z, pz;
    float sx, sy, px, py;
    float cc;

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
        if (cc >= 255) cc = 0;
        else cc++;

        jv.strokeWeight(2);
        jv.stroke(cc, 100, 255);
        jv.line(px, py, sx, sy);
        
    }

}
