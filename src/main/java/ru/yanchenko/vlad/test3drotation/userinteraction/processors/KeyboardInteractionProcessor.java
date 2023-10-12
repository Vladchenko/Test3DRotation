package ru.yanchenko.vlad.test3drotation.userinteraction.processors;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.KeyEventCallback;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingType;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import java.awt.event.KeyEvent;
import java.util.List;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;
import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.randomizeBalls;

/**
 * Processes a user activity - keyboard and mouse events.
 */
public class KeyboardInteractionProcessor implements KeyEventCallback {

    //region Fields
    private final int range;
    private final double angle;
    private final int pointsNumber;
    private final List<ColoredPoint> coloredPoints;
    private DrawingType drawingType = DrawingType.BALLS;

    private final DrawingFrame drawingFrame;
    private final PointComparator pointComparator;
    //endregion Fields

    /**
     * Public constructor. Sets params and creates an instance.
     * <p>
     * @param range           within which to randomize a colored points
     * @param angle           in radians that model is to be rotated on.
     * @param pointsNumber    of points to be created
     * @param drawingFrame    to draw graphics on
     * @param pointComparator to compare a points and later sort them
     * @param coloredPoints   to draw on a JFrame
     */
    public KeyboardInteractionProcessor(int range,
                                        double angle,
                                        int pointsNumber,
                                        DrawingFrame drawingFrame,
                                        PointComparator pointComparator,
                                        List<ColoredPoint> coloredPoints) {
        this.angle = angle;
        this.range = range;
        this.pointsNumber = pointsNumber;
        this.drawingFrame = drawingFrame;
        this.coloredPoints = coloredPoints;
        this.pointComparator = pointComparator;
        this.drawingFrame.setKeyListener(new FrameKeyListener(this));
    }

    @Override
    public void getKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByX(-angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByX(angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByY(angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByY(-angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == '[') {
            for (ColoredPoint ColoredPoint : coloredPoints) {
                GeometryUtils.rotateByZ(angle, ColoredPoint);
            }
        }

        if (keyEvent.getKeyCode() == ']') {
            for (ColoredPoint ColoredPoint : coloredPoints) {
                GeometryUtils.rotateByZ(-angle, ColoredPoint);
            }
        }

        if (keyEvent.getKeyCode() == ' ') {
            defineDrawContentAndDraw();
        }
        drawingFrame.repaint();
    }

    private void defineDrawContentAndDraw() {
        if (drawingType == DrawingType.CUBE) {
            createAndPlaceBallsAsCube(coloredPoints);
            drawingFrame.drawContents(DrawingType.CUBE);
            drawingType = DrawingType.BALLS;
        } else {
            randomizeBalls(coloredPoints, pointsNumber, range);
            coloredPoints.sort(pointComparator);
            drawingFrame.drawContents(DrawingType.BALLS);
            drawingType = DrawingType.CUBE;
        }
    }
}
