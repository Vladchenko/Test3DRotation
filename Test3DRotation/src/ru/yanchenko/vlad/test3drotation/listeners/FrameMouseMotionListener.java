package ru.yanchenko.vlad.test3drotation.listeners;

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
    private final MouseDraggedEventCallback mouseEventCallback;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param mouseEventCallback of a mouse buttons typing events
     */
    public FrameMouseMotionListener(MouseDraggedEventCallback mouseEventCallback) {
        this.mouseEventCallback = mouseEventCallback;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mouseEvent != null) {
            mouseEventCallback.getMouseDelta(new Point((mouseEvent.getY() - e.getY()), mouseEvent.getX() - e.getX()));
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
