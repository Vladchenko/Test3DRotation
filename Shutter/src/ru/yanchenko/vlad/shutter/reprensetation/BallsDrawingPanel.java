package ru.yanchenko.vlad.shutter.reprensetation;

import ru.yanchenko.vlad.shutter.Repository;

import javax.swing.*;
import java.awt.*;

public class BallsDrawingPanel extends JPanel {

    private static Repository repository;

    /** Constructor is made private, for it could not be instantiated anywhere besides "getInstance" method. */
    private BallsDrawingPanel() {}

    public static synchronized JPanel getInstance(Repository Repository_) {
        repository = Repository_;
        if (Repository_.getDrawing() == null) {
            Repository_.setDrawing(new BallsDrawingPanel());
        }
        return Repository_.getDrawing();
    }

    @Override
    public void paintComponent(Graphics g) {

        //** Erasing a previously drawn data 
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        /* Adding an antialiasing for graphics */
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        float[] dash1 = {1.0f, 1.0f};
        g2.setStroke(new BasicStroke(20,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND,
                1, dash1, 1.0f));

        //** Put only a code that has to do with a drawing !

        for (int i = 0; i < repository.getBalls().length; i++) {
            double radius = (repository.getBalls()[i].getDekartPoint().getZ() + repository.getRange()) / repository.getRange() * 20;


            RadialGradientPaint bgPaint = new RadialGradientPaint(
                    (float) (repository.getBalls()[i].getDekartPoint().getX() + repository.getScreenWidth() / 2) - 1,
                    (float) (repository.getBalls()[i].getDekartPoint().getY() + repository.getScreenHeight() / 2) - 1,
                    (float) radius / 2,
                    new float[] {0.1f, 1.0f},
                    new Color[] {repository.getBalls()[i].getColor(), new Color(0,0,0,55)});

            g2.setPaint(bgPaint);

            g2.fillOval(
                    (int) (repository.getBalls()[i].getDekartPoint().getX() + repository.getScreenWidth() / 2 - radius / 2),
                    (int) (repository.getBalls()[i].getDekartPoint().getY() + repository.getScreenHeight() / 2 - radius / 2),
                    (int) radius,
                    (int) radius);

        }

    }
}
