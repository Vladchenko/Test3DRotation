package ru.yanchenko.vlad.test3drotation.userinteraction.processors;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.MouseDraggedEventCallback;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;

import java.awt.*;
import java.util.List;

/**
 * Processes a user activity - keyboard and mouse events.
 */
public class MouseInteractionProcessor implements MouseDraggedEventCallback {

    //region Fields
    private static final double ORDINATE_VALUE_DIVIDER = 100.0;
    private final List<ColoredPoint> coloredPoints;
    //endregion Fields

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param coloredPoints to draw on a JFrame
     */
    public MouseInteractionProcessor(List<ColoredPoint> coloredPoints) {
        this.coloredPoints = coloredPoints;
    }

    @Override
    public void rotateByXAndY(Point point) {
        for (ColoredPoint coloredPoint : coloredPoints) {
            GeometryUtils.rotateByX(-point.getX() / ORDINATE_VALUE_DIVIDER, coloredPoint);
        }
        for (ColoredPoint coloredPoint : coloredPoints) {
            GeometryUtils.rotateByY(-point.getY() / ORDINATE_VALUE_DIVIDER, coloredPoint);
        }
    }
}
