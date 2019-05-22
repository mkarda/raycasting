import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

class Photon {
    PVector pos, vel;
    ArrayList<PVector> history;
    boolean stopped;
    float theta;
    int c = 160;
    float dt = (float) 0.1;
    Photon(float x, float y) {
        this.pos = new PVector(x, y);
        this.vel = new PVector(-c, 0);
        this.history = new ArrayList<PVector>();
        this.stopped = false;
        this.theta = 0;
    }

    void stop() {
        this.stopped = true;
    }

    void update() {
        if (!this.stopped) {
            //if (frameCount % 5 == 0) {
            this.history.add(this.pos.copy());
            //}
            PVector deltaV = this.vel.copy();
            deltaV.mult(dt);
            this.pos.add(deltaV);
        }

        if (this.history.size() > 500) {
            this.history.remove(0);
        }
    }

    void show(PApplet p) {
        p.strokeWeight(4);
        p.stroke(255, 0, 0);
        p.point(this.pos.x, this.pos.y);

        p.strokeWeight(2);
        p.noFill();
        p.beginShape();
        for (PVector v : this.history) {
            p.vertex(v.x, v.y);
        }

        p.endShape();
    }
}