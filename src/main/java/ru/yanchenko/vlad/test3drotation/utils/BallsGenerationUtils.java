package ru.yanchenko.vlad.test3drotation.utils;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.DekartPoint;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Utils to generate balls.
 */
public final class BallsGenerationUtils {

    private static final int MAX_COLOR_VALUE = 256;
    private static final int MAX_ORDINATE_VALUE = 300;

    private BallsGenerationUtils() {
        throw new IllegalStateException("Should not instantiate BallsGenerationUtils class");
    }

    /**
     * Clears a list of {@link ColoredPoint}, creates a new one and scatters them at random
     *
     * @param coloredPointsList that holds points to be drawn on {@link java.awt.Graphics}
     * @param pointsNumber      of points to be created
     * @param range             that points are to be scattered within
     */
    public static void randomizeBalls(List<ColoredPoint> coloredPointsList, int pointsNumber, int range) {
        Random random = new Random();
        coloredPointsList.clear();
        for (int i = 0; i < pointsNumber; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    Math.random() * range - range / 2.0,
                    Math.random() * range - range / 2.0,
                    Math.random() * range - range / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
    }

    /**
     * Clears and creates 8 {@link ColoredPoint} scattered as a cube
     */
    public static void createAndPlaceBallsAsCube(List<ColoredPoint> coloredPointsList) {
        coloredPointsList.clear();
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                -MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                -MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                -MAX_ORDINATE_VALUE,
                MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                -MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE),
                Color.WHITE));
        coloredPointsList.add(new ColoredPoint(new DekartPoint(
                MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE,
                -MAX_ORDINATE_VALUE),
                Color.WHITE));
    }
}
