/**
 * By: Mitchell Dolny
 * Date: 3/8/2021
 * This program uses polymorphism and abstract classes to resemble an easy to use
 * band and plays the sound. If user wants to modify this to play their own sounds they
 * just have to drop in files and rename that file path to the new path. This will help
 * Mr. Gaumond out a lot. 
 */
package music;



public abstract class Woodwind extends Instrument{
    
    public Woodwind(String m){
        super(m);
    }
    /**
     * Creates an abstract class that will be passed to the child classes to make sound
     * @param path
     * @return 
     */
    @Override
    abstract String makeSound(String path);
    /**
     * Creates an abstract class that will be passed on to the child classes to get MusicFile
     * @return 
     */
    @Override
    abstract String getMusicFile();
   /**
     * Creates a toString method that is abstract for child classes
     * @return 
     */
    @Override
    public abstract String toString();
}
