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

    private static final int MAX_COLOR_VALUE = 255;
    private static final int MAX_ORDINATE_VALUE = 300;
    private static final Random random = new Random();

    private BallsGenerationUtils() {
        throw new IllegalStateException("Should not instantiate BallsGenerationUtils class");
    }

    /**
     * Clears a list of {@link ColoredPoint}, creates a new one and scatters them at random within a cube with each rib
     * equal to {@param range}.
     *
     * @param coloredPointsList that holds points to be drawn on {@link java.awt.Graphics}
     * @param pointsNumber      of points to be created
     * @param range             that points are to be scattered within
     */
    public static void randomizeBallsWithinCube(List<ColoredPoint> coloredPointsList, int pointsNumber, int range) {
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
     * Clears a list of {@link ColoredPoint}, creates a new one and scatters them at random on a surface of a cube.
     *
     * @param coloredPointsList that holds points to be drawn on {@link java.awt.Graphics}
     * @param pointsNumber      of points to be created
     * @param cubeSide          size of each side of a cube
     */
    public static void randomizeBallsOnCube(List<ColoredPoint> coloredPointsList, int pointsNumber, int cubeSide) {
        coloredPointsList.clear();
        for (int i = 0; i < pointsNumber / 6; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    Math.random() * cubeSide - cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0,
                    cubeSide / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
        for (int i = 0; i < pointsNumber / 6; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    Math.random() * cubeSide - cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0,
                    -cubeSide / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
        for (int i = 0; i < pointsNumber / 6; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    Math.random() * cubeSide - cubeSide / 2.0,
                    cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
        for (int i = 0; i < pointsNumber / 6; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    Math.random() * cubeSide - cubeSide / 2.0,
                    -cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
        for (int i = 0; i < pointsNumber / 6; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
        for (int i = 0; i < pointsNumber / 6; i++) {
            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    -cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0,
                    Math.random() * cubeSide - cubeSide / 2.0),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
    }

    /**
     * Randomly generates coordinates for balls.
     * https://karthikkaranth.me/blog/generating-random-points-in-a-sphere/
     *
     * @param coloredPointsList incorporate balls to draw
     * @param pointsNumber      represent a number of balls present on a screen
     * @param diameter          that balls are scattered within
     * @param insideSphere      defines whether balls are located within a sphere or on a surface of a sphere
     */
    public static void randomizeBallsSpherically(List<ColoredPoint> coloredPointsList, int pointsNumber,
                                                 int diameter, boolean insideSphere) {
        coloredPointsList.clear();
        double radius;
        for (int i = 0; i < pointsNumber; i++) {

            var u = Math.random();
            var v = Math.random();
            var theta = u * 2.0 * Math.PI;
            var phi = Math.acos(2.0 * v - 1.0);
            if (insideSphere) {
                radius = Math.cbrt(Math.random()) * diameter / 2;
            } else {
                radius = diameter / 2.0;
            }
            var sinTheta = Math.sin(theta);
            var cosTheta = Math.cos(theta);
            var sinPhi = Math.sin(phi);
            var cosPhi = Math.cos(phi);

            coloredPointsList.add(new ColoredPoint(new DekartPoint(
                    radius * sinPhi * cosTheta,
                    radius * sinPhi * sinTheta,
                    radius * cosPhi),
                    new Color(random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE),
                            random.nextInt(MAX_COLOR_VALUE))));
        }
    }

    public static void createAndPlaceBallsAsOrderedSphere(List<ColoredPoint> coloredPointsList, int diameter) {
        coloredPointsList.clear();
        double radius = diameter / 2.0;
        double u = 0;
        double v = 0.025;
        double theta;
        double phi;
        double step = 0.05;
        double sinTheta;
        double cosTheta;
        double sinPhi;
        double cosPhi;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                theta = u * 2.0 * Math.PI;
                phi = Math.acos(2.0 * v - 1.0);
                sinTheta = Math.sin(theta);
                cosTheta = Math.cos(theta);
                sinPhi = Math.sin(phi);
                cosPhi = Math.cos(phi);
                u += step;
                coloredPointsList.add(
                        new ColoredPoint(
                                new DekartPoint(
                                        radius * sinPhi * cosTheta,
                                        radius * sinPhi * sinTheta,
                                        radius * cosPhi),
                                new Color((int) (MAX_COLOR_VALUE - Math.abs(MAX_COLOR_VALUE * sinPhi * cosTheta)),
                                        (int) (MAX_COLOR_VALUE - Math.abs(MAX_COLOR_VALUE * sinPhi * sinTheta)),
                                        (int) (MAX_COLOR_VALUE - Math.abs(MAX_COLOR_VALUE * cosPhi * cosTheta)))
                        )
                );
            }
            v += step;
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
