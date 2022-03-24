package music;
/**
 * By: Mitchell Dolny
 * Date: 3/8/2021
 * This program uses polymorphism and abstract classes to resemble an easy to use
 * band and plays the sound. If user wants to modify this to play their own sounds they
 * just have to drop in files and rename that file path to the new path. This will help
 * Mr. Gaumond out a lot. 
 */
import java.util.ArrayList;

public class Performance {
    private ArrayList<Instrument> arr = new ArrayList<>();
    private ArrayList<String> arr2 = new ArrayList<>();
   
    private int index = 0;
    private String path;
   
  
    public Performance(ArrayList<Instrument> i, ArrayList<String> s) {
        arr = i;
        arr2 = s;
    }
    /**
     * Begins the performance
     */
    public void begin(){
        
        if (arr2.isEmpty()){ //checks if the arraylist is empty
            System.out.println("Nice try but nobody will perform with this size of band. What did you expect when you entered 0");
        }//end of if
        
        for (int i = 0; i < arr2.size(); i ++){
            getMusic(arr2.get(i));//gets the music of the specific instrument
        }//end of for
    
    }//end of begin method
    /**
     * A String representation of the performers
     * @return 
     */
    @Override
    public String toString() { 
        String program = "The performance includes: \n"; 
        for (int i = 0; i < arr2.size(); i ++){ //loops for the length of the performance till all performers are outputted
            for (int x = 0; x < arr.size(); x++){//repeatsd for instrument arr size
                if (arr.get(x).getMusician().equals(arr2.get(i))){ //checks to see if the position in the instrument array is equal to the performance array 
                    program +=  arr.get(x).toString() + "\n";//then displays the object's location toString method
                }//end of if
            }//end of for    
        }//end of for
        return (program); 
    }
    
    private void getMusic(String s){
        path = "";
        for (int x = 0; x< arr2.size(); x ++){//will repeat for length of performer
            for (int i = 0; i < arr.size(); i ++){ //repeats for length of instrument array
                if(arr.get(i).getMusician().equals(s)){ //if instrument arr is equal to player than store the index
                    index = i;
                }//end of if
            }//end of for  
        }//end of for
        
        path = arr.get(index).getMusicFile(); // at the specific i value Path gets what the Music File is for that object
        String stuff = arr.get(index).makeSound(path); //Calls the make sound method and passes in the mnusic File
        System.out.println(stuff);//prints the toString method
    }
}