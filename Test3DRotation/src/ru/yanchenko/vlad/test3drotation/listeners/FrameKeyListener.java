/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.test3drotation.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Влад
 */
public class FrameKeyListener implements KeyListener {

    private final KeyEventCallback callback;

    public FrameKeyListener(KeyEventCallback callback) {
        this.callback = callback;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        callback.getKeyEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

}
