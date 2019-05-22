package RaycastingDoom;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends PApplet {

    private PApplet pApplet;
    private List<Boundary> walls = new ArrayList<>();
    private Particle particle;
    int sceneH = 800;
    int sceneW = 800;


    public static void main(String[] args) {
        PApplet.main("RaycastingDoom.Main", args);
    }

    public void setup() {
        generateBoundaries();
        particle = new Particle(pApplet);

    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            particle.rotate(-0.1f);
        } else if (keyCode == RIGHT) {
            particle.rotate(0.1f);
        } else if (keyCode == UP) {
            particle.move(1);
        } else if (keyCode == DOWN) {
            particle.move(1);
        }
    }

    private void generateBoundaries() {
        walls.add(new Boundary(0,0,sceneW,0));
        walls.add(new Boundary(sceneW,0,sceneW,sceneH));
        walls.add(new Boundary(sceneW,sceneH,0,sceneH));
        walls.add(new Boundary(0,sceneH,0,0));

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Boundary b = new Boundary(random.nextInt(900), random.nextInt(900),
                    random.nextInt(900), random.nextInt(900));
            walls.add(b);
        }
    }

    public void draw() {
        background(0);

        walls.forEach(x -> x.draw(pApplet));

        particle.show();
//        particle.update(mouseX, mouseY);
        List<Float> scene = particle.look(walls, pApplet);

        int w = sceneW / scene.size();

        pushStyle();
        translate(sceneW, 0);
        for (int i = 0; i < scene.size(); i++) {
            noStroke();
            float sq = scene.get(i) * scene.get(i);
            float wSq = sceneW * sceneW;
            float b = map(sq, 0, wSq, 255, 0);
            float h = map(scene.get(i), 0, sceneW, sceneH, 0);
            fill(b);
            rectMode(CENTER);
            rect(i*w + w/2, sceneH/2, w+1, h);
        }
        popStyle();

    }

    public void settings() {
//        fullScreen();

        size(1600, 800);
        pApplet = this;
    }


}
