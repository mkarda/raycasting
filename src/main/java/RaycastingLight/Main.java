package RaycastingLight;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class Main extends PApplet {

    private PApplet pApplet;
    private List<Boundary> walls = new ArrayList<>();
    private Particle particle;


    public static void main(String[] args) {
        PApplet.main("RaycastingLight.Main", args);
    }

    public void setup() {
        generateBoundaries();
        particle = new Particle(pApplet);

    }

    private void generateBoundaries() {
        walls.add(new Boundary(0, 0, width, 0));
        walls.add(new Boundary(width, 0, width, height));
        walls.add(new Boundary(width, height, 0, height));
        walls.add(new Boundary(0, height, 0, 0));

        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            Boundary b = new Boundary(random.nextInt(900), random.nextInt(900),
                    random.nextInt(900), random.nextInt(900));
            walls.add(b);
        }
    }

    public void draw() {
        background(0);

        walls.forEach(x -> x.draw(pApplet));

        particle.show();
        particle.update(mouseX, mouseY);
        particle.look(walls, pApplet);

    }

    public void settings() {
//        fullScreen();

        size(1200, 1200);
        pApplet = this;
    }


}
