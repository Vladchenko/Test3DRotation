package ru.yanchenko.vlad.shutter.utils;

import ru.yanchenko.vlad.shutter.data.ColoredPoint;
import ru.yanchenko.vlad.shutter.data.DekartPoint;

import java.awt.*;
import java.util.Random;

/**
 * Utils to generate balls.
 */
public final class BallsGenerationUtils {

    private BallsGenerationUtils() {
        throw new IllegalStateException("Should not instantiate BallsGenerationUtils class");
    }

    /**
     * @param ballsNumber of balls to be created
     * @param range       that balls are to be scattered within
     * @return Balls scattered at random.
     */
    public static ColoredPoint[] randomizeBalls(int ballsNumber, int range) {
        ColoredPoint[] coloredPoints = new ColoredPoint[ballsNumber];
        Random random = new Random();
        for (int i = 0; i < coloredPoints.length; i++) {
            coloredPoints[i] = new ColoredPoint(new DekartPoint(
                    Math.random() * range - range / 2.0,
                    Math.random() * range - range / 2.0,
                    Math.random() * range - range / 2.0),
                    new Color(random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256)));
        }
        return coloredPoints;
    }

    /**
     * @return 8 {@link ColoredPoint[]} scattered as a cube
     */
    public static ColoredPoint[] createAndPlaceBallsAsCube() {
        ColoredPoint[] coloredPoints = new ColoredPoint[8];
        coloredPoints[0] = new ColoredPoint(new DekartPoint(
                300,
                300,
                300),
                Color.WHITE);
        coloredPoints[1] = new ColoredPoint(new DekartPoint(
                -300,
                300,
                300),
                Color.WHITE);
        coloredPoints[2] = new ColoredPoint(new DekartPoint(
                -300,
                -300,
                300),
                Color.WHITE);
        coloredPoints[3] = new ColoredPoint(new DekartPoint(
                300,
                -300,
                300),
                Color.WHITE);
        coloredPoints[4] = new ColoredPoint(new DekartPoint(
                300,
                300,
                -300),
                Color.WHITE);
        coloredPoints[5] = new ColoredPoint(new DekartPoint(
                -300,
                300,
                -300),
                Color.WHITE);
        coloredPoints[6] = new ColoredPoint(new DekartPoint(
                -300,
                -300,
                -300),
                Color.WHITE);
        coloredPoints[7] = new ColoredPoint(new DekartPoint(
                300,
                -300,
                -300),
                Color.WHITE);
        return coloredPoints;
    }
}
