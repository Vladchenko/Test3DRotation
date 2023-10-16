package ru.yanchenko.vlad.test3drotation.di;

import dagger.Component;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameMouseMotionListener;

import javax.inject.Singleton;
import javax.swing.*;

/**
 * Dagger component
 */
@Singleton
@Component(modules = {Test3DRotationModule.class})
public interface Test3DRotationComponent {
    JFrame getDrawingFrame();
    FrameKeyListener getFrameKeyListener();
    FrameMouseMotionListener getFrameMouseMotionListener();
}
