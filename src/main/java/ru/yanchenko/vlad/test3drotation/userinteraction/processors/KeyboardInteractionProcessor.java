package ru.yanchenko.vlad.test3drotation.userinteraction.processors;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingContentChooser;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingTypeChanger;
import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.KeyEventCallback;
import ru.yanchenko.vlad.test3drotation.utils.GeometryUtils;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Processes a user activity - keyboard and mouse events.
 */
public class KeyboardInteractionProcessor implements KeyEventCallback {

    //region Fields
    private final double angle;
    private final List<ColoredPoint> coloredPoints;
    private final DrawingContentChooser drawingContentChooser;
    private final DrawingTypeChanger drawingTypeChanger;
    //endregion Fields

    /**
     * Public constructor. Sets params and creates an instance.
     * <p>
     *
     * @param angle                 in radians that model is to be rotated on.
     * @param coloredPoints         to draw on a JFrame
     * @param drawingTypeChanger    changes a type of drawing
     * @param drawingContentChooser defines a content to draw
     */
    public KeyboardInteractionProcessor(double angle,
                                        List<ColoredPoint> coloredPoints,
                                        DrawingTypeChanger drawingTypeChanger,
                                        DrawingContentChooser drawingContentChooser) {
        this.angle = angle;
        this.coloredPoints = coloredPoints;
        this.drawingTypeChanger = drawingTypeChanger;
        this.drawingContentChooser = drawingContentChooser;
    }

    @Override
    public void getKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByX(-angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByX(angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByY(angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByY(-angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == '[') {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByZ(angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == ']') {
            for (ColoredPoint coloredPoint : coloredPoints) {
                GeometryUtils.rotateByZ(-angle, coloredPoint);
            }
        }

        if (keyEvent.getKeyCode() == ' ') {
            drawingTypeChanger.changeDrawingType();
            drawingContentChooser.defineDrawContents(drawingTypeChanger.getDrawingType());
        }
    }
}
