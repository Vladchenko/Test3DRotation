/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yanchenko.vlad.shutter.listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ru.yanchenko.vlad.shutter.Logic;
import ru.yanchenko.vlad.shutter.Repository;

/**
 *
 * @author Влад
 */
public class FrameMouseListener implements MouseListener {

    private Repository oRepository = Repository.getInstance();

    @Override
    public void mouseClicked(MouseEvent e) {
//        oRepository.setConverge(true);
    }

    // !!! TO BE DONE
    @Override
    public void mousePressed(MouseEvent e) {

        //<editor-fold defaultstate="collapsed" desc="No ALT / CTRL / SHIFT keys pressed">
        if (!oRepository.isKeyAlt()
                && !oRepository.isKeyCtrl()
                && !oRepository.isKeyShift()) {

        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="When CTRL is pressed">
        if (oRepository.isKeyCtrl()) {
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="When SHIFT is pressed">
        if (oRepository.isKeyShift()) {
            
        }
        //</editor-fold>

    }

    // !!! TO BE DONE
    @Override
    public void mouseReleased(MouseEvent e) {

        //<editor-fold defaultstate="collapsed" desc="No ALT / CTRL / SHIFT keys pressed">
        if (!oRepository.isKeyAlt()
                && !oRepository.isKeyCtrl()
                && !oRepository.isKeyShift()) {
            
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="When CTRL is pressed">
        if (oRepository.isKeyCtrl()) {

        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="When SHIFT is pressed">
        if (oRepository.isKeyShift()) {

        }
        //</editor-fold>

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
