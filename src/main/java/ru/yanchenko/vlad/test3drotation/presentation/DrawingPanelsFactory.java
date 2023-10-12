package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
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
    private final PointComparator pointComparator;
    private final List<ColoredPoint> coloredPoints;
    private final CubeDrawingPanel cubeDrawingPanel;
    private final BallsDrawingPanel ballsDrawingPanel;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param coloredPoints   of points to be drawn on some JPanel
     * @param pointComparator to compare a points and later sort them
     * @param pointsNumber    of points to be created
     * @param range           within which to randomize a colored points
     */
    public DrawingPanelsFactory(BallsDrawingPanel ballsDrawingPanel,
                                CubeDrawingPanel cubeDrawingPanel,
                                List<ColoredPoint> coloredPoints,
                                PointComparator pointComparator,
                                int pointsNumber,
                                int range) {
        this.range = range;
        this.pointsNumber = pointsNumber;
        this.coloredPoints = coloredPoints;
        this.pointComparator = pointComparator;
        this.ballsDrawingPanel = ballsDrawingPanel;
        this.cubeDrawingPanel = cubeDrawingPanel;
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
            return cubeDrawingPanel;
        } else {
            randomizeBalls(coloredPoints, pointsNumber, range);
            coloredPoints.sort(pointComparator);
            return ballsDrawingPanel;
        }
    }
}
