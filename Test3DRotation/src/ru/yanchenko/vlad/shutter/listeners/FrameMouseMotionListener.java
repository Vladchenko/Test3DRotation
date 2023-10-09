/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.shutter.listeners;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * TODO
 *
 * @author Влад
 */
public class FrameMouseMotionListener implements MouseMotionListener {

    private MouseEvent mouseEvent;
    private final MouseDraggedEventCallback mouseEventCallback;

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
    }
}
