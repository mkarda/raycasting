package FourierDrawingMachine;

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
    private List<ComplexNumber> fourierY;
    private List<ComplexNumber> fourierX;

    public static void main(String[] args) {
        PApplet.main("FourierDrawingMachine.Main", args);
    }

    public void settings() {
        size(1800, 800);
        pApplet = this;
        fDrawing = new FourierDrawing(pApplet);
    }

    public void setup() {
        List<Float> y = new ArrayList<>();
        List<Float> x = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            x.add(400 * noise(i / 200f + 122));
            y.add(400 * noise(i / 200f + 142));
        }


        FourierCalc fourier = new FourierCalc(pApplet);
        fourierX = fourier.dft(x);
        fourierY = fourier.dft(y);

        fourierX.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
        fourierY.sort(Comparator.comparing(ComplexNumber::getAmp).reversed());
    }

    private float time = 0;
    private Deque<PVector> path = new LinkedList<>();


    public void draw() {
        background(0);

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

    public void keyPressed() {
        if (keyCode == LEFT && timeSpan > 0.005) {
            timeSpan -= 0.005;
        } else if (keyCode == RIGHT && timeSpan < 0.05) {
            timeSpan += 0.005;
        }
    }
}
