package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.representation.CubeDrawingPanel;
import ru.yanchenko.vlad.test3drotation.representation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;

/**
 * Entry point for an application
 */
public class Test3DRotation {
    public static void main(String[] args) {
        ScreenData screenData = new ScreenData();
        ColoredPoint[] coloredPoints = createAndPlaceBallsAsCube();
        new Repository(
                new DrawingFrame(
                        new CubeDrawingPanel(coloredPoints, screenData),
                        screenData,
                        coloredPoints,
                        new PointComparator()
                ),
                coloredPoints);
    }
}
