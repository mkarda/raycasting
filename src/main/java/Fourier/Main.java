package Fourier;

import processing.core.PApplet;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main extends PApplet {


    private int circles = 1;

    public static void main(String[] args) {
        PApplet.main("Fourier.Main", args);
    }

    public void settings() {
        size(1800, 800);
    }


    private float time = 0;
    private Deque<Float> wave = new LinkedList<>();


    public void draw() {
        background(0);
        text(circles, 20, 20);
        int offset = 200;
        translate(offset + 200, offset + 200);

        float x = 0;
        float y = 0;


        for (int i = 0; i < circles; i++) {

            float prevx = x;
            float prevy = y;

            int n = i * 2 + 1;

            stroke(255, 100);
            noFill();
            float radius = offset * (4 / (n * PI));
            ellipse(prevx, prevy, radius * 2, radius * 2);

            x += radius * cos(n * time);
            y += radius * sin(n * time);

            fill(255);
            stroke(255);
            line(prevx, prevy, x, y);

        }
        time += 0.03;
        wave.addFirst(y);
        drawWave(x, y, (LinkedList) wave);

    }

    private void drawWave(float x, float y, List<Float> wave) {
        translate(200 * 2, 0);
        line(x - 200 * 2, y, 0, wave.get(0));
        beginShape();
        noFill();
        for (int i = 0; i < wave.size(); i++) {
            vertex(i * 2, wave.get(i));
        }
        endShape();
        if (wave.size() > 1000) {
            wave.remove(wave.size() - 1);
        }
        System.out.println(wave.size());
    }

    public void keyPressed() {
        if (keyCode == UP && circles < 30) {
            circles += 1;
        } else if (keyCode == DOWN && circles > 1) {
            circles -= 1;

        }
    }
}
