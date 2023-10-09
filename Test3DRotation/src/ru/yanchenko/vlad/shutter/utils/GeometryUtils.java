package ru.yanchenko.vlad.shutter.utils;

import ru.yanchenko.vlad.shutter.data.ColoredPoint;

/**
 * Utils to operate with geometry.
 */
public final class GeometryUtils {

    private GeometryUtils() {
        throw new IllegalStateException("One should not instantiate GeometryUtils");
    }

    public static void rotateByX(double angle, ColoredPoint ColoredPoint) {
        double y = ColoredPoint.getDekartPoint().getY();
        ColoredPoint.getDekartPoint().setY(
                ColoredPoint.getDekartPoint().getY() * Math.cos(angle) + ColoredPoint.getDekartPoint().getZ() * Math.sin(angle)
        );
        ColoredPoint.getDekartPoint().setZ(
                - y * Math.sin(angle) + ColoredPoint.getDekartPoint().getZ() * Math.cos(angle)
        );
    }

    public static void rotateByY(double angle, ColoredPoint ColoredPoint) {
        double x = ColoredPoint.getDekartPoint().getX();
        ColoredPoint.getDekartPoint().setX(
                ColoredPoint.getDekartPoint().getX() * Math.cos(angle) + ColoredPoint.getDekartPoint().getZ() * Math.sin(angle)
        );
        ColoredPoint.getDekartPoint().setZ(
                - x * Math.sin(angle) + ColoredPoint.getDekartPoint().getZ() * Math.cos(angle)
        );
    }

    public static void rotateByZ(double angle, ColoredPoint ColoredPoint) {
        double x = ColoredPoint.getDekartPoint().getX();
        ColoredPoint.getDekartPoint().setX(
                ColoredPoint.getDekartPoint().getX() * Math.cos(angle) + ColoredPoint.getDekartPoint().getY() * Math.sin(angle)
        );
        ColoredPoint.getDekartPoint().setY(
                - x * Math.sin(angle) + ColoredPoint.getDekartPoint().getY() * Math.cos(angle)
        );
    }
}
