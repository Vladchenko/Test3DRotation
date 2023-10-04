package ru.yanchenko.vlad.shutter.utils;

import ru.yanchenko.vlad.shutter.data.Ball;

/**
 * Utils to operate with geometry.
 */
public final class GeometryUtils {

    private GeometryUtils() {
    }

    public static void rotateByX(double angle, Ball Ball) {
        Ball.getDekartPoint().setY(
                Ball.getDekartPoint().getY() * Math.cos(angle) + Ball.getDekartPoint().getZ() * Math.sin(angle)
        );
        Ball.getDekartPoint().setZ(
                - Ball.getDekartPoint().getY() * Math.sin(angle) + Ball.getDekartPoint().getZ() * Math.cos(angle)
        );
    }

    public static void rotateByY(double angle, Ball Ball) {
        Ball.getDekartPoint().setX(
                Ball.getDekartPoint().getX() * Math.cos(angle) + Ball.getDekartPoint().getZ() * Math.sin(angle)
        );
        Ball.getDekartPoint().setZ(
                - Ball.getDekartPoint().getX() * Math.sin(angle) + Ball.getDekartPoint().getZ() * Math.cos(angle)
        );
    }

    public static void rotateByZ(double angle, Ball Ball) {
        Ball.getDekartPoint().setX(
                Ball.getDekartPoint().getX() * Math.cos(angle) + Ball.getDekartPoint().getY() * Math.sin(angle)
        );
        Ball.getDekartPoint().setY(
                - Ball.getDekartPoint().getX() * Math.sin(angle) + Ball.getDekartPoint().getY() * Math.cos(angle)
        );
    }
}
