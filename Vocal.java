/**
 * By: Mitchell Dolny
 * Date: 3/8/2021
 * This program uses polymorphism and abstract classes to resemble an easy to use
 * band and plays the sound. If user wants to modify this to play their own sounds they
 * just have to drop in files and rename that file path to the new path. This will help
 * Mr. Gaumond out a lot. 
 */
package music;

//imports
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Vocal extends Instrument {
    
    public Vocal(String m){
        super(m);
    }
    /**
     * returns the music file for vocal
     * @return 
     */
    @Override
    public String getMusicFile(){
        return VOCAL;
    }
    
    /**
     * makes the sound of a singer using the path passed in
     * @param path which is the location of the music file
     * @return 
     */
    @Override
    public String makeSound(String path) {
        AudioInputStream music;
        File musi = new File(path); //makes a ne wfile with location path
        try{
            music = AudioSystem.getAudioInputStream(musi);//makes a bew audiosystem 
            Clip clip = AudioSystem.getClip(); //gets the clip
            clip.open(music); // opens the music to be played
            clip.start(); //starts the music
            
            Thread.sleep(6100); //sleeps for the length of the clip to be played
            clip.close();//closes the clip
        } catch (UnsupportedAudioFileException | IOException |LineUnavailableException |InterruptedException  ex) { //catches these specific exceptions
            Logger.getLogger(Vocal.class.getName()).log(Level.SEVERE, null, ex); // wouldn't work on my computer unless included if their is an error remove this
            //i read about it and I believe it had some issue with macs
        }
        return "LaLaLa";
    }
    
    /**
     * returns that the musician is a singer
     * @return 
     */
    @Override
    public String toString(){
        return musician + " is a singer";
    }
}
