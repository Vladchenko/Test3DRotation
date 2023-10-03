package ru.yanchenko.vlad.shutter;

import java.awt.*;
import javax.swing.JPanel;
import ru.yanchenko.vlad.shutter.data.DekartPoint;

public class Drawing extends JPanel {

    private static Repository oRepository;

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
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);

//        float dash1[] = {1.0f, 0.0f};
//        g2.setStroke(new BasicStroke(2,
//                BasicStroke.CAP_ROUND,
//                BasicStroke.JOIN_ROUND,
//                0, dash1, 10.0f));

        //** Put only a code that has to do with a drawing !
        //** Sample code
        
//        g2.setColor(Color.green);

//        g.drawString("Sample text", oRepository.getPntScreenCenter().x,
//                oRepository.getPntScreenCenter().y);
        g2.setColor(Color.white);
        for (DekartPoint dekartPoint : oRepository.getPoints()) {
            g2.drawOval(
                    (int) dekartPoint.getX() + oRepository.getScreenWidth() / 2 - 2,
                    (int) dekartPoint.getY() + oRepository.getScreenHeight() / 2 - 2,
                    4,
                    4);
//            g2.setColor(Color.green);
//            g2.drawLine((int)oRepository.getExtDots().getExtDots1().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots1().get(i).getY(),
//                    (int)oRepository.getExtDots().getExtDots2().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots2().get(i).getY());
//            g2.setColor(Color.blue);
//            g2.drawLine((int)oRepository.getExtDots().getExtDots3().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots3().get(i).getY(),
//                    (int)oRepository.getExtDots().getExtDots4().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots4().get(i).getY());
        }
//        g2.setColor(Color.green);
//        for (int i=0; i < oRepository.getExtDots().getExtDots1().size(); i++) {
//            g2.drawLine((int)oRepository.getExtDots().getExtDots1().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots1().get(i).getY(),
//                    (int)oRepository.getExtDots().getExtDots2().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots2().get(i).getY());
//        }
//        g2.setColor(Color.blue);
//        for (int i=0; i < oRepository.getExtDots().getExtDots1().size(); i++) {
//            g2.drawLine((int)oRepository.getExtDots().getExtDots3().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots3().get(i).getY(),
//                    (int)oRepository.getExtDots().getExtDots4().get(i).getX(),
//                    (int)oRepository.getExtDots().getExtDots4().get(i).getY());
//        }
    }
}
