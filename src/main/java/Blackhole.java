import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.RADIUS;
import static processing.core.PGraphics.G;

class Blackhole {
    PVector pos;
    float mass, rs;
    int c = 30;
    float dt = (float) 0.1;
    Blackhole(float x, float y, float m) {
        this.pos = new PVector(x, y);
        this.mass = m;
        this.rs = (2 * G * this.mass) / (c * c);
    }

    void pull(Photon photon) {
        PVector force = PVector.sub(this.pos, photon.pos);
        float  r = force.mag();
        float  fg = G * this.mass / (r * r);
        force.setMag(fg);
        photon.vel.add(force);
        photon.vel.setMag(c);

        if (r < this.rs) {
            photon.stop();
        }
    }


    public void show(PApplet p) {
        p.ellipseMode(RADIUS);
        p.fill(0);
        p.noStroke();
        p.ellipse(this.pos.x, this.pos.y, this.rs, this.rs);

        p.noFill();
        p.stroke(100, 100);
        p.strokeWeight(64);
        p.ellipse(this.pos.x, this.pos.y, this.rs * 3 + 32, this.rs * 3 + 32);

        p.stroke(255, 150, 0, 100);
        p.strokeWeight(32);

        p.ellipse(this.pos.x, this.pos.y, (float)(this.rs * 1.5 + 16), (float)(this.rs * 1.5 + 16));


    }



}