package questions;

import java.util.logging.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author gaitanesnikos
 */
public class Timer extends Thread {

    private int sec = 0;
    private Pan p;
    private JProgressBar progress = new JProgressBar();
    private JLabel countScoreLabel = new JLabel();

    public Timer(Pan p) {
        this.p = p;
        progress.setMinimum(0);
        progress.setMaximum(15);
        p.add(progress);
        progress.setLocation(270, 310);
        progress.setSize(100, 20);
        progress.setString("Time");
        p.add(countScoreLabel);
        countScoreLabel.setSize(100, 100);
        countScoreLabel.setLocation(300, 300);
    }

    public JLabel getCountScoreLabel() {
        return countScoreLabel;
    }

    public void setCountScoreLabel(JLabel countScoreLabel) {
        this.countScoreLabel = countScoreLabel;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    @Override
    public void run() {
        while (true) {
            try {

                this.sleep(1000);
                sec++;
                countScoreLabel.setText("Score : " + Integer.toString(p.getScore()));
                progress.setValue(sec);

                if (sec >= 15) {
                    p.gameOver(false);
                    this.sleep(1000);
                    this.stop();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
