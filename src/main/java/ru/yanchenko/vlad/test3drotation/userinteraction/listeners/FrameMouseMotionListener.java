package ru.yanchenko.vlad.test3drotation.userinteraction.listeners;

import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.MouseDraggedEventCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Mouse buttons clicking listener for a JFrame that graphics to be drawn on.
 *
 * @author Влад
 */
public class FrameMouseMotionListener implements MouseMotionListener {

    private MouseEvent mouseEvent;
    private final JFrame drawingFrame;
    private final MouseDraggedEventCallback mouseEventCallback;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param mouseEventCallback of a mouse buttons typing events
     * @param drawingFrame       to draw graphics on
     */
    public FrameMouseMotionListener(JFrame drawingFrame,
                                    MouseDraggedEventCallback mouseEventCallback) {
        this.drawingFrame = drawingFrame;
        this.mouseEventCallback = mouseEventCallback;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mouseEvent != null) {
            mouseEventCallback.rotateByXAndY(new Point((mouseEvent.getY() - e.getY()), mouseEvent.getX() - e.getX()));
            drawingFrame.repaint();
        }
        if (mouseEvent != e) {
            mouseEvent = e;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Not used
    }
}
