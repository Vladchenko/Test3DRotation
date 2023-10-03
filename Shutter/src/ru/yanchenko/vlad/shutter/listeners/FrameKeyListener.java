/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.shutter.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ru.yanchenko.vlad.shutter.Repository;

/**
 *
 * @author Влад
 */
public class FrameKeyListener implements KeyListener {

    private final Repository oRepository = Repository.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ALT) {
            oRepository.setKeyAlt(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            oRepository.setKeyCtrl(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            oRepository.setKeyShift(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            oRepository.getoLogic().rotateByZ(0.01);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_LEFT) {
            oRepository.getoLogic().rotateByZ(-0.01);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ALT) {
            oRepository.setKeyAlt(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            oRepository.setKeyCtrl(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            oRepository.setKeyShift(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_RIGHT) {
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_LEFT) {
        }        
    }

}
