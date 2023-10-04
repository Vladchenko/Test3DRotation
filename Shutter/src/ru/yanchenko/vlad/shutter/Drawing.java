package ru.yanchenko.vlad.shutter;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {

    private static Repository oRepository;
    private double radius;

    /**
     * Constructor is made private, for it could not be instantiated anywhere
     * besides "getInstance" method.
     */
    private Drawing() {
    }

    public static synchronized Drawing getInstance(Repository Repository_) {
        oRepository = Repository_;
        if (Repository_.getoDrawing() == null) {
            Repository_.setoDrawing(new Drawing());
        }
        return Repository_.getoDrawing();
    }

    @Override
    public void paintComponent(Graphics g) {

        /**
         * Hiding mouse cursor is turned on in Repository.initializeData() by
         * uncommenting a respective code.
         */
        //** Erasing a previously drawn data 
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        /** Adding an antialiasing for graphics */
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        float dash1[] = {1.0f, 0.0f};
        g2.setStroke(new BasicStroke(2,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND,
                0, dash1, 10.0f));

        //** Put only a code that has to do with a drawing !

        for (int i = 0; i < oRepository.getBalls().length; i++) {
            radius = (oRepository.getBalls()[i].getDekartPoint().getZ() + oRepository.getRange()) / oRepository.getRange() * 20;


            RadialGradientPaint bgPaint = new RadialGradientPaint(
                    (float) (oRepository.getBalls()[i].getDekartPoint().getX() + oRepository.getScreenWidth() / 2) - 1,
                    (float) (oRepository.getBalls()[i].getDekartPoint().getY() + oRepository.getScreenHeight() / 2) - 1,
                    (float) radius / 2,
                    new float[] {0.1f, 1.0f},
                    new Color[] {oRepository.getBalls()[i].getColor(), new Color(0,0,0,55)});

            g2.setPaint(bgPaint);

            g2.fillOval(
                    (int) (oRepository.getBalls()[i].getDekartPoint().getX() + oRepository.getScreenWidth() / 2 - radius / 2),
                    (int) (oRepository.getBalls()[i].getDekartPoint().getY() + oRepository.getScreenHeight() / 2 - radius / 2),
                    (int) radius,
                    (int) radius);

        }
    }
}
