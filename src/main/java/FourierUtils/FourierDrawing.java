package FourierUtils;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.List;

public class FourierDrawing {

    private PApplet p;

    public FourierDrawing(PApplet p) {
        this.p = p;
    }

    public void drawPath(List<PVector> path) {

        p.beginShape();
        p.noFill();
        for (PVector pVector : path) {
            p.vertex(pVector.x, pVector.y
            );
        }
        p.endShape();
    }

    public void drawWave(float x, float y, List<Float> wave) {
        p.translate(300 * 2, 0);
        p.line(x - 300 * 2, y, 0, wave.get(0));
        p.beginShape();
        p.noFill();
        for (int i = 0; i < wave.size(); i++) {
            p.vertex(i * 2, wave.get(i));
        }
        p.endShape();
        if (wave.size() > 1000) {
            wave.remove(wave.size() - 1);
        }
        System.out.println(wave.size());
    }

    public PVector epicycles(float x, float y, float rotation, List<ComplexNumber> fourier, float time) {
        for (ComplexNumber complexNumber : fourier) {

            float prevx = x;
            float prevy = y;

            float freq = complexNumber.getFreq();
            float radius = complexNumber.getAmp();
            float phase = complexNumber.getPhase();


            x += radius * p.cos(freq * time + phase + rotation);
            y += radius * p.sin(freq * time + phase + rotation);

            p.stroke(255, 100);
            p.noFill();
            p.ellipse(prevx, prevy, radius * 2, radius * 2);
            p.fill(255);
            p.stroke(255);
            p.line(prevx, prevy, x, y);
        }
        return new PVector(x, y);
    }
}
