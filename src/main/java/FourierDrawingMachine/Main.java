package FourierDrawingMachine;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Main extends PApplet {


    private double timeSpan = 0.005;
    private PApplet pApplet;
    private List<ComplexNumber> fourierY;
    private List<ComplexNumber> fourierX;

    public static void main(String[] args) {
        PApplet.main("FourierDrawingMachine.Main", args);
    }

    public void settings() {
        size(1800, 800);
        pApplet = this;
    }

    public void setup() {
        List<Float> y = new ArrayList<>();
        List<Float> x = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            float angle = map(i, 0, 100, 0, TWO_PI);
            x.add(200 * noise(i / 50f + 12));
            y.add(200 * noise(i / 50f + 10000)+ 300);
        }


        Fourier fourier = new Fourier(pApplet);
        fourierX = fourier.dft(x);
        fourierY = fourier.dft(y);
    }

    private float time = 0;
    private Deque<PVector> path = new LinkedList<>();


    public void draw() {
        background(0);

        PVector vx = epicycles(400, 150, 0, fourierX);
        PVector vy = epicycles(150, 400, HALF_PI, fourierY);

        PVector v = new PVector(vx.x, vy.y);
        path.add(v);

        float dt = TWO_PI / fourierY.size();
        time += dt;
        line(vx.x, vx.y, v.x, v.y);
        line(vy.x, vy.y, v.x, v.y);
        drawPath((List<PVector>) path);
    }

    private PVector epicycles(float x, float y, float rotation, List<ComplexNumber> fourier) {
        for (ComplexNumber complexNumber : fourier) {

            float prevx = x;
            float prevy = y;

            float freq = complexNumber.getFreq();
            float radius = complexNumber.getAmp();
            float phase = complexNumber.getPhase();


            x += radius * cos(freq * time + phase + rotation);
            y += radius * sin(freq * time + phase + rotation);

            stroke(255, 100);
            noFill();
            ellipse(prevx, prevy, radius * 2, radius * 2);
            fill(255);
            stroke(255);
            line(prevx, prevy, x, y);
        }
        return new PVector(x, y);
    }

    private void drawPath(List<PVector> path) {

        beginShape();
        noFill();
        for (PVector pVector : path) {
            vertex(pVector.x, pVector.y
            );
        }
        endShape();
    }

    public void keyPressed() {
        if (keyCode == LEFT && timeSpan > 0.005) {
            timeSpan -= 0.005;
        } else if (keyCode == RIGHT && timeSpan < 0.05) {
            timeSpan += 0.005;
        }
    }
}
