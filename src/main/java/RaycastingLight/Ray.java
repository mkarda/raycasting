package RaycastingLight;

import processing.core.PApplet;
import processing.core.PVector;

class Ray {
    private PVector pos;
    private PVector dir;

    Ray(PVector pos, float angle) {
        this.pos = pos;
        this.dir = PVector.fromAngle(angle);
    }

    PVector cast(Boundary wall) {
        float x1 = wall.a.x;
        float y1 = wall.a.y;
        float x2 = wall.b.x;
        float y2 = wall.b.y;
        float x3 = pos.x;
        float y3 = pos.y;
        float x4 = (pos.x + dir.x);
        float y4 = (pos.y + dir.y);

        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (den == 0) {
            return null;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

        if (t > 0 && t < 1 && u > 0) {
            double pointX = (x1 + t * (x2 - x1));
            double pointY = (y1 + t * (y2 - y1));
            return new PVector((float) pointX, (float) pointY);
        }
        return null;
    }

    void draw(PApplet pApplet) {
        pApplet.stroke(255, 10);
        pApplet.pushStyle();
        pApplet.popStyle();
    }
}
