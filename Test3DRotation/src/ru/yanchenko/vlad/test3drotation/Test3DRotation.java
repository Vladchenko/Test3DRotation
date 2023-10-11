package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.representation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.representation.DrawingPanelsFactory;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import java.util.ArrayList;
import java.util.List;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;

/**
 * Entry point for an application
 */
public class Test3DRotation {
    public static void main(String[] args) {

        // Range in px that balls will be scattered within.
        final int range = 900;
        // Number of points to be drawn on a screen.
        final int pointsNumber = 100;

        // TODO Put all this to Dagger
        ScreenData screenData = new ScreenData();
        List<ColoredPoint> coloredPointList = new ArrayList<>();
        createAndPlaceBallsAsCube(coloredPointList);
        new UserInteractionProcessor(
                new DrawingFrame(
                        screenData,
                        new DrawingPanelsFactory(
                                coloredPointList,
                                new PointComparator(),
                                screenData,
                                pointsNumber,
                                range)
                ),
                coloredPointList);
    }
}
