package FourierUtils;

public class ComplexNumber {
    private float re;
    private float im;
    private float freq;
    private float amp;
    private float phase;

    public ComplexNumber(float re, float im, float freq, float amp, float phase) {
        this.re = re;
        this.im = im;
        this.freq = freq;
        this.amp = amp;
        this.phase = phase;
    }

    public ComplexNumber(float re, float im) {

        this.re = re;
        this.im = im;
    }


    public float getFreq() {
        return freq;
    }

    public float getAmp() {
        return amp;
    }

    public float getPhase() {
        return phase;
    }

    public float getRe() {
        return re;
    }

    public void setRe(float re) {
        this.re = re;
    }

    public float getIm() {
        return im;
    }

    public void setIm(float im) {
        this.im = im;
    }


    public ComplexNumber mult(ComplexNumber c) {
        float re = this.getRe() * c.getRe() - this.getIm() * c.getIm();
        float im = this.getRe() * c.getIm() + this.getIm() * c.getRe();
        return new ComplexNumber(re, im);
    }

    public ComplexNumber add(ComplexNumber c) {
        float re = this.getRe() + c.getRe();
        float im = this.getIm() + c.getIm();
        return new ComplexNumber(re, im);

    }
}
