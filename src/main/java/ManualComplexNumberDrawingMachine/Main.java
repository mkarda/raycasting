package ManualComplexNumberDrawingMachine;

import FourierUtils.ComplexNumber;
import FourierUtils.FourierCalc;
import FourierUtils.FourierDrawing;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.*;

public class Main extends PApplet {

    private FourierDrawing fDrawing;

    private PApplet pApplet;
    private List<ComplexNumber> fourierX = new ArrayList<>();
    private Deque<PVector> path = new LinkedList<>();
    private Deque<PVector> drawing = new LinkedList<>();
    private State state;

    private float time = 0;

    public static void main(String[] args) {
        PApplet.main("ManualComplexNumberDrawingMachine.Main", args);
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
        time = 0;
        path.clear();
    }

    public void mouseReleased() {
        state = State.FOURIER;
        fourierX.clear();
        path.clear();

        List<ComplexNumber> x = new ArrayList<>();
        List<PVector> drawingList = (List<PVector>) drawing;

        for (PVector pVector : drawingList) {
//            x.add(pVector.x);
            x.add(new ComplexNumber(pVector.x, pVector.y));
        }

        FourierCalc fourier = new FourierCalc(pApplet);
        fourierX = fourier.dftForComplexNumbers(x);

        fourierX.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
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

            PVector v = fDrawing.epicycles(width / 2, height / 2, 0, fourierX, time);

            path.add(v);

            float dt = TWO_PI / fourierX.size();
            time += dt;
            fDrawing.drawPath((List<PVector>) path);
        }
    }
}
