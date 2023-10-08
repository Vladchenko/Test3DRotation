package ru.yanchenko.vlad.shutter.reprensetation;

import ru.yanchenko.vlad.shutter.Repository;

import javax.swing.*;
import java.awt.*;

public class CubeDrawingPanel extends JPanel {

    private static Repository repository;

    /** Constructor is made private, for it could not be instantiated anywhere besides "getInstance" method. */
    private CubeDrawingPanel() {
    }

    public static synchronized JPanel getInstance(Repository Repository_) {
        repository = Repository_;
        if (Repository_.getDrawing() == null) {
            Repository_.setDrawing(new CubeDrawingPanel());
        }
        return Repository_.getDrawing();
    }

    @Override
    public void paintComponent(Graphics g) {

        //* Erasing a previously drawn data
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //* Adding an antialiasing for graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        float[] dash1 = {1.0f, 1.0f};
        g2.setStroke(new BasicStroke(20,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND,
                1, dash1, 1.0f));

        //* Put only a code that has to do with a drawing !

        LinearGradientPaint gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[0].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[0].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[1].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[1].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[0].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[0].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[1].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[1].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[1].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[1].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[2].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[2].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[1].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[1].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[2].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[2].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[2].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[2].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[3].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[3].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[2].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[2].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[3].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[3].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[3].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[3].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[0].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[0].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[3].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[3].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[0].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[0].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        if (repository.getBalls()[0].getDekartPoint().getX() != repository.getBalls()[4].getDekartPoint().getX()
        && repository.getBalls()[0].getDekartPoint().getY() != repository.getBalls()[4].getDekartPoint().getY()) {
            gradientPaint = new LinearGradientPaint(
                    (float) (repository.getBalls()[0].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[0].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    (float) (repository.getBalls()[4].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[4].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                    new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
            );

            g2.setPaint(gradientPaint);

            g2.drawLine((int) repository.getBalls()[0].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[0].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                    (int) repository.getBalls()[4].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[4].getDekartPoint().getY() + repository.getScreenHeight() / 2);
        }

        if (repository.getBalls()[1].getDekartPoint().getX() != repository.getBalls()[5].getDekartPoint().getX()
                && repository.getBalls()[1].getDekartPoint().getY() != repository.getBalls()[5].getDekartPoint().getY()) {
            gradientPaint = new LinearGradientPaint(
                    (float) (repository.getBalls()[1].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[1].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    (float) (repository.getBalls()[5].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[5].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                    new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
            );

            g2.setPaint(gradientPaint);

            g2.drawLine((int) repository.getBalls()[1].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[1].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                    (int) repository.getBalls()[5].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[5].getDekartPoint().getY() + repository.getScreenHeight() / 2);
        }

        if (repository.getBalls()[2].getDekartPoint().getX() != repository.getBalls()[6].getDekartPoint().getX()
                && repository.getBalls()[2].getDekartPoint().getY() != repository.getBalls()[6].getDekartPoint().getY()) {
            gradientPaint = new LinearGradientPaint(
                    (float) (repository.getBalls()[2].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[2].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    (float) (repository.getBalls()[6].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[6].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                    new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
            );

            g2.setPaint(gradientPaint);

            g2.drawLine((int) repository.getBalls()[2].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[2].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                    (int) repository.getBalls()[6].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[6].getDekartPoint().getY() + repository.getScreenHeight() / 2);
        }

        if (repository.getBalls()[3].getDekartPoint().getX() != repository.getBalls()[7].getDekartPoint().getX()
                && repository.getBalls()[3].getDekartPoint().getY() != repository.getBalls()[7].getDekartPoint().getY()) {
            gradientPaint = new LinearGradientPaint(
                    (float) (repository.getBalls()[3].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[3].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    (float) (repository.getBalls()[7].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                    (float) (repository.getBalls()[7].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                    new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                    new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
            );

            g2.setPaint(gradientPaint);

            g2.drawLine((int) repository.getBalls()[3].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[3].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                    (int) repository.getBalls()[7].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                    (int) repository.getBalls()[7].getDekartPoint().getY() + repository.getScreenHeight() / 2);
        }

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[4].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[4].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[5].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[5].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);


        g2.drawLine((int) repository.getBalls()[4].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[4].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[5].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[5].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[5].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[5].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[6].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[6].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[5].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[5].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[6].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[6].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[6].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[6].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[7].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[7].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[6].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[6].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[7].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[7].getDekartPoint().getY() + repository.getScreenHeight() / 2);

        gradientPaint = new LinearGradientPaint(
                (float) (repository.getBalls()[7].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[7].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                (float) (repository.getBalls()[4].getDekartPoint().getX() + repository.getScreenWidth() / 2),
                (float) (repository.getBalls()[4].getDekartPoint().getY() + repository.getScreenHeight() / 2),
                new float[] {0.0f, 0.4f, 0.6f, 1.0f},
                new Color[] {new Color(255,255,255,255), new Color(0,0,0,0), new Color(0,0,0,0), new Color(255,255,255,255)}
        );

        g2.setPaint(gradientPaint);

        g2.drawLine((int) repository.getBalls()[7].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[7].getDekartPoint().getY() + repository.getScreenHeight() / 2,
                (int) repository.getBalls()[4].getDekartPoint().getX() + repository.getScreenWidth() / 2,
                (int) repository.getBalls()[4].getDekartPoint().getY() + repository.getScreenHeight() / 2);

    }
}
