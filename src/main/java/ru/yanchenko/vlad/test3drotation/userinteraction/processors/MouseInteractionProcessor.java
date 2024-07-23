package ru.yanchenko.vlad.test3drotation.userinteraction.processors;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingType;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingTypeChanger;
import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.MouseDraggedEventCallback;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import java.awt.*;
import java.util.List;

/**
 * Processes user interactions using mouse events.
 */
public class MouseInteractionProcessor implements MouseDraggedEventCallback {

    // Constants for rotation sensitivity
    private static final double X_ROTATION_SENSITIVITY = 0.01; // Adjust this value as needed
    private static final double Y_ROTATION_SENSITIVITY = 0.01; // Adjust this value as needed

    private final PointComparator pointComparator;
    private final List<ColoredPoint> coloredPoints;
    private final DrawingTypeChanger drawingTypeChanger;

    /**
     * Public constructor. Create an instance of class with the required parameters.
     *
     * @param pointComparator    sorts points
     * @param coloredPoints      list of ColoredPoints to apply rotations to.
     * @param drawingTypeChanger changes a type of drawing
     */
    public MouseInteractionProcessor(PointComparator pointComparator,
                                     List<ColoredPoint> coloredPoints,
                                     DrawingTypeChanger drawingTypeChanger) {
        this.coloredPoints = coloredPoints;
        this.pointComparator = pointComparator;
        this.drawingTypeChanger = drawingTypeChanger;
    }

    @Override
    public void rotateByXAndY(Point point) {
        double xRotation = -point.getX() * X_ROTATION_SENSITIVITY;
        double yRotation = -point.getY() * Y_ROTATION_SENSITIVITY;

        for (ColoredPoint coloredPoint : coloredPoints) {
            GeometryUtils.rotateByX(xRotation, coloredPoint);
            GeometryUtils.rotateByY(yRotation, coloredPoint);
        }

        if (drawingTypeChanger.getDrawingType() != DrawingType.RIBBED_CUBE) {
            coloredPoints.sort(pointComparator);
        }
    }
}
