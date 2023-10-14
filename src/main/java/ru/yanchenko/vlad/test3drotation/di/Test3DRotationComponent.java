package ru.yanchenko.vlad.test3drotation.di;

import dagger.Component;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameMouseMotionListener;

import javax.inject.Singleton;

/**
 * Dagger component
 */
@Singleton
@Component(modules = {Test3DRotationModule.class})
public interface Test3DRotationComponent {
    DrawingFrame getDrawingFrame();
    FrameKeyListener getFrameKeyListener();
    FrameMouseMotionListener getFrameMouseMotionListener();
}
