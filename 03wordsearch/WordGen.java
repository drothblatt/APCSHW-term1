import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordGen{




    public static void fileToArrayList() throws FileNotFoundException{
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
    
	ArrayList<String> words = new ArrayList<String>();
    
	while(s.hasNextLine()){
	    String nextWord = s.nextLine();
	    words.add(nextWord);
	}
    }

    public static void main(String[]args) throws FileNotFoundException{
	fileToArrayList();
	for (int i = 0; i < words.length; i++){

	}
	
    }
}
