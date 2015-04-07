/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ReadFromBaseFile {

    int firts5 = 1;
    String bigestName;
    JLabel label;
    ArrayList<String> array = new ArrayList<String>();
    BufferedReader bufread;
    Hashtable table;
    JPanel p;
    Pan panel;

    public ReadFromBaseFile(Pan panel) {
        this.panel = panel;
        JLabel labIcon;
        JLabel icon;
        JPanel panelPutIconPlusTop = new JPanel();
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        p = new JPanel();
        labIcon = new JLabel();
        icon = new JLabel(new ImageIcon("Your score is " + panel.getScore() + " \n top5.png"));
        labIcon.setText("TOP");
        panelPutIconPlusTop.add(labIcon);
        panelPutIconPlusTop.add(icon);
        panelPutIconPlusTop.setLayout(new FlowLayout());
        Font f = new Font("BOLD", 60, 93);

        labIcon.setFont(f);

        panel.add(panelPutIconPlusTop, BorderLayout.BEFORE_FIRST_LINE);

        try {
            table = new Hashtable();
            bufread = new BufferedReader(new FileReader("scores.txt"));
            String readFromFile;

            while ((readFromFile = bufread.readLine()) != null) {
                array.add(readFromFile);

                String[] ksexwrizwStringMeInt = readFromFile.split("-");
                //    System.out.println(ksexwrizwStringMeInt[0] + " - " + ksexwrizwStringMeInt[1]);

                addToHash(ksexwrizwStringMeInt[0], Integer.valueOf(ksexwrizwStringMeInt[1]));

            }




        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            useHash();

        }

    }

    public void addToHash(String x, int y) {


        table.put(y, x);





    }

    public void useHash() {

        findTheBiggest();


    }

    public void addToPanel(String name, int score) {


        p.setLayout(new GridLayout(6, 1));
        p.setBackground(Color.yellow);
        label = new JLabel();
        label.setText(firts5 + "-     username :  " + name + " -   score: " + score);
        label.setForeground(Color.red);
        label.setHorizontalAlignment(JLabel.CENTER);
        p.add(label);
        panel.add(p);
        firts5++;
    }

    public void findTheBiggest() {

        for (int i = 0; i < 5; i++) {
            String BiggestScoreName = null;
            int BiggestScore = 0;
            Iterator iter = table.keySet().iterator();
            while (iter.hasNext()) {
                Integer score = (Integer) iter.next();

                String names = (String) table.get(score);
                if (score >= BiggestScore && names != null) {
                    BiggestScore = score;
                    BiggestScoreName = names;

                }
                if (iter.hasNext() == false) {
                    table.remove(BiggestScore);
                }


            }

            if (BiggestScoreName != null) {
                addToPanel(BiggestScoreName, BiggestScore);
            }



        }

        panel.revalidate();

    }
}
