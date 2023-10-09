package ru.yanchenko.vlad.shutter.representation;

import ru.yanchenko.vlad.shutter.data.ColoredPoint;
import ru.yanchenko.vlad.shutter.data.ScreenData;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 */
public class CubeDrawingPanel extends JPanel {

    private final int xShift;
    private final int yShift;
    private final ColoredPoint[] coloredPoints;
    private final float[] cubeRibGradientThresholds = new float[]{0.0f, 0.4f, 0.6f, 1.0f};
    private final Color[] cubeRibGradientColors = new Color[]{
            new Color(255, 255, 255, 255),
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 0),
            new Color(255, 255, 255, 255)
    };

    /**
     * TODO
     * @param coloredPoints
     */
    public CubeDrawingPanel(ColoredPoint[] coloredPoints, ScreenData screenData) {
        this.coloredPoints = coloredPoints;
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

    private void drawCubeRib(ColoredPoint[] coloredPoints, Graphics2D g2, int ball1Index, int ball2Index) {
        if (coloredPoints[ball1Index].getDekartPoint().getX() != coloredPoints[ball2Index].getDekartPoint().getX()
                || coloredPoints[ball1Index].getDekartPoint().getY() != coloredPoints[ball2Index].getDekartPoint().getY()) {

            double x1 = coloredPoints[ball1Index].getDekartPoint().getX() + xShift;
            double y1 = coloredPoints[ball1Index].getDekartPoint().getY() + yShift;
            double x2 = coloredPoints[ball2Index].getDekartPoint().getX() + xShift;
            double y2 = coloredPoints[ball2Index].getDekartPoint().getY() + yShift;

            LinearGradientPaint gradientPaint = new LinearGradientPaint(
                    (float) x1, (float) y1, (float) x2, (float) y2,
                    cubeRibGradientThresholds,
                    cubeRibGradientColors
            );

            g2.setPaint(gradientPaint);

            g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }
}
