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

    public List<ComplexNumber> dftForComplexNumbers(List<ComplexNumber> x) {
        List<ComplexNumber> X = new ArrayList<>();
        int N = x.size();

        for (int k = 0; k < N; k++) {
            ComplexNumber sum = new ComplexNumber(0,0);

            for (int n = 0; n < N; n++) {
                float phi = (p.TWO_PI * k * n) / N;

                ComplexNumber c = new ComplexNumber(p.cos(phi), -p.sin(phi));

                ComplexNumber mult = x.get(n).mult(c);
                sum = sum.add(mult);
            }
            sum.setRe(sum.getRe()/N);
            sum.setIm(sum.getIm() /N);

            float freq = k;
            float amp = p.sqrt(sum.getRe()*sum.getRe() + sum.getIm()*sum.getIm());
            float phase = p.atan2(sum.getIm(), sum.getRe());

            ComplexNumber cn = new ComplexNumber(sum.getRe(), sum.getIm(), freq, amp, phase);
            X.add(cn);
        }
        return X;
    }
}
