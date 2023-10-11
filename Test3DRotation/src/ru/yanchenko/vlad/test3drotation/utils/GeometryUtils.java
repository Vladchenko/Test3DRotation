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
     * Rotate colored point around an X axis
     *
     * @param angle for a point to be rotated on
     * @param coloredPoint to be rotated
     */
    public static void rotateByX(double angle, ColoredPoint coloredPoint) {
        double y = coloredPoint.getDekartPoint().getY();
        coloredPoint.getDekartPoint().setY(
                coloredPoint.getDekartPoint().getY() * Math.cos(angle) + coloredPoint.getDekartPoint().getZ() * Math.sin(angle)
        );
        coloredPoint.getDekartPoint().setZ(
                - y * Math.sin(angle) + coloredPoint.getDekartPoint().getZ() * Math.cos(angle)
        );
    }

    /**
     * Rotate colored point around an Y axis
     *
     * @param angle for a point to be rotated on
     * @param coloredPoint to be rotated
     */
    public static void rotateByY(double angle, ColoredPoint coloredPoint) {
        double x = coloredPoint.getDekartPoint().getX();
        coloredPoint.getDekartPoint().setX(
                coloredPoint.getDekartPoint().getX() * Math.cos(angle) + coloredPoint.getDekartPoint().getZ() * Math.sin(angle)
        );
        coloredPoint.getDekartPoint().setZ(
                - x * Math.sin(angle) + coloredPoint.getDekartPoint().getZ() * Math.cos(angle)
        );
    }

    /**
     * Rotate colored point around an Z axis
     *
     * @param angle for a point to be rotated on
     * @param coloredPoint to be rotated
     */
    public static void rotateByZ(double angle, ColoredPoint coloredPoint) {
        double x = coloredPoint.getDekartPoint().getX();
        coloredPoint.getDekartPoint().setX(
                coloredPoint.getDekartPoint().getX() * Math.cos(angle) + coloredPoint.getDekartPoint().getY() * Math.sin(angle)
        );
        coloredPoint.getDekartPoint().setY(
                - x * Math.sin(angle) + coloredPoint.getDekartPoint().getY() * Math.cos(angle)
        );
    }
}
