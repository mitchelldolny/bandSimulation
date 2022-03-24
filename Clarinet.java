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


public class Clarinet extends Woodwind{
    
    public Clarinet(String m){
        super(m);
    }
    /**
     * returns the music file for clarinet
     * @return 
     */
    @Override
    public String getMusicFile(){
        return CLARINET;
    }
    
    /**
     * makes the sound of a clarinet using the path passed in
     * @param path which is the location of the music file
     * @return 
     */
    @Override
    public String makeSound(String path){
        AudioInputStream music;
        File musi = new File(path);//creates new file with location of path
        try{
            music = AudioSystem.getAudioInputStream(musi); //makes an AudioInputStream
            Clip clip = AudioSystem.getClip();//gets clip
            clip.open(music);//opens file
            clip.start();//stars the music
            
            Thread.sleep(4000); //sleeps for length of clip
            clip.close();//closes clip
        } catch (UnsupportedAudioFileException | IOException |LineUnavailableException |InterruptedException  ex) {
            Logger.getLogger(Clarinet.class.getName()).log(Level.SEVERE, null, ex); // wouldn't work on my computer unless included if their is an error remove this
            //i read about it and I believe it had some issue with macs
        }
        return "squak";
    }
    
    /**
     * returns that the musician plays the clarinet
     * @return 
     */
    @Override
    public String toString(){
        return musician + " plays the clarinet";
    }
    
}
