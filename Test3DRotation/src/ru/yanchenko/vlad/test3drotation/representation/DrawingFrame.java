package ru.yanchenko.vlad.test3drotation.representation;

import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.listeners.FrameMouseMotionListener;

import javax.swing.*;
import java.awt.*;

/**
 * This frame is to be added to a JPanel to draw graphics on.
 */
public class DrawingFrame extends JFrame {

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param screenData to provide data on it
     */
    public DrawingFrame(JPanel panel, ScreenData screenData) {
        setSize(screenData.getScreenWidth(), screenData.getScreenHeight());
        setLocationRelativeTo(null);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            setUndecorated(true);
        } catch (IllegalComponentStateException ex) {
        }
        setLayout(null);
        setBackground(screenData.getWindowBackgroundColor());
        setVisible(true);
        requestFocus();
        panel.repaint();
    }

    public void setKeyListener(FrameKeyListener keyListener) {
        addKeyListener(keyListener);
    }
    public void setMouseMotionListener(FrameMouseMotionListener mouseMotionListener) {
        addMouseMotionListener(mouseMotionListener);
    }
}
