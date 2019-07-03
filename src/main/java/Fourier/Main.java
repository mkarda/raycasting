package Fourier;

import FourierUtils.FourierDrawing;
import processing.core.PApplet;

import java.util.Deque;
import java.util.LinkedList;

public class Main extends PApplet {

    FourierDrawing fDrawing;

    private int circles = 1;
    private double timeSpan = 0.02;

    public static void main(String[] args) {
        PApplet.main("Fourier.Main", args);
    }

    public void setup() {
        fDrawing = new FourierDrawing(this);
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

        time += timeSpan;
        wave.addFirst(y);
        fDrawing.drawWave(x, y, (LinkedList) wave);

    }



    public void keyPressed() {
        if (keyCode == UP && circles < 30) {
            circles += 1;
        } else if (keyCode == DOWN && circles > 1) {
            circles -= 1;
        } else if (keyCode == LEFT && timeSpan > 0.005) {
            timeSpan -= 0.005;
        } else if (keyCode == RIGHT && timeSpan < 0.05) {
            timeSpan += 0.005;
        }
    }
}
