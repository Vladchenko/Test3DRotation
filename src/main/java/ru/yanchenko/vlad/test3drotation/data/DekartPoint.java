package ru.yanchenko.vlad.test3drotation.data;

/**
 * Dekart point that has 3 ordinates (x,y,z) to draw in 3-dimensional space.
 */
public class DekartPoint {
    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param x ordinate
     * @param y ordinate
     * @param z ordinate
     */
    public DekartPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
