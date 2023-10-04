package ru.yanchenko.vlad.shutter.utils;

import ru.yanchenko.vlad.shutter.data.Ball;
import ru.yanchenko.vlad.shutter.data.DekartPoint;

import java.util.Comparator;

/**
 * TODO
 */
public class PointComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball b1, Ball b2) {
        return (int)(b1.getDekartPoint().getZ() - b2.getDekartPoint().getZ());
    }
}
