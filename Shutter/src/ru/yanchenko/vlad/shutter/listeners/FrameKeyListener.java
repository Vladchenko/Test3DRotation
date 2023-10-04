/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.shutter.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import ru.yanchenko.vlad.shutter.utils.GeometryUtils;
import ru.yanchenko.vlad.shutter.Repository;
import ru.yanchenko.vlad.shutter.data.Ball;
import ru.yanchenko.vlad.shutter.utils.PointComparator;

/**
 * @author Влад
 */
public class FrameKeyListener implements KeyListener {

    private double angle = 0.03;

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

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            for (Ball Ball : oRepository.getBalls()) {
                GeometryUtils.rotateByX(angle, Ball);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            for (Ball Ball : oRepository.getBalls()) {
                GeometryUtils.rotateByX(-angle, Ball);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (Ball Ball : oRepository.getBalls()) {
                GeometryUtils.rotateByY(angle, Ball);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (Ball Ball : oRepository.getBalls()) {
                GeometryUtils.rotateByY(-angle, Ball);
            }
        }

        if (e.getKeyCode() == '[') {
            for (Ball Ball : oRepository.getBalls()) {
                GeometryUtils.rotateByZ(angle, Ball);
            }
        }

        if (e.getKeyCode() == ']') {
            for (Ball Ball : oRepository.getBalls()) {
                GeometryUtils.rotateByZ(-angle, Ball);
            }
        }

        Arrays.sort(oRepository.getBalls(), new PointComparator());
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
