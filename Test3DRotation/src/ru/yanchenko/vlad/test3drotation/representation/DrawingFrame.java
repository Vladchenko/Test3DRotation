package ru.yanchenko.vlad.test3drotation.representation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.listeners.FrameMouseMotionListener;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;
import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.randomizeBalls;

/**
 * This JFrame is to draw graphics onto, using JPanel as a content pane.
 */
public class DrawingFrame extends JFrame {

    // Number of dots present in one circle.
    private final int ballsNumber = 100;
    // Range in px that balls will be scattered within.
    private final int range = 900;
    private final ScreenData screenData;
    private ColoredPoint[] coloredPoints;
    private final PointComparator pointComparator;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param screenData to provide data on it
     */
    public DrawingFrame(JPanel panel,
                        ScreenData screenData,
                        ColoredPoint[] coloredPoints,
                        PointComparator pointComparator) {
        this.screenData = screenData;
        this.coloredPoints = coloredPoints;
        this.pointComparator = pointComparator;
        setSize(screenData.getScreenWidth(), screenData.getScreenHeight());
        setLocationRelativeTo(null);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            setUndecorated(true);
        } catch (IllegalComponentStateException ex) {
        }
        setLayout(null);
        setBackground(screenData.getWindowBackgroundColor());
        setVisible(true);
        requestFocus();
        panel.repaint();
    }

    /**
     * Draws points on a content pane.
     *
     * @param drawingType   defines a content to be drawn
     */
    public ColoredPoint[] drawContents(DrawingType drawingType) {
        if (drawingType == DrawingType.CUBE) {
            coloredPoints = createAndPlaceBallsAsCube();
            setContentPane(new CubeDrawingPanel(coloredPoints, screenData));
        } else {
            coloredPoints = randomizeBalls(ballsNumber, range);
            Arrays.sort(coloredPoints, pointComparator);
            setContentPane(new BallsDrawingPanel(coloredPoints, screenData, range));
        }
        setVisible(true);
        repaint();
        return coloredPoints;
    }

    public void setKeyListener(FrameKeyListener keyListener) {
        addKeyListener(keyListener);
    }

    public void setMouseMotionListener(FrameMouseMotionListener mouseMotionListener) {
        addMouseMotionListener(mouseMotionListener);
    }
}
