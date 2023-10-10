/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.test3drotation.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * TODO
 */
public class FrameMouseListener implements MouseListener {

    private final MouseClickedEventCallback mouseClickedEventCallback;

    /**
     * TODO
     * @param
     */
    public FrameMouseListener(MouseClickedEventCallback mouseClickedEventCallback) {
        this.mouseClickedEventCallback = mouseClickedEventCallback;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClickedEventCallback.getMouseClickedEvent(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not used
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
