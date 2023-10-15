package ru.yanchenko.vlad.test3drotation.presentation;

import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameMouseMotionListener;

import javax.swing.*;

/**
 * This JFrame is to draw graphics onto, using JPanel as a content pane.
 */
public class DrawingFrame extends JFrame {

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param screenData           to provide data on it
     * @param drawingPanelsFactory to provide a JPanels to draw graphics on
     */
    public DrawingFrame(ScreenData screenData,
                        DrawingPanelsFactory drawingPanelsFactory) {
        setSize(screenData.getScreenWidth(), screenData.getScreenHeight());
        setLocationRelativeTo(null);
        setContentPane(drawingPanelsFactory.getDrawingPanel(CubeDrawingPanel.class));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setBackground(screenData.getWindowBackgroundColor());
        setVisible(true);
        requestFocus();
        repaint();
    }

    /**
     * @param keyListener to be set to receive keyboard buttons typing
     */
    public void setKeyListener(FrameKeyListener keyListener) {
        addKeyListener(keyListener);
    }

    /**
     * @param mouseMotionListener to be set to receive mouse buttons clicking
     */
    public void setMouseMotionListener(FrameMouseMotionListener mouseMotionListener) {
        addMouseMotionListener(mouseMotionListener);
    }
}
