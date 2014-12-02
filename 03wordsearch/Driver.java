import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{
    public static boolean checkInputs(int rows, int cols, int randomSeed){
	return rows < 3 || rows > 40 || cols < 3 || cols > 40 || randomSeed <= 0;
    }

    public static void main(String[]args) throws FileNotFoundException{
	int rows, cols, randomSeed;
	boolean fill;
	// original initialization (in case it doesn't happen later) 
	rows = 0;
	cols = 0;
	randomSeed = 0;
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
		rows = Integer.parseInt(args[0]);
		cols = Integer.parseInt(args[1]);
		randomSeed = Integer.parseInt(args[2]);
		//randomSeed = rSeed;.
		if (checkInputs(rows,cols,randomSeed)){ 
		    String y = args[100];
		}
	    } catch (Exception e){
		System.out.println("Invalid inputs for #ofRows, #ofCols, and/or randomSeed." +
				   "\n>> #ofRows/#ofCols must be btwn 3 & 40."+	
				   "\n>> randomSeed must be greater than 0.");
	    }
	}

	if (args.length == 4){
	    try{
		int answers = Integer.parseInt(args[3]);
		if (answers == 1){
		    fill = false;
		    System.out.println("\n*** ANSWER KEY!");
		} else{
		    fill = true;
		    System.out.println("\n*** For ANSWER KEY, fourth input (index 3) must be '1'. ");
		}
	    } catch (Exception e){
		System.out.println("\n*** For ANSWER KEY, fourth input (index 3) must be '1'. ");
	    }
	} else if (args.length == 3 && !checkInputs(rows,cols,randomSeed)){
	    System.out.println("\n*** For ANSWER KEY, fourth input (index 3) must be '1'. ");
	}

	if (!checkInputs(rows,cols,randomSeed)){ //wGrid must have the right inputs or we're done
	    WordGrid w = new WordGrid(rows, cols);
	    if(randomSeed != 0){  
		w.setSeed(randomSeed);  
	    }
	    w.loadWordsFromFile("words.txt", fill);
	    System.out.println( "\nFind these words:\n" + w.wordsInPuzzle() );
	    System.out.println( w );

	    System.out.println( "Total number of words in puzzle: "  // my own addition
				+ w.getWordCount() + "\n" );

	} 
    }
}
