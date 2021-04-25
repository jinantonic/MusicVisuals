package D19123917;

public class Star extends JinasVisual
{
    float x, y, z;

    public Star()
    {
        x = random(0, width);
        y = random(0, height);
        z = random(0, width);
    }

    public void update()
    {
        z = z - 1;
    }

    public void show()
    {
        fill(255);
        noStroke();

        float sx = map(x / 2, 0, 1, 0, width);
        float sy = map(y / 2, 0, 1, 0, height);

        ellipse(sx, sy, 8, 8);
    }

}
