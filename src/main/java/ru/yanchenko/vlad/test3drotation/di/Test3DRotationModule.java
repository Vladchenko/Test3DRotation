package ru.yanchenko.vlad.test3drotation.di;

import dagger.Module;
import dagger.Provides;
import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.presentation.BallsDrawingPanel;
import ru.yanchenko.vlad.test3drotation.presentation.CubeDrawingPanel;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingFrame;
import ru.yanchenko.vlad.test3drotation.presentation.DrawingPanelsFactory;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.KeyboardInteractionProcessor;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.MouseInteractionProcessor;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Module
public class Test3DRotationModule {

    //TODO Move these params to main method arguments someday
    // Range in px that balls will be scattered within.
    static final int RANGE = 900;
    // Number of points to be drawn on a screen.
    static final int POINTS_NUMBER = 100;
    // Angle in radians that model is to be rotated on.
    static final double ANGLE = 0.03;

    @Provides
    @Singleton
    ScreenData provideScreenData() {
        return new ScreenData();
    }

    @Provides
    @Singleton
    List<ColoredPoint> provideColoredPointList() {
        return new ArrayList<>();
    }

    @Provides
    @Singleton
    BallsDrawingPanel provideBallsDrawingPanel(List<ColoredPoint> coloredPointList, ScreenData screenData) {
        return new BallsDrawingPanel(coloredPointList, screenData, RANGE);
    }

    @Provides
    @Singleton
    CubeDrawingPanel provideCubeDrawingPanel(List<ColoredPoint> coloredPointList, ScreenData screenData) {
        return new CubeDrawingPanel(coloredPointList, screenData);
    }

    @Provides
    @Singleton
    PointComparator providePointComparator() {
        return new PointComparator();
    }

    @Provides
    @Singleton
    DrawingPanelsFactory provideDrawingPanelsFactory(PointComparator pointComparator,
                                                     CubeDrawingPanel cubeDrawingPanel,
                                                     BallsDrawingPanel ballsDrawingPanel,
                                                     List<ColoredPoint> coloredPointList) {
        return new DrawingPanelsFactory(
                ballsDrawingPanel,
                cubeDrawingPanel,
                coloredPointList,
                pointComparator,
                POINTS_NUMBER,
                RANGE);
    }

    @Provides
    @Singleton
    DrawingFrame provideDrawingFrame(ScreenData screenData, DrawingPanelsFactory drawingPanelsFactory) {
        return new DrawingFrame(screenData, drawingPanelsFactory);
    }

    @Provides
    @Singleton
    KeyboardInteractionProcessor provideKeyboardInteractionProcessor(DrawingFrame drawingFrame,
                                                                     List<ColoredPoint> coloredPointList) {
        return new KeyboardInteractionProcessor(
                ANGLE,
                drawingFrame,
                coloredPointList);
    }

    @Provides
    @Singleton
    MouseInteractionProcessor provideMouseInteractionProcessor(DrawingFrame drawingFrame,
                                                               List<ColoredPoint> coloredPointList) {
        return new MouseInteractionProcessor(
                drawingFrame,
                coloredPointList);
    }
}
