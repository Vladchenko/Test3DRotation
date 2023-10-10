package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.listeners.FrameMouseMotionListener;
import ru.yanchenko.vlad.test3drotation.listeners.KeyEventCallback;
import ru.yanchenko.vlad.test3drotation.listeners.MouseDraggedEventCallback;
import ru.yanchenko.vlad.test3drotation.representation.BallsDrawingPanel;
import ru.yanchenko.vlad.test3drotation.representation.CubeDrawingPanel;
import ru.yanchenko.vlad.test3drotation.representation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;
import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.randomizeBalls;

/**
 * TODO
 */
public class Repository implements KeyEventCallback, MouseDraggedEventCallback {

    //region Fields
    private ColoredPoint[] coloredPoints;
    // Range in px that balls will be scattered within.
    private final int range = 900;
    private int presentationMode = 0;
    // Number of dots present in one circle.
    private final int ballsNumber = 100;

    private final ScreenData screenData;

    private final DrawingFrame drawingFrame;
    //endregion Fields

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param screenData    to know screen width, height, center
     * @param drawingFrame  to draw graphics on
     * @param coloredPoints to draw on a JFrame
     */
    public Repository(ScreenData screenData, DrawingFrame drawingFrame, ColoredPoint[] coloredPoints) {
        this.coloredPoints = coloredPoints;
        this.screenData = screenData;
        this.drawingFrame = drawingFrame;
        this.drawingFrame.setKeyListener(new FrameKeyListener(this));
        this.drawingFrame.setMouseMotionListener(new FrameMouseMotionListener(this));
    }


    @Override
    public void getKeyEvent(KeyEvent keyEvent) {

        double angle = 0.03;
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            for (ColoredPoint ColoredPoint : coloredPoints) {
                GeometryUtils.rotateByX(angle, ColoredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            for (ColoredPoint ColoredPoint : coloredPoints) {
                GeometryUtils.rotateByX(-angle, ColoredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (ColoredPoint ColoredPoint : coloredPoints) {
                GeometryUtils.rotateByY(angle, ColoredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            for (ColoredPoint ColoredPoint : coloredPoints) {
                GeometryUtils.rotateByY(-angle, ColoredPoint);
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
            JPanel panel;
            presentationMode++;
            if (presentationMode % 2 == 0) {
                coloredPoints = createAndPlaceBallsAsCube();
                panel = new CubeDrawingPanel(coloredPoints, screenData);
            } else {
                coloredPoints = randomizeBalls(ballsNumber, range);
                Arrays.sort(coloredPoints, new PointComparator());
                panel = new BallsDrawingPanel(coloredPoints, screenData, range);
            }
            drawingFrame.setContentPane(panel);
            drawingFrame.setVisible(true);
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
        JPanel panel;
        if (presentationMode % 2 == 0) {
            panel = new CubeDrawingPanel(coloredPoints, screenData);
        } else {
            Arrays.sort(coloredPoints, new PointComparator());
            panel = new BallsDrawingPanel(coloredPoints, screenData, range);
        }
        drawingFrame.setContentPane(panel);
        drawingFrame.setVisible(true);
    }

}
