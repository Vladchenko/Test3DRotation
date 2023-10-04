package ru.yanchenko.vlad.shutter.data;

import java.awt.*;

/**
 * TODO
 */
public class Ball {
    private DekartPoint dekartPoint;
    private Color color;

    /**
     * TODO
     *
     * @param dekartPoint
     * @param color
     */
    public Ball(DekartPoint dekartPoint, Color color) {
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
