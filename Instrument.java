/**
 * By: Mitchell Dolny
 * Date: 3/8/2021
 * This program uses polymorphism and abstract classes to resemble an easy to use
 * band and plays the sound. If user wants to modify this to play their own sounds they
 * just have to drop in files and rename that file path to the new path. This will help
 * Mr. Gaumond out a lot. 
 */
package music;

public abstract class Instrument {
    
    protected String musician;
    /*
    When marking invert the slashes as this is how I access the folder on mac
    */
    //opens all the music files that ar located in the project folder
    protected final String VOCAL = "Music//Vocal.wav";
    protected final String PICCOLO = "Music//Piccolo.wav";
    protected final String CLARINET = "Music//Clarinet.wav";
    protected final String CYMBALS = "Music//Cymbal.wav";
    protected final String DRUMS = "Music//Drum.wav";
    
   
    
    public Instrument(String m){
        musician = m;
    }
    /**
     * When called this returns the musicians name
     * @return 
     */
    public String getMusician(){
        return musician;
    }
    /**
     * Creates an abstract class that will be passed on to the child classes to get MusicFile
     * @return 
     */
    abstract String getMusicFile();
    
    /**
     * Creates an abstract class that will be passed to the child classes to make sound
     * @param path
     * @return 
     */
    abstract String makeSound(String path);
    
    /**
     * Creates a toString method that is abstract for child classes
     * @return 
     */
    @Override
    public abstract String toString();
}
