package ru.yanchenko.vlad.shutter.utils;

import ru.yanchenko.vlad.shutter.data.ColoredPoint;

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
