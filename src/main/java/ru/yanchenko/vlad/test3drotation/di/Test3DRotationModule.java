package ru.yanchenko.vlad.test3drotation.di;

import dagger.Module;
import dagger.Provides;
import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;
import ru.yanchenko.vlad.test3drotation.data.ScreenData;
import ru.yanchenko.vlad.test3drotation.presentation.*;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameKeyListener;
import ru.yanchenko.vlad.test3drotation.userinteraction.listeners.FrameMouseMotionListener;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.KeyboardInteractionProcessor;
import ru.yanchenko.vlad.test3drotation.userinteraction.processors.MouseInteractionProcessor;
import ru.yanchenko.vlad.test3drotation.utils.PointComparator;

import javax.inject.Singleton;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static ru.yanchenko.vlad.test3drotation.utils.BallsGenerationUtils.createAndPlaceBallsAsCube;

@Module
public class Test3DRotationModule {

    //TODO Move these params to main method arguments someday
    // Range in px that balls will be scattered within.
    static final int RANGE = 700;
    // Number of points to be drawn on a screen.
    static final int POINTS_NUMBER = 1000;
    // Angle in radians that model is to be rotated on.
    static final double ANGLE = 0.03;

    @Provides
    @Singleton
    ScreenData provideScreenData() {
        return new ScreenData();
    }

    @Provides
    @Singleton
    DrawingTypeChanger provideDrawingTypeChanger() {
        return new DrawingTypeChanger();
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
        createAndPlaceBallsAsCube(coloredPointList);
        return new CubeDrawingPanel(coloredPointList, screenData);
    }

    @Provides
    @Singleton
    PointComparator providePointComparator() {
        return new PointComparator();
    }

    @Provides
    @Singleton
    DrawingPanelsFactory provideDrawingPanelsFactory(CubeDrawingPanel cubeDrawingPanel,
                                                     BallsDrawingPanel ballsDrawingPanel) {
        return new DrawingPanelsFactory(ballsDrawingPanel, cubeDrawingPanel);
    }

    @Provides
    @Singleton
    JFrame provideDrawingFrame(ScreenData screenData, DrawingPanelsFactory drawingPanelsFactory) {
        JFrame frame = new DrawingFrame(screenData);
        frame.setContentPane(drawingPanelsFactory.getDrawingPanel(DrawingType.RIBBED_CUBE));
        frame.setVisible(true);
        return frame;
    }

    @Provides
    @Singleton
    KeyboardInteractionProcessor provideKeyboardInteractionProcessor(List<ColoredPoint> coloredPointList,
                                                                     DrawingTypeChanger drawingTypeChanger,
                                                                     DrawingContentChooser drawingContentChooser) {
        return new KeyboardInteractionProcessor(
                ANGLE,
                coloredPointList,
                drawingTypeChanger,
                drawingContentChooser);
    }

    @Provides
    @Singleton
    MouseInteractionProcessor provideMouseInteractionProcessor(PointComparator pointComparator,
                                                               List<ColoredPoint> coloredPointList,
                                                               DrawingTypeChanger drawingTypeChanger) {
        return new MouseInteractionProcessor(pointComparator, coloredPointList, drawingTypeChanger);
    }

    @Provides
    @Singleton
    FrameMouseMotionListener provideFrameMouseMotionListener(JFrame drawingFrame,
                                                             MouseInteractionProcessor mouseInteractionProcessor) {
        return new FrameMouseMotionListener(drawingFrame, mouseInteractionProcessor);
    }

    @Provides
    @Singleton
    FrameKeyListener provideFrameKeyListener(JFrame drawingFrame,
                                             KeyboardInteractionProcessor keyboardInteractionProcessor) {
        return new FrameKeyListener(drawingFrame, keyboardInteractionProcessor);
    }

    @Provides
    @Singleton
    DrawingContentChooser provideDrawingContentChooser(JFrame drawingFrame,
                                                       PointComparator pointComparator,
                                                       List<ColoredPoint> coloredPoints,
                                                       DrawingPanelsFactory drawingPanelsFactory) {
        return new DrawingContentChooser(
                RANGE,
                POINTS_NUMBER,
                drawingFrame,
                pointComparator,
                coloredPoints,
                drawingPanelsFactory);
    }
}
