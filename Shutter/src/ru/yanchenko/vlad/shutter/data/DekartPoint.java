package ru.yanchenko.vlad.shutter.data;

/**
 * TODO
 */
public class DekartPoint {
    private double x;
    private double y;
    private double z;

    public double getInversionMultiplier() {
        return inversionMultiplier;
    }

    public void setInversionMultiplier(double inversionMultiplier) {
        this.inversionMultiplier = inversionMultiplier;
    }

    private double inversionMultiplier = 1;

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

    public DekartPoint(double x, double y, double z, double inversionMultiplier) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.inversionMultiplier = inversionMultiplier;
    }
}
