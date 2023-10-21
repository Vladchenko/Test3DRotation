package ru.yanchenko.vlad.test3drotation.data;

import java.awt.*;

/**
 * 3D dekart point that also has a color
 */
public class ColoredPoint {
    private DekartPoint dekartPoint;
    private Color color;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param dekartPoint   that has 3D ordinates to locate a point in 3D space
     * @param color         for dekartPoint
     */
    public ColoredPoint(DekartPoint dekartPoint, Color color) {
        this.setDekartPoint(dekartPoint);
        this.setColor(color);
    }

    /**
     * @return point with 3 dimensions
     */
    public DekartPoint getDekartPoint() {
        return dekartPoint;
    }

    /**
     * Set point with 3 dimensions
     *
     * @param dekartPoint point with 3 dimensions
     */
    public void setDekartPoint(DekartPoint dekartPoint) {
        this.dekartPoint = dekartPoint;
    }

    /**
     * @return color of dekartPoint
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set color for dekartPoint
     * @param color for dekartPoint
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
