/**
 * By: Mitchell Dolny
 * Date: 3/8/2021
 * This program uses polymorphism and abstract classes to resemble an easy to use
 * band and plays the sound. If user wants to modify this to play their own sounds they
 * just have to drop in files and rename that file path to the new path.
 */
/*
Learning how to implement sound was used from this : https://www.geeksforgeeks.org/play-audio-file-using-java/
*/
package music;
//imports
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;


public class Music {

    //class variables
    static ArrayList<Instrument> inst = new ArrayList<Instrument>();
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * This method is a class method and has a role of assigning instruments to the player
     * @return
     * @throws IOException 
     */
    public static Instrument assignInstrument() throws IOException{
        String instrumentPlay = "";
        String player = CheckIfMusicianExists(); //assigns the player that will be checked to the String player
                
        while(!instrumentPlay.equals("v") && !instrumentPlay.equals("c") && !instrumentPlay.equals("p") && !instrumentPlay.equals("d") && !instrumentPlay.equals("cy")){
            System.out.println("What Instrument do you play: Vocalist (V), Piccolist (P), Clarinet (C), Drums(D), Cymbals(Cy)");
            instrumentPlay = in.readLine().toLowerCase();
        }//end of while || repeats till assigned letters are inputted

        switch (instrumentPlay) { //creates a switch instead of an if statemebnt to easily make differnt cases to see what class to make;
            case "v":
                Instrument v = new Vocal(player);//creates a vocal class from parent class
                return v; //returns a class vocal with player details
            case "c":
                Instrument c = new Clarinet(player);//creates a vocal class from parent class
                return c; //returns a class vocal with player details
            case "p":
                Instrument p = new Piccolo(player);//creates a vocal class from parent class
                return p; //returns a class vocal with player details
            case "d":
                Instrument d = new Drums(player);//creates a vocal class from parent class
                return d; //returns a class vocal with player details
            default:
                Instrument cy = new Cymbals(player);//creates a vocal class from parent class   
                return cy; //returns a class vocal with player details
        }//end of switch
    }//end of assignInstrument

  
    public static void main(String[] args) throws IOException, InterruptedException { 
        //initalize variables
        ArrayList<String> perform = new ArrayList<>();
        Performance band = new Performance(inst, perform);
        String player = "";
        int performanceChoice = 0;
        int counter;
        String quit = "";
        int bandPerform;
        String answer;
        boolean found = false;
        
        System.out.println("\nWelcome to the Band. You must be quite talented.\n");
   

        while (!quit.equals("quit")) { //repeats till they quit

            while(performanceChoice < 0 || !quit.equals("quit")){ //repeats till an int is entered 
                System.out.println("How many people would you like to add to the arrangment or type (quit): ");
                quit = in.readLine().toLowerCase(); //checks to see if they would like to quit
                try{
                    performanceChoice = Integer.valueOf(quit);
                    break;
                } catch (NumberFormatException exception){ //catches if they enter a Strung when the system is trying to convert it to an int
                    System.out.println("I said how many. Please enter an Integer amount");
                } //end of catch

            }//end of while
            if (quit.equals("quit")){ //if quit is quit then  it exists the loop 
                break;
            } //if they entered quit it will exit the loop
            for (int i = 0; i < performanceChoice; i++){//repeats for length of people that are wanted to be entered
                inst.add(assignInstrument());//calls the assignInstrument method and adds it tp it
                System.out.println("\nBand List: ");//adds 
                for (int x = 0; x < inst.size(); x++){ //loops through and prints out all the band members
                    System.out.println(inst.get(x));
                }//end of for loop
            }//end of for loop
            
            bandPerform = inst.size() + 1;
            while (bandPerform > inst.size() || bandPerform < 0) {//checks to see if amount of performs fits the the ammount aviable to play
                try{
                    System.out.println("How many would you like to perform in this performance");
                    bandPerform = Integer.valueOf(in.readLine());
                } catch(NumberFormatException e){ //catches if they enter a string when an int is wanted
                    System.out.println("Integer Please :)");
                }//end of try-catch

                if (bandPerform > inst.size()){//if they entered a number too big then this is entered
                    System.out.println("This is currently not possible with the size of your band"); 
                }//end of if
            }//end of while 
            
            counter = 0;//resets 
            while (counter < bandPerform){
                while (true){ //repeats till the user correctly inputs a name that is in the band and not in the performance
                    player = CheckIfMusicianExistsPerform(); // calls the CheckMusicianExistsPerform method to see if the player exisfs
                    found = false;
                    for (int i = 0; i < perform.size(); i ++){ //checks to see if the inputted player is already in the band while lopping through the arrayList
                        if (perform.get(i).equals(player)){
                            System.out.println("player already exists");
                            found = true;//sets found to false
                        }//end of if
                    }//end of for
                    if (found == false){ //checks to see if input is not in the performance
                        perform.add(player);//adds player to performance ArrayList
                        counter ++;
                        break;
                    }
                }//end of while
                
            }//end of while
            //counts fown from 3
            System.out.println("Performance Starting in 3");
            Thread.sleep(1000);//sleeps for 1 second
            System.out.println("Performance Starting in 2");
            Thread.sleep(1000);//sleeps for 1 second
            System.out.println("Performance Starting in 1");
            Thread.sleep(1000);//sleeps for 1 second
            System.out.println("Performance Starting!");
            System.out.println(band.toString());
            band.begin();
            perform.clear();//clears the performer list
            
            do{
                System.out.println("Would you like to clear the band (y) or (n)");
                answer = in.readLine().toLowerCase();
            } while(answer.equals("y") && answer.equals("n")); //repeats till y or n is entered
           
            if (answer.equals("y")){ //if input is equal to y then clears the object list
                inst.clear();
            }//end of if
            
        }//end of while
        System.out.println("Thank you for using this special band software");
    }//end of main
    
    public static String CheckIfMusicianExists() throws IOException{
        //set intialize variables
        String player;
        boolean found;
        while (true){
            System.out.println("\nPlease enter a band member name");
            player = in.readLine().toLowerCase();
            found = false;//set found to false
            for(int i = 0; i < inst.size(); i++){
                if (inst.get(i).getMusician().equals(player)){
                    found = true; //if the musician is equal to play input then found is true
                }//end of if
             }//end of for loop 
             if (found == true){ //if found is not different than any index of the arraylist then repeat
                 System.out.println("Member already exists");
            } else { //end of if
                break;//exists loop
            }//end fo else
        }//end of while(true)
        return player;//returns string value that will be added to list
    }//end of String function
    
    public static String CheckIfMusicianExistsPerform() throws IOException{
        String player = "";
        boolean found;
        while (true){
            
            System.out.println("\nPlease enter a performer name");
            player = in.readLine().toLowerCase();
            found = false; //set found to false
            for(int i = 0; i < inst.size(); i++){
                if (inst.get(i).getMusician().toLowerCase().equals(player)){ //cehcks to see if input is in the band
                    System.out.println("Player is in the band adding to performance");
                    found = true; 
                }//end of if
             } //end of for
             if (found == true){ //if player is in the band then they can be added to the performance
                break;
            } 
        }//end of while(true)
        return player;
    }//end of string function
}//end of class
