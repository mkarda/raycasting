package ManualFourierDrawingMachine;

import FourierDrawingMachine.ComplexNumber;
import FourierDrawingMachine.Fourier;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.*;

public class Main extends PApplet {


    private PApplet pApplet;
    private List<ComplexNumber> fourierY = new ArrayList<>();
    private List<ComplexNumber> fourierX = new ArrayList<>();
    private Deque<PVector> path = new LinkedList<>();
    private Deque<PVector> drawing = new LinkedList<>();
    private State state;


    public static void main(String[] args) {
        PApplet.main("ManualFourierDrawingMachine.Main", args);
    }

    public void settings() {
        size(1800, 800);
        pApplet = this;
    }

    public void mousePressed() {
        state = State.USER;
        drawing.clear();
        fourierX.clear();
        fourierY.clear();
        time = 0;
        path.clear();
    }

    public void mouseReleased() {
        state = State.FOURIER;
        fourierX.clear();
        fourierY.clear();
        path.clear();

        List<Float> y = new ArrayList<>();
        List<Float> x = new ArrayList<>();
        List<PVector> drawingList = (List<PVector>) drawing;
        for (PVector pVector : drawingList) {
            x.add(pVector.x);
            y.add(pVector.y);
        }


        Fourier fourier = new Fourier(pApplet);
        fourierX = fourier.dft(x);
        fourierY = fourier.dft(y);

        fourierX.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
        fourierY.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
    }

    public void setup() {
        state = State.START;

    }

    private float time = 0;


    public void draw() {
        background(0);

        if (state == State.USER) {
            PVector point = new PVector(mouseX - width / 2, mouseY - height / 2);
            drawing.add(point);

            beginShape();
            stroke(255);
            noFill();
            for (PVector v : drawing) {
                vertex(v.x + width / 2f, v.y + height / 2f);
            }
            endShape();

        } else if (state == State.FOURIER) {

            PVector vx = epicycles(width / 2, 150, 0, fourierX);
            PVector vy = epicycles(150, height / 2, HALF_PI, fourierY);

            PVector v = new PVector(vx.x, vy.y);
            path.add(v);

            float dt = TWO_PI / fourierY.size();
            time += dt;
            line(vx.x, vx.y, v.x, v.y);
            line(vy.x, vy.y, v.x, v.y);
            drawPath((List<PVector>) path);
        }
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
    }
}
