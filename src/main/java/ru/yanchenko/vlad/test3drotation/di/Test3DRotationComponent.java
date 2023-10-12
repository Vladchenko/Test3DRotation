package ru.yanchenko.vlad.test3drotation.di;

import dagger.Component;
import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.KeyboardInteractionProcessor;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.MouseInteractionProcessor;

import javax.inject.Singleton;
import java.util.List;

/**
 * Dagger component
 */
@Singleton
@Component(modules = {Test3DRotationModule.class})
public interface Test3DRotationComponent {

    ScreenData getScreenData();
    List<ColoredPoint> getColoredPointList();
    MouseInteractionProcessor getMouseInteractionProcessor();
    KeyboardInteractionProcessor getKeyboardInteractionProcessor();
}
