package ru.yanchenko.vlad.test3drotation.representation;

import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.listeners.FrameMouseMotionListener;

import javax.swing.*;
import java.awt.*;

/**
 * This JFrame is to draw graphics onto, using JPanel as a content pane.
 */
public class DrawingFrame extends JFrame {

    private final DrawingPanelsFactory drawingPanelsFactory;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param screenData to provide data on it
     * @param drawingPanelsFactory to provide a JPanels to draw graphics on
     */
    public DrawingFrame(ScreenData screenData,
                        DrawingPanelsFactory drawingPanelsFactory) {
        this.drawingPanelsFactory = drawingPanelsFactory;
        setSize(screenData.getScreenWidth(), screenData.getScreenHeight());
        setLocationRelativeTo(null);
        setContentPane(drawingPanelsFactory.getDrawingPanel(DrawingType.CUBE));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            setUndecorated(true);
        } catch (IllegalComponentStateException ex) {
        }
        setLayout(null);
        setBackground(screenData.getWindowBackgroundColor());
        setVisible(true);
        requestFocus();
        repaint();
    }

    /**
     * Draws points on a content pane.
     *
     * @param drawingType defines a content to be drawn
     */
    public void drawContents(DrawingType drawingType) {
        setContentPane(drawingPanelsFactory.getDrawingPanel(drawingType));
        setVisible(true);
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
