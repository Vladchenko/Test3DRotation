package ru.yanchenko.vlad.test3drotation.userinteraction.processors;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.KeyEventCallback;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingType;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Processes a user activity - keyboard and mouse events.
 */
public class KeyboardInteractionProcessor implements KeyEventCallback {

    //region Fields
    private final double angle;
    private final List<ColoredPoint> coloredPoints;
    private DrawingType drawingType = DrawingType.BALLS;

    private final DrawingFrame drawingFrame;
    //endregion Fields

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param angle         in radians that model is to be rotated on.
     * @param drawingFrame  to draw graphics on
     * @param coloredPoints to draw on a JFrame
     */
    public KeyboardInteractionProcessor(double angle,
                                        DrawingFrame drawingFrame,
                                        List<ColoredPoint> coloredPoints) {
        this.angle = angle;
        this.drawingFrame = drawingFrame;
        this.coloredPoints = coloredPoints;
        this.drawingFrame.setKeyListener(new FrameKeyListener(this));
    }

    @Override
    public void getKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByX(angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByX(-angle, coloredPoint);
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
            drawingFrame.drawContents(DrawingType.CUBE);
            drawingType = DrawingType.BALLS;
        } else {
            drawingFrame.drawContents(DrawingType.BALLS);
            drawingType = DrawingType.CUBE;
        }
    }
}
