/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author gaitanesnikos
 */
public class ThreadToCheckAnswere extends Thread {

    private Pan panel;
    int watingTime = 1000;
    boolean iswrong = false, istrue = false;
    private JButton pressedb;
    private Timer time;
    private boolean isNotAnswered = true;

    public ThreadToCheckAnswere(Pan panel, boolean iswrong, boolean istrue, JButton pressedb, Timer time) {
        this.panel = panel;
        this.iswrong = iswrong;
        this.istrue = istrue;
        this.pressedb = pressedb;
        this.time = time;
    }

    public ThreadToCheckAnswere(Pan panel, boolean iswrong, boolean istrue, Timer time, boolean isNotAnswered) {
        this.panel = panel;
        this.iswrong = iswrong;
        this.istrue = istrue;
        this.time = time;
        this.isNotAnswered = isNotAnswered;
    }

    public void run() {
        try {
            time.suspend();
            int lvl = panel.getLevel();
            this.sleep(watingTime / 4);
            if (pressedb != null) {
                pressedb.setBackground(Color.BLUE);
            }


            if (iswrong) {
                new Music("family feud wrong answer buzzer - sound effect");
                this.sleep(watingTime / 2);
                iswrong = false;
                if (isNotAnswered) {
                    panel.setAnswereFalse(true);
                    panel.setScore(panel.getScore() - 100);
                    if (panel.getScore() < 0) {
                        panel.setScore(0);
                    }
                }
                if (pressedb != null) {
                    pressedb.setBackground(Color.red);
                }
                if (lvl < 15) {
                    panel.getStringLevelEasy().remove(panel.getRemovingDataFtomHasTable());
                    panel.makeLevel(lvl, panel.getStringLevelEasy());

                } else if (lvl < 30) {
                    panel.getStringLevelMedium().remove(panel.getRemovingDataFtomHasTable());
                    panel.makeLevel(lvl, panel.getStringLevelMedium());
                } else {
                    panel.getStringLevelHard().remove(panel.getRemovingDataFtomHasTable());
                    panel.makeLevel(lvl, panel.getStringLevelHard());
                }

            }

            if (istrue) {
                new Music("shiny ding sound effect");
                this.sleep(watingTime / 2);

                panel.setAnswereTrue(istrue);
                if (pressedb != null) {
                    pressedb.setBackground(Color.green);
                }
                istrue = false;




                if (lvl < 15) {
                    panel.getStringLevelEasy().remove(panel.getRemovingDataFtomHasTable());
                    panel.makeLevel(lvl + 1, panel.getStringLevelEasy());
                    panel.setDrawLevel("easy");
                } else if (lvl < 30) {
                    panel.getStringLevelMedium().remove(panel.getRemovingDataFtomHasTable());
                    panel.makeLevel(lvl + 1, panel.getStringLevelMedium());
                    panel.setDrawLevel("medium");
                } else {
                    panel.getStringLevelHard().remove(panel.getRemovingDataFtomHasTable());

                    panel.makeLevel(lvl + 1, panel.getStringLevelHard());
                    panel.setDrawLevel("hard");
                }
                panel.getQuestionsWithAnser().remove(panel.getRemovingDataFtomHasTable());
                panel.setScore(panel.getScore() + (15 - time.getSec()) * 10);
            }



            time.setSec(0);
            time.resume();
            panel.repaint();
            panel.setCanPressAnotherButton(true);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
