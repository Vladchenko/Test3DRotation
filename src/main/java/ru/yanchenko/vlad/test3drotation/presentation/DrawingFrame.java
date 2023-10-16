package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ScreenData;

import javax.swing.*;

/**
 * This JFrame is to draw graphics onto, using JPanel as a content pane.
 */
public class DrawingFrame extends JFrame {

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param screenData           to provide data on it
     */
    public DrawingFrame(ScreenData screenData) {
        setSize(screenData.getScreenWidth(), screenData.getScreenHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setBackground(screenData.getWindowBackgroundColor());
        setVisible(true);
        requestFocus();
        repaint();
    }
}
