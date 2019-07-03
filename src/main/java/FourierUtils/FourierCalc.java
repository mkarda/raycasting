package FourierUtils;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class FourierCalc {

    private PApplet p;

    public FourierCalc(PApplet p) {
        this.p = p;
    }

    public List<ComplexNumber> dft(List<Float> x) {
        List<ComplexNumber> X = new ArrayList<>();
        int N = x.size();

        for (int k = 0; k < N; k++) {
            float re = 0;
            float im = 0;


            for (int n = 0; n < N; n++) {
                float phi = (p.TWO_PI * k * n) / N;
                re += x.get(n) * p.cos(phi);
                im -= x.get(n) * p.sin(phi);

            }
            re = re/N;
            im = im /N;
            float freq = k;
            float amp = p.sqrt(re*re + im*im);
            float phase = p.atan2(im, re);

            ComplexNumber cn = new ComplexNumber(re, im, freq, amp, phase);
            X.add(cn);
        }
        return X;
    }
}
