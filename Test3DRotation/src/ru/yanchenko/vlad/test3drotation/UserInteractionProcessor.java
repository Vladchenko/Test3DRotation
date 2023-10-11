package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.listeners.FrameMouseMotionListener;
import ru.yanchenko.vlad.test3drotation.listeners.KeyEventCallback;
import ru.yanchenko.vlad.test3drotation.listeners.MouseDraggedEventCallback;
import ru.yanchenko.vlad.test3drotation.representation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.representation.DrawingType;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Processes a user activity - keyboard and mouse events.
 */
public class UserInteractionProcessor implements KeyEventCallback, MouseDraggedEventCallback {

    //region Fields
    private final double angle = 0.03;
    private final List<ColoredPoint> coloredPoints;
    private DrawingType drawingType = DrawingType.BALLS;

    private final DrawingFrame drawingFrame;
    //endregion Fields

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param drawingFrame  to draw graphics on
     * @param coloredPoints to draw on a JFrame
     */
    public UserInteractionProcessor(DrawingFrame drawingFrame,
                                    List<ColoredPoint> coloredPoints) {
        this.drawingFrame = drawingFrame;
        this.coloredPoints = coloredPoints;
        this.drawingFrame.setKeyListener(new FrameKeyListener(this));
        this.drawingFrame.setMouseMotionListener(new FrameMouseMotionListener(this));
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

    @Override
    public void getMouseDelta(Point point) {
        for (ColoredPoint coloredPoint : coloredPoints) {
            GeometryUtils.rotateByX(point.getX() / 100.0, coloredPoint);
        }
        for (ColoredPoint coloredPoint : coloredPoints) {
            GeometryUtils.rotateByY(point.getY() / 100.0, coloredPoint);
        }
        defineDrawContentAndDraw();
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
