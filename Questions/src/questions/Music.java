/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

/**
 *
 * @author user
 */
public class Music {

    private AudioClip clip = null;
    
    public Music( String song) {
        try {
            stop();
            File f = new File(song + ".au");
            clip = Applet.newAudioClip(f.toURL());
            
            clip.play();
            
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            System.out.println("try again");
        
         
            
        }
        
    }
    
    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }
}
