package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.di.DaggerTest3DRotationComponent;
import ru.yanchenko.vlad.test3drotation.di.Test3DRotationComponent;

import javax.swing.*;

/**
 * Main class for an application
 */
public class Test3DRotation {

    /**
     * Entry point for an application
     *
     * @param args to pass into application if there are any
     */
    public static void main(String[] args) {
        Test3DRotationComponent daggerComponent = DaggerTest3DRotationComponent.create();
        JFrame drawingFrame = daggerComponent.getDrawingFrame();
        drawingFrame.addKeyListener(daggerComponent.getFrameKeyListener());
        drawingFrame.addMouseMotionListener(daggerComponent.getFrameMouseMotionListener());
    }
}
