package RaycastingDoom;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Particle {

    private PVector pos;
    private PApplet p;

    private List<Ray> rays = new ArrayList<>();

    public Particle(PApplet p) {
        this.p = p;
        pos = new PVector(p.width / 2, p.height / 2);
        for (int a = -30; a < 30; a += 1) {
            rays.add(new Ray(this.pos, p.radians(a)));
        }
    }

    public void show() {
        p.fill(255);
        p.ellipse(pos.x, pos.y, 3, 3);

        for (Ray ray : rays) {
            ray.draw(p);
        }
    }

    public List<Float> look(List<Boundary> walls, PApplet p) {
        List<Float> scene = new ArrayList<>();
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
                p.stroke(255, 100);
                p.line(pos.x, pos.y, closest.x, closest.y);
            }
            scene.add(record[0]);
        }
        return scene;
    }

    List<Float> lookAtBoxes(List<Box> boxes, PApplet p) {
        List<Float> scene = new ArrayList<>();

        for (int i = 0; i < rays.size(); i++) {
            Ray ray = rays.get(i);
            PVector closest = null;
            final float[] record = {Float.MAX_VALUE};
            for (Box box : boxes) {
                PVector point = ray.cast(box);
            }


        }
        return null;
    }

    public void update(int mouseX, int mouseY) {
        pos.set(mouseX, mouseY);
    }

    float heading = 0;

    void rotate(float angle) {
        heading += angle;
        int index = 0;

        for (int a = -30; a < 30; a++) {
            rays.get(index).setAngle(p.radians(a) + heading);
            index++;
        }


    }

    public void move(float i) {
        PVector velocity = PVector.fromAngle(heading);
        velocity.setMag(i);
        pos.add(velocity);
    }
}
