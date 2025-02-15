package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import javax.swing.*;
import java.util.List;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.*;

/**
 * Prepares JFrame, JPanels and presentation data to be drawn on a screen.
 */
public class DrawingContentChooser {

    private final int range;
    private final int pointsNumber;
    private final JFrame drawingFrame;
    private final PointComparator pointComparator;
    private final List<ColoredPoint> coloredPoints;
    private final DrawingPanelsFactory drawingPanelsFactory;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param range                within which to randomize a colored points
     * @param pointsNumber         of points to be created
     * @param drawingFrame         to draw graphics on
     * @param pointComparator      to sort points
     * @param coloredPoints        to be drawn on this JPanel
     * @param drawingPanelsFactory to provide a JPanels to draw graphics on
     */
    public DrawingContentChooser(int range,
                                 int pointsNumber,
                                 JFrame drawingFrame,
                                 PointComparator pointComparator,
                                 List<ColoredPoint> coloredPoints,
                                 DrawingPanelsFactory drawingPanelsFactory) {
        this.range = range;
        this.pointsNumber = pointsNumber;
        this.drawingFrame = drawingFrame;
        this.coloredPoints = coloredPoints;
        this.pointComparator = pointComparator;
        this.drawingPanelsFactory = drawingPanelsFactory;
    }

    /**
     * Define a JPanel and its contents to draw graphics on.
     *
     * @param drawingType type of contents to be drawn
     */
    public void defineDrawContents(DrawingType drawingType) {
        switch (drawingType) {
            case RIBBED_CUBE:
                createAndPlaceBallsAsCube(coloredPoints);
                break;
            case BALLS_IN_CUBE:
                randomizeBallsWithinCube(coloredPoints, pointsNumber, range);
                coloredPoints.sort(pointComparator);
                break;
            case BALLS_ON_CUBE:
                randomizeBallsOnCube(coloredPoints, pointsNumber, range);
                coloredPoints.sort(pointComparator);
                break;
            case BALLS_ON_SPHERE:
                randomizeBallsSpherically(coloredPoints, pointsNumber, range, false);
                coloredPoints.sort(pointComparator);
                break;
            case BALLS_IN_SPHERE:
                randomizeBallsSpherically(coloredPoints, pointsNumber, range, true);
                coloredPoints.sort(pointComparator);
                break;
            case BALLS_IN_ORDERED_SPHERE:
                createAndPlaceBallsAsOrderedSphere(coloredPoints, range);
                coloredPoints.sort(pointComparator);
                break;
        }
        drawingFrame.setContentPane(drawingPanelsFactory.getDrawingPanel(drawingType));
    }
}
