package ru.yanchenko.vlad.test3drotation.utils;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;

import java.util.Comparator;

/**
 * Compares two instances of {@link ColoredPoint}
 */
public class PointComparator implements Comparator<ColoredPoint> {

    @Override
    public int compare(ColoredPoint b1, ColoredPoint b2) {
        return (int)(b1.getDekartPoint().getZ() - b2.getDekartPoint().getZ());
    }
}
