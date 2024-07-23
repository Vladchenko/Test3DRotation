package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * JPanel to draw balls (colored points) on itself.
 */
public class BallsDrawingPanel extends JPanel {

    private static final int STROKE_SIZE = 20;
    private static final float[] STROKE_DASH = {1.0f, 1.0f};
    private static final float[] GRADIENT_COLOR_THRESHOLD = {0.1f, 1.0f};
    private static final Color BLACK_TRANSPARENT = new Color(0, 0, 0, 55);

    private final int range;
    private final int xShift;
    private final int yShift;
    private final transient List<ColoredPoint> coloredPoints;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param coloredPoints to be drawn on this JPanel
     * @param screenData    to know its width, height, center
     * @param range         within which to randomize a colored points
     */
    public BallsDrawingPanel(List<ColoredPoint> coloredPoints, ScreenData screenData, int range) {
        this.range = range;
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

        g2.setStroke(new BasicStroke(STROKE_SIZE,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND,
                1, STROKE_DASH, 1.0f));

        drawPoints(g2);

    }

    private void drawPoints(Graphics2D g2) {
        for (ColoredPoint coloredPoint : coloredPoints) {
            double radius = (coloredPoint.getDekartPoint().getZ() + range) / range * 20;
            double x = coloredPoint.getDekartPoint().getX() + xShift;
            double y = coloredPoint.getDekartPoint().getY() + yShift;
            Color[] ballsGradientColors = new Color[]{coloredPoint.getColor(), BLACK_TRANSPARENT};

            RadialGradientPaint bgPaint = new RadialGradientPaint(
                    (float) x - 1,
                    (float) y - 1,
                    (float) radius / 2,
                    GRADIENT_COLOR_THRESHOLD,
                    ballsGradientColors);

            g2.setPaint(bgPaint);

            g2.fillOval((int) (x - radius / 2), (int) (y - radius / 2), (int) radius, (int) radius);
        }
    }
}
