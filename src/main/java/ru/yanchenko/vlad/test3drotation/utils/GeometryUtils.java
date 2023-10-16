package ru.yanchenko.vlad.test3drotation.utils;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;

/**
 * Utils to operate with geometry.
 */
public final class GeometryUtils {

    private GeometryUtils() {
        throw new IllegalStateException("One should not instantiate GeometryUtils");
    }

    /**
     * Rotate a point around the X-axis
     *
     * @param angle        the angle in radians
     * @param coloredPoint the point to rotate
     */
    public static void rotateByX(double angle, ColoredPoint coloredPoint) {
        double y = coloredPoint.getDekartPoint().getY();
        double z = coloredPoint.getDekartPoint().getZ();

        double newY = y * Math.cos(angle) + z * Math.sin(angle);
        double newZ = -y * Math.sin(angle) + z * Math.cos(angle);

        coloredPoint.getDekartPoint().setY(newY);
        coloredPoint.getDekartPoint().setZ(newZ);
    }

    /**
     * Rotate a point around the Y-axis
     *
     * @param angle        for a point to be rotated on
     * @param coloredPoint to be rotated
     */
    public static void rotateByY(double angle, ColoredPoint coloredPoint) {
        double x = coloredPoint.getDekartPoint().getX();
        double z = coloredPoint.getDekartPoint().getZ();

        double newX = x * Math.cos(angle) + z * Math.sin(angle);
        double newZ = -x * Math.sin(angle) + z * Math.cos(angle);

        coloredPoint.getDekartPoint().setX(newX);
        coloredPoint.getDekartPoint().setZ(newZ);
    }

    /**
     * Rotate a point around the Z-axis
     *
     * @param angle        the angle in radians
     * @param coloredPoint the point to rotate
     */
    public static void rotateByZ(double angle, ColoredPoint coloredPoint) {
        double x = coloredPoint.getDekartPoint().getX();
        double y = coloredPoint.getDekartPoint().getY();

        double newX = x * Math.cos(angle) + y * Math.sin(angle);
        double newY = -x * Math.sin(angle) + y * Math.cos(angle);

        coloredPoint.getDekartPoint().setX(newX);
        coloredPoint.getDekartPoint().setY(newY);
    }
}
