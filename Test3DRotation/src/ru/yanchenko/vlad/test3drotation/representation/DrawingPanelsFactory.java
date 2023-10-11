package ru.yanchenko.vlad.test3drotation.representation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import javax.swing.*;
import java.util.List;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;
import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.randomizeBalls;

/**
 * Defines and retrieves JPanels for drawing.
 */
public class DrawingPanelsFactory {

    private final int range;
    private final int pointsNumber;
    private final ScreenData screenData;
    private final PointComparator pointComparator;
    private final List<ColoredPoint> coloredPoints;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param coloredPoints   of points to be drawn on some JPanel
     * @param pointComparator to compare a points and later sort them
     * @param screenData      to provide screen width, height, center point
     * @param pointsNumber    of points to be created
     * @param range           within which to randomize a colored points
     */
    public DrawingPanelsFactory(List<ColoredPoint> coloredPoints,
                                PointComparator pointComparator,
                                ScreenData screenData,
                                int pointsNumber,
                                int range) {
        this.range = range;
        this.screenData = screenData;
        this.pointsNumber = pointsNumber;
        this.coloredPoints = coloredPoints;
        this.pointComparator = pointComparator;
    }

    /**
     * Define a JPanel to draw graphics on
     *
     * @param drawingType to define what kind of JPanel to use
     * @return JPanel to draw graphics on
     */
    JPanel getDrawingPanel(DrawingType drawingType) {
        if (drawingType == DrawingType.CUBE) {
            createAndPlaceBallsAsCube(coloredPoints);
            return new CubeDrawingPanel(coloredPoints, screenData);
        } else {
            randomizeBalls(coloredPoints, pointsNumber, range);
            coloredPoints.sort(pointComparator);
            return new BallsDrawingPanel(coloredPoints, screenData, range);
        }
    }
}
