package questions;

import java.io.*;
import java.util.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author user
 */
public class Base {

    String playerName = null;
    static Hashtable<String, Integer> scoreTable;
    FileWriter writeFile;
    String read, write;
    Pan panel;

    public Base(Pan panel) {
        this.playerName = panel.getFrame().getName();
        this.panel = panel;
        scoreTable = new Hashtable<String, Integer>();



        readAndWriteFromBase(panel);
    }

    public void readAndWriteFromBase(Pan p) {

        try {


            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("scores.txt", true));
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(playerName + "( category " + p.getType() + ")" + " -" + p.getScore());
            fbw.newLine();
            fbw.close();
            ReadFromBaseFile r = new ReadFromBaseFile(p);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
