package ru.yanchenko.vlad.test3drotation.presentation;

import javax.swing.*;

/**
 * Defines and retrieves JPanels for drawing.
 */
public class DrawingPanelsFactory {
    private final CubeDrawingPanel cubeDrawingPanel;
    private final BallsDrawingPanel ballsDrawingPanel;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param ballsDrawingPanel to draw graphic model on
     * @param cubeDrawingPanel  to draw graphic model on
     */
    public DrawingPanelsFactory(BallsDrawingPanel ballsDrawingPanel,
                                CubeDrawingPanel cubeDrawingPanel) {
        this.ballsDrawingPanel = ballsDrawingPanel;
        this.cubeDrawingPanel = cubeDrawingPanel;
    }

    /**
     * Define a JPanel to draw graphics on
     *
     * @param drawingType to define what kind of JPanel to use
     * @return JPanel to draw graphics on
     */
    JPanel getDrawingPanel(DrawingType drawingType) {
        if (drawingType == DrawingType.CUBE) {
            return cubeDrawingPanel;
        } else {
            return ballsDrawingPanel;
        }
    }
}
