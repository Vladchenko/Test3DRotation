package ru.yanchenko.vlad.shutter;

import ru.yanchenko.vlad.shutter.data.DekartPoint;

/**
 * Utils to operate with geometry.
 */
public final class GeometryUtils {

    private GeometryUtils() {
    }

    public static void rotateByX(double angle, DekartPoint dekartPoint) {
        dekartPoint.setY(
                dekartPoint.getY() * Math.cos(angle) + dekartPoint.getZ() * Math.sin(angle)
        );
        dekartPoint.setZ(
                - dekartPoint.getY() * Math.sin(angle) + dekartPoint.getZ() * Math.cos(angle)
        );
    }

    public static void rotateByY(double angle, DekartPoint dekartPoint) {
        dekartPoint.setX(
                dekartPoint.getX() * Math.cos(angle) + dekartPoint.getZ() * Math.sin(angle)
        );
        dekartPoint.setZ(
                - dekartPoint.getX() * Math.sin(angle) + dekartPoint.getZ() * Math.cos(angle)
        );
    }

    public static void rotateByZ(double angle, DekartPoint dekartPoint) {
        dekartPoint.setX(
                dekartPoint.getX() * Math.cos(angle) + dekartPoint.getY() * Math.sin(angle)
        );
        dekartPoint.setY(
                - dekartPoint.getX() * Math.sin(angle) + dekartPoint.getY() * Math.cos(angle)
        );
    }
}
