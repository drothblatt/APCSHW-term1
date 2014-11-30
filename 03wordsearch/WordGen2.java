import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class WordGen2{
    static ArrayList<String> words = new ArrayList<String>();
    static ArrayList<String> used = new ArrayList<String>();


    public static void loadWordsFromFile() throws FileNotFoundException{
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
    
	while(s.hasNextLine()){
	    String nextWord = s.nextLine();
	    words.add(nextWord);
	}
    }

    public static String wordsInPuzzle(){
	String result = "Find these words: \n ";
       	for (int i = 0; i < used.size()-3; i++){
	    int line = 0;
	    while (line < 4){
		result += used.get(i+line) + "    ";
	    }
	    result += "\n";
	}
	return result;
    }
    
    public static void addWordsToGrid(){
	Random r = new Random();

	String largestWord = words.get(r.nextInt(words.size()));
	int maxSize = largestWord.length();
	WordGrid2 gen = new WordGrid2(maxSize,maxSize);


	for (int i = 0; i < words.size(); i++){
	    if ((words.get(i)).length() <= maxSize){
		int whichWay = r.nextInt(5)+1;
		if (whichWay == 1){
		    for (int row = 0; row < maxSize; row++){
			for (int col = 0; col < maxSize; col++){
			    try{
				if (!used.contains(words.get(i))){
				    if (gen.addWordVertical(words.get(i),row,col))
					used.add(words.get(i));
				}
			    } catch (ArrayIndexOutOfBoundsException e){
				System.out.println("");
			    }
			}
		    }
		} else if (whichWay == 2){
		    for (int row = 0; row < maxSize; row++){
			for (int col = 0; col < maxSize; col++){
			    try{
				if (!used.contains(words.get(i))){
				    if (gen.addWordHorizontal(words.get(i),row,col))
				        used.add(words.get(i));
				}
			    }catch (ArrayIndexOutOfBoundsException e){
				System.out.println("");
			    }
			}
		    }
		} else if (whichWay == 3){
		    for (int row = 0; row < maxSize; row++){
			for (int col = 0; col < maxSize; col++){
			    try{
				if (!used.contains(words.get(i))){
				    if (gen.addWordDiagonal(words.get(i),row,col))
				        used.add(words.get(i));
				}
			    }catch (ArrayIndexOutOfBoundsException e){
				System.out.println("");
			    }
			}
		    }
		} else if (whichWay == 4){
		    for (int row = 0; row < maxSize; row++){
			for (int col = 0; col < maxSize; col++){
			    try{
				if (!used.contains(words.get(i))){
				    if (gen.addWordVerticalRev(words.get(i),row,col))
					used.add(words.get(i));
				}
			    } catch (ArrayIndexOutOfBoundsException e){
				System.out.println("");
			    }
			}
		    }	
		} else if (whichWay == 5){
		    for (int row = 0; row < maxSize; row++){
			for (int col = 0; col < maxSize; col++){
			    try{
				if (!used.contains(words.get(i))){
				    if(gen.addWordHorizontalRev(words.get(i),row,col))
					used.add(words.get(i));
				}			   
			    } catch (ArrayIndexOutOfBoundsException e){
				System.out.println("out of bounds");
			    }
			}
		    }
		}
	    }
	}
	gen.fillRest();

	
	System.out.println(wordsInPuzzle());
	System.out.println(gen.toString());

    }
    
    public static void main(String[]args) throws FileNotFoundException{
	loadWordsFromFile();
	addWordsToGrid();
    }
}
