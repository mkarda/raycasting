package FourierComplexNumberDrawingMachine;

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

    private double timeSpan = 0.005;
    private PApplet pApplet;
    private List<ComplexNumber> fourierX;

    public static void main(String[] args) {
        PApplet.main("FourierComplexNumberDrawingMachine.Main", args);
    }

    public void settings() {
        size(1800, 800);
        pApplet = this;
        fDrawing = new FourierDrawing(pApplet);
    }

    public void setup() {
        List<ComplexNumber> signal = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            float x = 400 * noise(i / 200f + 122);
            float y = 400 * noise(i / 200f + 142);
            ComplexNumber complexNumber = new ComplexNumber(x, y, 0,0,0);
            signal.add(complexNumber);
        }


        FourierCalc fourier = new FourierCalc(pApplet);
        fourierX = fourier.dftForComplexNumbers(signal);

        fourierX.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
    }

    private float time = 0;
    private Deque<PVector> path = new LinkedList<>();


    public void draw() {
        background(0);

        PVector v = fDrawing.epicycles(width / 2, height/2, 0, fourierX, time);
        path.add(v);

        float dt = TWO_PI / fourierX.size();
        time += dt;
        fDrawing.drawPath((List<PVector>) path);
    }

    public void keyPressed() {
        if (keyCode == LEFT && timeSpan > 0.005) {
            timeSpan -= 0.005;
        } else if (keyCode == RIGHT && timeSpan < 0.05) {
            timeSpan += 0.005;
        }
    }
}
