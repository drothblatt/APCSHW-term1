import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{
    public static boolean checkInputs(int rows, int cols){
	return rows <= 0 || rows > 75 || cols <= 0 || cols > 75;
    }

    public static void main(String[]args) throws FileNotFoundException{
	int rows, cols, randomSeed;
	boolean fill;
	// default... will change unless default is needed. 
	rows = 0;
	cols = 0;
	fill = true;
	// end of default.
	boolean toosmall;
	try{
	    String x = args[2];
	    toosmall = false;
	} catch (Exception e){
	    System.out.println("Not enough inputs. Try again.\n" +
			       ">> Need: Java Driver <#ofRows> <#ofCols> <RandSeed>\n" +
			       ">> Optional: Java Driver <#ofRows> <#ofCols> <RandSeed>" );
	    toosmall = true;
	}
	if (!toosmall){
	    try{
		int r = Integer.parseInt(args[0]);
		int c = Integer.parseInt(args[1]);
		rows = r;
	        cols = c;	       
		// in order to cause error for invalid ints.
		if (checkInputs(rows,cols)){ 
		    String y = args[100];
		}
	    } catch (Exception e){
		System.out.println("Invalid inputs for #ofRows and #ofCols.\n>> Must be positive integer"+	
				   "(btwn 0 and 75 non-inclusive).");
	    }
	}

	if (args.length == 4){
	    try{
		int a = Integer.parseInt(args[3]);
		if (a == 1){
		    fill = false;
		} else{
		    fill = true;
		}
	    } catch (Exception e){
		System.out.println("Invalid input to call for answers. Must " + 
				   "be an integer.\n>> A '1' will show the " + 
				   "answer key, all other numbers won't.");
	    }
	}
	if (!checkInputs(rows,cols)){ //default
	    WordGrid w = new WordGrid(rows, cols);
	    /*
	      if(you need to change the random seed){  
	      see more notes on this later
	      w.setSeed( ??? );  
	      }
	    */
	    w.loadWordsFromFile("words.txt", fill);
	    System.out.println( w.wordsInPuzzle() );
	    System.out.println( w );
	}
    }
}
