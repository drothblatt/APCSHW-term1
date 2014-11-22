import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class WordGen{
    static ArrayList<String> words = new ArrayList<String>();

    public static void fileToArrayList() throws FileNotFoundException{
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
    
	while(s.hasNextLine()){
	    String nextWord = s.nextLine();
	    words.add(nextWord);
	}
    }

    public static String arrayListToString(){
	String result = "[ ";
       	for (int i = 0; i < words.size(); i++){
	    result += words.get(i) + " ";
	}
	result += "]";
	return result;
    }
    
    public static void addWordsToGrid(){
	Random r = new Random();

	String largestWord = words.get(r.nextInt(words.size()));
	int maxSize = largestWord.length();
	WordGrid gen = new WordGrid(maxSize,maxSize);
        ArrayList<String> alreadyUsed = new ArrayList<String>();


	for (int i = 0; i < words.size(); i++){
	    if ((words.get(i)).length() <= maxSize){
		int whichWay = r.nextInt(5)+1;
		if (whichWay == 1){
		    for (int row = 0; row < maxSize; row++){
			for (int col = 0; col < maxSize; col++){
			    try{
				if (!alreadyUsed.contains(words.get(i))){
				    gen.addWordVertical(words.get(i),row,col);
				    alreadyUsed.add(words.get(i));
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
				if (!alreadyUsed.contains(words.get(i))){
				    gen.addWordHorizontal(words.get(i),row,col);
				    alreadyUsed.add(words.get(i));
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
				if (!alreadyUsed.contains(words.get(i))){
				    gen.addWordDiagonal(words.get(i),row,col);
				    alreadyUsed.add(words.get(i));
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
				if (!alreadyUsed.contains(words.get(i))){
				    gen.addWordVerticalRev(words.get(i),row,col);
				    alreadyUsed.add(words.get(i));
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
				if (!alreadyUsed.contains(words.get(i))){
				    gen.addWordHorizontalRev(words.get(i),row,col);
				    alreadyUsed.add(words.get(i));
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
	System.out.println(gen.toString());
    }
    
    public static void main(String[]args) throws FileNotFoundException{
	fileToArrayList();
	System.out.println(arrayListToString());
	addWordsToGrid();
    }
}
