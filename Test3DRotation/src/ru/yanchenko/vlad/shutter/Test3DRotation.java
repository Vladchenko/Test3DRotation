package ru.yanchenko.vlad.shutter;

import ru.yanchenko.vlad.shutter.data.ColoredPoint;
import ru.yanchenko.vlad.shutter.data.ScreenData;
import ru.yanchenko.vlad.shutter.representation.CubeDrawingPanel;
import ru.yanchenko.vlad.shutter.representation.DrawingFrame;

import static ru.yanchenko.vlad.shutter.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;

/** Entry point for an application */
public class Test3DRotation {
    public static void main(String[] args) {
        ScreenData screenData = new ScreenData();
        ColoredPoint[] coloredPoints = createAndPlaceBallsAsCube();
        new Repository(screenData, new DrawingFrame(new CubeDrawingPanel(coloredPoints, screenData), screenData), coloredPoints);
    }
}
