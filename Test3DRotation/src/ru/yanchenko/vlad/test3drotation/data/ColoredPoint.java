package ru.yanchenko.vlad.test3drotation.data;

import java.awt.*;

/**
 * Dekart point that also has a color
 */
public class ColoredPoint {
    private DekartPoint dekartPoint;
    private Color color;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param dekartPoint
     * @param color
     */
    public ColoredPoint(DekartPoint dekartPoint, Color color) {
        this.setDekartPoint(dekartPoint);
        this.setColor(color);
    }

    public DekartPoint getDekartPoint() {
        return dekartPoint;
    }

    public void setDekartPoint(DekartPoint dekartPoint) {
        this.dekartPoint = dekartPoint;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
