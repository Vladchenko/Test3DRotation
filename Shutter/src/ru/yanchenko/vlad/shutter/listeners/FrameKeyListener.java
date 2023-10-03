/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.shutter.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ru.yanchenko.vlad.shutter.GeometryUtils;
import ru.yanchenko.vlad.shutter.Repository;
import ru.yanchenko.vlad.shutter.data.DekartPoint;

/**
 *
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
            for(DekartPoint dekartPoint: oRepository.getPoints()) {
                GeometryUtils.rotateByX(angle, dekartPoint);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            for(DekartPoint dekartPoint: oRepository.getPoints()) {
                GeometryUtils.rotateByX(-angle, dekartPoint);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            for(DekartPoint dekartPoint: oRepository.getPoints()) {
                GeometryUtils.rotateByY(angle, dekartPoint);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            for(DekartPoint dekartPoint: oRepository.getPoints()) {
                GeometryUtils.rotateByY(-angle, dekartPoint);
            }
        }

        if (e.getKeyCode() == '[') {
            for(DekartPoint dekartPoint: oRepository.getPoints()) {
                GeometryUtils.rotateByZ(angle, dekartPoint);
            }
        }

        if (e.getKeyCode() == ']') {
            for(DekartPoint dekartPoint: oRepository.getPoints()) {
                GeometryUtils.rotateByZ(-angle, dekartPoint);
            }
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
