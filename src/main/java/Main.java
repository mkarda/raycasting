import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet pApplet;



    public static void main(String[] args) {
        PApplet.main("Main", args);

    }


    int G = 2;


    Blackhole m87;

    ArrayList<Photon> particles = new ArrayList<Photon>();
    float start, end;

    public void setup() {
        m87 = new Blackhole(width / 2, height / 2, 10000);
        m87.show(pApplet);

        start = height / 2;
        end = (float) (height / 2 - m87.rs * 2.6);

        for (int y = 0; y < height; y += 23) {
            particles.add(new Photon(width - 20, y));
        }
    }
    public void settings() {
//        size(1200, 1200);
                fullScreen();
        pApplet = this;
    }

    public void draw() {
        background(255);

        stroke(0);
        strokeWeight(1);
        line(0, start, width, start);
        line(0, end, width, end);

        for (Photon p : particles) {
            m87.pull(p);
            p.update();
            p.show(pApplet);
        }
        m87.show(pApplet);
    }



}
