package ru.yanchenko.vlad.test3drotation.userinteraction.listeners;

import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.MouseDraggedEventCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Mouse buttons clicking listener for a JFrame that graphics to be drawn on.
 */
public class FrameMouseMotionListener implements MouseMotionListener, MouseListener {

    private MouseEvent mouseEvent;
    private final JFrame drawingFrame;
    private final MouseDraggedEventCallback mouseEventCallback;

    /**
     * Public constructor. Create an instance of class with the required parameters.
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

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseEvent = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not used
    }
}
