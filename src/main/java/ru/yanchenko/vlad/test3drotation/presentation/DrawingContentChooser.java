package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import java.util.List;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;
import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.randomizeBalls;

/**
 * Defines a JPanel to be drawn
 */
public class DrawingContentChooser {

    private final int range;
    private final int pointsNumber;
    private final DrawingFrame drawingFrame;
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
                                 DrawingFrame drawingFrame,
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
     * Define a JPanel to draw graphics on.
     */
    public void defineDrawContents() {
        if (drawingFrame.getContentPane().getClass() == BallsDrawingPanel.class) {
            createAndPlaceBallsAsCube(coloredPoints);
            drawingFrame.setContentPane(drawingPanelsFactory.getDrawingPanel(CubeDrawingPanel.class));
        } else {
            randomizeBalls(coloredPoints, pointsNumber, range);
            coloredPoints.sort(pointComparator);
            drawingFrame.setContentPane(drawingPanelsFactory.getDrawingPanel(BallsDrawingPanel.class));
        }
    }
}
