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

    private final int range;
    private final int xShift;
    private final int yShift;
    private final List<ColoredPoint> coloredPoints;

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

        float[] dash1 = {1.0f, 1.0f};
        g2.setStroke(new BasicStroke(20,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND,
                1, dash1, 1.0f));

        float[] ballsGradientColorThreshold = new float[] {0.1f, 1.0f};
        Color blackColor = new Color(0,0,0,55);

        for (int i = 0; i < coloredPoints.size(); i++) {
            double radius = (coloredPoints.get(i).getDekartPoint().getZ() + range) / range * 20;
            double x = coloredPoints.get(i).getDekartPoint().getX() + xShift;
            double y = coloredPoints.get(i).getDekartPoint().getY() + yShift;
            Color[] ballsGradientColors = new Color[] {coloredPoints.get(i).getColor(), blackColor};

            RadialGradientPaint bgPaint = new RadialGradientPaint(
                    (float) x - 1,
                    (float) y - 1,
                    (float) radius / 2,
                    ballsGradientColorThreshold,
                    ballsGradientColors);

            g2.setPaint(bgPaint);

            g2.fillOval((int) (x - radius / 2), (int) (y - radius / 2), (int) radius, (int) radius);
        }

    }
}
