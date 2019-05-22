import processing.core.PApplet;
import processing.core.PVector;

public class Boundary extends PApplet {

    PVector a;
    PVector b;

    public Boundary(int x1, int y1, int x2, int y2) {
        a = new PVector(x1, y1);
        b = new PVector(x2, y2);
    }


    public void draw(PApplet p) {
        p.stroke(255);
        p.line(a.x, a.y, b.x, b.y);
    }
}
