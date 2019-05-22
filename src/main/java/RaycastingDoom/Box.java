package RaycastingDoom;

import processing.core.PApplet;

public class Box {
    private int intX;
    private int intY;
    private int width;
    private int height;


    public Box(int intX, int intY, int width, int height) {
        this.intX = intX;
        this.intY = intY;
        this.width = width;
        this.height = height;
    }

    void draw(PApplet p) {
        p.stroke(200);
        p.rect(intX, intY, width, height);
        p.fill(30);
    }
}
