
public class Driver{
    public static void main(String[]args){
	int rows, cols, randomSeed, answers ;
	if (args.length > 0 && args.length < 2){
	    System.out.println("Try Again. Need to enter at least" + 
			       "<rows> & <columns>");
	} else if (args.length >= 2){
	    if (args[0] > 0){
		rows = args[0];
	    }
	    if (args[1] > 0){
		cols = args[1];
	    }
	}
	WordGrid w = new WordGrid(rows, cols);
	w.loadWordsFromFile("words.txt");

    /*
	    randomSeed
	} else if (args.length >= 4){
	    if (args[3] == 1){
		answers = 1;
	    }
	}
	
	        
		
    }
    */
	WordGrid w = new WordGrid(rows, cols);
        if(you need to change the random seed){  
	    /*see more notes on this later*/
	   w.setSeed( ??? );  
	}
	w.loadWordsFromFile("fileNameYouMade.txt", 
			    /*something from NEW SECTION*/ );
	System.out.println( "Find these words:\n"+ w.wordsInPuzzle() );
	System.out.println( w );
    }
}
