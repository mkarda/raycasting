package FourierDrawingMachine;

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

    public float getRe() {
        return re;
    }

    public float getIm() {
        return im;
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
}
