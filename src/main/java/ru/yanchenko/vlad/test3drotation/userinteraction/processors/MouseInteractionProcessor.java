package ru.yanchenko.vlad.test3drotation.userinteraction.processors;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.MouseDraggedEventCallback;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;

import java.awt.*;
import java.util.List;

/**
 * Processes user interactions using mouse events.
 */
public class MouseInteractionProcessor implements MouseDraggedEventCallback {

    // Constants for rotation sensitivity
    private static final double X_ROTATION_SENSITIVITY = 0.01; // Adjust this value as needed
    private static final double Y_ROTATION_SENSITIVITY = 0.01; // Adjust this value as needed

    private final List<ColoredPoint> coloredPoints;

    /**
     * Pun;ic constructor. Create a MouseInteractionProcessor with the given list of ColoredPoints.
     *
     * @param coloredPoints List of ColoredPoints to apply rotations to.
     */
    public MouseInteractionProcessor(List<ColoredPoint> coloredPoints) {
        this.coloredPoints = coloredPoints;
    }

    @Override
    public void rotateByXAndY(Point point) {
        double xRotation = -point.getX() * X_ROTATION_SENSITIVITY;
        double yRotation = -point.getY() * Y_ROTATION_SENSITIVITY;

        for (ColoredPoint coloredPoint : coloredPoints) {
            GeometryUtils.rotateByX(xRotation, coloredPoint);
            GeometryUtils.rotateByY(yRotation, coloredPoint);
        }
    }
}
