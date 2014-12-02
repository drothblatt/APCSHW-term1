import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{
    public static boolean checkInputs(int rows, int cols, int randomSeed){
	return rows <= 0 || rows > 40 || cols <= 0 || cols > 40 || randomSeed <= 0;
    }

    public static void main(String[]args) throws FileNotFoundException{
	int rows, cols, randomSeed;
	boolean fill;
	// default... will change unless default is needed. 
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
				   "\n>> #ofRows/#ofCols must be btwn 0 & 40."+	
				   "\n>> randomSeed must be greater than 0.");
	    }
	}

	if (args.length == 4){
	    try{
		int answers = Integer.parseInt(args[3]);
		if (answers == 1){
		    fill = false;
		} else{
		    fill = true;
		}
	    } catch (Exception e){
		System.out.println("");
	    }
	}
	if (!checkInputs(rows,cols,randomSeed)){ //default
	    WordGrid w = new WordGrid(rows, cols);
	    if(randomSeed != 0){  
		w.setSeed(randomSeed);  
	    }
	    w.loadWordsFromFile("words.txt", fill);
	    System.out.println( w.wordsInPuzzle() );
	    System.out.println( w );
	} else{
	    System.out.println(">> Something went wrong. Maybe you should try again.");
	}
    }
}
