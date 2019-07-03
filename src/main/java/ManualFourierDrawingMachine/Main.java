package ManualFourierDrawingMachine;

import FourierUtils.ComplexNumber;
import FourierUtils.FourierCalc;
import FourierUtils.FourierDrawing;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main extends PApplet {

    private FourierDrawing fDrawing;

    private PApplet pApplet;
    private List<ComplexNumber> fourierY = new ArrayList<>();
    private List<ComplexNumber> fourierX = new ArrayList<>();
    private Deque<PVector> path = new LinkedList<>();
    private Deque<PVector> drawing = new LinkedList<>();
    private State state;

    private float time = 0;

    public static void main(String[] args) {
        PApplet.main("ManualFourierDrawingMachine.Main", args);
    }

    public void settings() {
        size(1800, 800);
        pApplet = this;
        fDrawing = new FourierDrawing(pApplet);
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


        FourierCalc fourier = new FourierCalc(pApplet);
        fourierX = fourier.dft(x);
        fourierY = fourier.dft(y);

        fourierX.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
        fourierY.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
    }

    public void setup() {
        state = State.START;
    }


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

            PVector vx = fDrawing.epicycles(width / 2, 150, 0, fourierX, time);
            PVector vy = fDrawing.epicycles(150, height / 2, HALF_PI, fourierY, time);

            PVector v = new PVector(vx.x, vy.y);
            path.add(v);

            float dt = TWO_PI / fourierY.size();
            time += dt;
            line(vx.x, vx.y, v.x, v.y);
            line(vy.x, vy.y, v.x, v.y);
            fDrawing.drawPath((List<PVector>) path);
        }
    }
}
