import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordGen{
    ArrayList<String> words = new ArrayList<String>();

    public static void fileToArrayList() throws FileNotFoundException{
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
    
	while(s.hasNextLine()){
	    String nextWord = s.nextLine();
	    words.add(nextWord);
	}
    }

    public static String toString(){
	String result = "[ ";
       	for (int i = 0; i < words.length; i++){
	    result += words.get(i) + " ";
	}
	result += "]";
	return result;
    }
    public static void main(String[]args) throws FileNotFoundException{
	fileToArrayList();
	toString();


	
    }
}
