package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Panel to draw graphical cube.
 */
public class CubeDrawingPanel extends JPanel {

    private final float[] CUBE_RIB_GRADIENT_THRESHOLDS = {0.0f, 0.4f, 0.6f, 1.0f};
    private final Color[] CUBE_RIB_GRADIENT_COLORS = {
            new Color(255, 255, 255, 255),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(255, 255, 255, 255)
    };

    private final int xShift;
    private final int yShift;
    private final List<ColoredPoint> coloredPoints;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param coloredPointsList of points to be drawn on a JPanel
     * @param screenData        to provide screen width, height, center point
     */
    public CubeDrawingPanel(List<ColoredPoint> coloredPointsList, ScreenData screenData) {
        this.coloredPoints = coloredPointsList;
        this.xShift = screenData.getScreenCenterPoint().x;
        this.yShift = screenData.getScreenCenterPoint().y;
        this.setBackground(screenData.getWindowBackgroundColor());
    }

    @Override
    public void paintComponent(Graphics g) {

        // Erasing a previously drawn data
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Adding an antialiasing for graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        float[] dash1 = {1.0f, 1.0f};
        g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, dash1, 1.0f));

        drawCubeRib(coloredPoints, g2, 0, 1);
        drawCubeRib(coloredPoints, g2, 1, 2);
        drawCubeRib(coloredPoints, g2, 2, 3);
        drawCubeRib(coloredPoints, g2, 3, 0);
        drawCubeRib(coloredPoints, g2, 0, 4);
        drawCubeRib(coloredPoints, g2, 1, 5);
        drawCubeRib(coloredPoints, g2, 2, 6);
        drawCubeRib(coloredPoints, g2, 3, 7);
        drawCubeRib(coloredPoints, g2, 4, 5);
        drawCubeRib(coloredPoints, g2, 5, 6);
        drawCubeRib(coloredPoints, g2, 6, 7);
        drawCubeRib(coloredPoints, g2, 7, 4);
    }

    private void drawCubeRib(List<ColoredPoint> coloredPoints, Graphics2D g2, int ball1Index, int ball2Index) {

        double x1 = coloredPoints.get(ball1Index).getDekartPoint().getX() + xShift;
        double y1 = coloredPoints.get(ball1Index).getDekartPoint().getY() + yShift;
        double x2 = coloredPoints.get(ball2Index).getDekartPoint().getX() + xShift;
        double y2 = coloredPoints.get(ball2Index).getDekartPoint().getY() + yShift;

        if (x1 != x2 || y1 != y2) {

            LinearGradientPaint gradientPaint = new LinearGradientPaint(
                    (float) x1, (float) y1, (float) x2, (float) y2,
                    CUBE_RIB_GRADIENT_THRESHOLDS,
                    CUBE_RIB_GRADIENT_COLORS
            );

            g2.setPaint(gradientPaint);

            g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }
}
