package RaycastingLight;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

class Particle {

    public static final int raysCount = 500;
    private PVector pos;
    private PApplet p;

    private List<Ray> rays = new ArrayList<>();

    Particle(PApplet p) {
        this.p = p;
        pos = new PVector(p.width / 2, p.height / 2);
        for (int a = 0; a < raysCount; a += 1) {

            double v = (360.0 / raysCount) * a;


            rays.add(new Ray(this.pos, p.radians((float) v)));
        }
    }

    void show() {
        p.fill(255);
        p.ellipse(pos.x, pos.y, 3, 3);

        for (Ray ray : rays) {
            ray.draw(p);
        }
    }

    void look(List<Boundary> walls, PApplet p) {

        for (int i = 0; i < rays.size(); i++) {
            Ray ray = rays.get(i);
            PVector closest = null;
            final float[] record = {Float.MAX_VALUE};
            for (Boundary wall : walls) {
                PVector point = ray.cast(wall);
                if (point != null) {
                    float dist = PVector.dist(this.pos, point);

                    if (dist < record[0]) {
                        record[0] = dist;
                        closest = point;
                    }
                }
            }

            if (closest != null) {
                p.colorMode(PConstants.HSB);
                p.stroke((i) % 360, 255, 255, 100);
//                p.stroke(255, 100);
                p.line(pos.x, pos.y, closest.x, closest.y);
            }
        }
    }

    public void update(int mouseX, int mouseY) {
        pos.set(mouseX, mouseY);

    }


}
