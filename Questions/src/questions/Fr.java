/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class Fr extends JFrame {

    private Music music;
    private String name = null;
    private JButton sprt = new JButton("sports");
    private JButton gnrl = new JButton("general");
    private Fr frame;
    private Pan p;
    private JComboBox comboboxWithTheSex = new JComboBox();
    private String male = "unknown";
    private JComboBox musicCombo = new JComboBox();
    private final ArrayList toTakeRandomMusic = new ArrayList();

    public Fr() {
        super();
        addToArrayTheMusic();
        musicCombo.addItem(" ");
        for (int i = 0; i < 2; i++) {
            musicCombo.addItem(takeTheRandomMusic());
        }

        musicCombo.addActionListener(comboListenerMusic);
        this.add(musicCombo);
        comboboxWithTheSex.addItem("Male");
        comboboxWithTheSex.addItem("Femail");
        comboboxWithTheSex.addActionListener(null);
        frame = this;
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(600, 650);
        name = JOptionPane.showInputDialog(rootPane, "insert name");
        if (name == null) {
            System.exit(0);
        }

        this.setLayout(null);
        this.add(sprt);
        sprt.setSize(200, 100);
        sprt.setLocation(100, 100);
        this.add(gnrl);
        gnrl.setSize(200, 100);
        gnrl.setLocation(350, 100);
        this.add(comboboxWithTheSex);
        musicCombo.setSize(60, 30);
        musicCombo.setLocation(280, 560);
        comboboxWithTheSex.setSize(60, 30);
        comboboxWithTheSex.setLocation(200, 300);
        comboboxWithTheSex.addActionListener(filo);
        gnrl.addActionListener(Questions);
        sprt.addActionListener(Questions);
        System.out.println("hello  " + name);
        this.setVisible(true);
    }

    /**
     *
     * @return
     */
    public JComboBox getMusicCombo() {
        return musicCombo;
    }

    /**
     *
     * @param musicCombo
     */
    public void setMusicCombo(JComboBox musicCombo) {
        this.musicCombo = musicCombo;
    }

    /**
     *
     */
    public void addToArrayTheMusic() {
        toTakeRandomMusic.add("narcotic");
        toTakeRandomMusic.add("Smalltown Boy");
        toTakeRandomMusic.add(" The Lion Sleeps Tonight");
        toTakeRandomMusic.add("House of the Rising Sun");
        toTakeRandomMusic.add(" Ruby");
        toTakeRandomMusic.add("Snow");
        toTakeRandomMusic.add("uefa champ.league");

    }

    /**
     *
     * @return
     */
    public String takeTheRandomMusic() {
        int x = (int) (Math.random() * toTakeRandomMusic.size());
        String msc = (String) toTakeRandomMusic.get(x);
        toTakeRandomMusic.remove(x);
        return msc;

    }

    /**
     *
     * @param name
     */
    public void SetName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    ActionListener filo = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox comb = (JComboBox) e.getSource();
            male = (String) comb.getSelectedItem();
            comb.removeItemAt(comb.getSelectedIndex());
            System.out.println("your sex is " + male);
            frame.remove(comboboxWithTheSex);
            frame.repaint();
        }
    };
    /**
     *
     */
    ActionListener Questions = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            frame.remove(sprt);
            frame.remove(gnrl);
            frame.remove(comboboxWithTheSex);
            frame.setLayout(new BorderLayout());
            frame.add(musicCombo);
            p = new Pan(frame, b.getText());
            frame.add(p, BorderLayout.CENTER);
            frame.validate();
            frame.repaint();
            if (b.getText().contains("sport")) {

                new Thread() {

                    @Override
                    public void run() {
                        try {
                            this.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        if (music != null) {
                            music.stop();
                        }
                        music = new Music("uefa champ.league");
                    }
                }.start();

            }
        }
    };

    /**
     *
     */
    ActionListener comboListenerMusic = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox combo = (JComboBox) e.getSource();
            if (music != null) {
                music.stop();
            }

            music = null;
            music = new Music((String) combo.getSelectedItem());
            //combo.removeItem(combo.getSelectedItem());
            combo.removeItemAt(0);
            combo.setSelectedIndex(combo.getSelectedIndex());
            if (combo.getItemCount() == 1) {
                frame.remove(combo);

                frame.repaint();
            }
        }
    };
}
