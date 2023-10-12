package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.presentation.BallsDrawingPanel;
import ru.yanchenko.vlad.test3drotation.presentation.CubeDrawingPanel;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingPanelsFactory;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.KeyboardInteractionProcessor;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.MouseInteractionProcessor;
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
        // Angle in radians that model is to be rotated on.
        final double angle = 0.03;
        // Number of points to be drawn on a screen.
        final int pointsNumber = 100;

        // TODO Put all this to Dagger
        ScreenData screenData = new ScreenData();
        List<ColoredPoint> coloredPointList = new ArrayList<>();
        createAndPlaceBallsAsCube(coloredPointList);
        DrawingFrame drawingFrame = new DrawingFrame(
                screenData,
                new DrawingPanelsFactory(
                        new BallsDrawingPanel(coloredPointList, screenData, range),
                        new CubeDrawingPanel(coloredPointList, screenData),
                        coloredPointList,
                        new PointComparator(),
                        pointsNumber,
                        range)
        );
        new KeyboardInteractionProcessor(
                angle,
                drawingFrame,
                coloredPointList);
        new MouseInteractionProcessor(
                drawingFrame,
                coloredPointList);
    }
}
