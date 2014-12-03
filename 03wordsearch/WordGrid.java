import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class WordGrid{
    private char[][]data;
    private char[] alphabet =  {'a','b','c','d','e','f','g','h',
				'i','j','k','l','m','n','o','p',
				'q','r','s','t','u','v','w','x',
				'y','z'};
    private ArrayList<String> words;
    private ArrayList<String> used;
    private Random r; 


    /**Initialize the grid to the size specified and fill all of the positions
     *with underscores.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	for (int row = 0; row < data.length; row++){
	    for (int col = 0; col < data[row].length; col++){
		data[row][col] = '_';
	    }
	}
	words = new ArrayList<String>();
	used = new ArrayList<String>();
	r = new Random();

    }

    /** Set all values in the WordGrid to spaces '_' 
     */
    private void clear(){
	for (int row = 0; row < data.length; row++){
	    for (int i = 0; i < data[row].length; i++){
		data[row][i] = '_';
	    }
	}
    }
    

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String result = "";
	for (int row = 0; row < data.length; row++){
	    for (int i = 0; i < data[row].length; i++){
		result += data[row][i] + " ";
	    }
	    result += "\n";
	}
	return result;
    }

    /** Checks to see if a word will
     */
    public boolean checkWord(String word, int row, int col, int dx, int dy){
	if ( (dx == 0 && dy == 0) || (row < 0 || col < 0) ||
	     (row + dy*word.length() > data.length) ||
	     (row + dy*word.length() < 0) ||
	     (col + dx*word.length() > data[0].length) ||
	     (col + dx*word.length() < 0) ){
	    return false;
	}
	for (int i = 0; i < word.length(); i++){
	    if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    row += dy;
	    col += dx;
	}
	return true;
    }


    public boolean addWord(String word, int row, int col, int dx, int dy){
	if (checkWord(word,row,col,dx,dy)){
	    for (int i = 0; i < word.length(); i++){
		data[row][col] = word.charAt(i);
		row += dy;
		col += dx;
	    }
	    return true;
	} else {
	    return false;
	}
    }
    
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{ 
	File text = new File(fileName);
	Scanner s = new Scanner(text);
	while(s.hasNextLine()){
	    String nextWord = s.nextLine();
	    words.add(nextWord);
	}
	randomize(words);
	addManyWordsToList(words);
	if (fillRandomLetters){
	    fillRest();
	}
    }

    public void addManyWordsToList(ArrayList<String> allWords){
	int rMax = data.length;
	int cMax = data[0].length;
	int tries = 0;
	for (int i = 0; i < allWords.size(); i++){
	    if (!used.contains(allWords.get(i))){
		do{
		    if (addWord(allWords.get(i), r.nextInt(rMax), r.nextInt(cMax), r.nextInt(3)-1, r.nextInt(3)-1)){
			used.add(allWords.get(i));
		    }
		    tries++;
		} while (used.contains(allWords.get(i)) == false && tries < 35);
	    }
	    tries = 0;
	}
    }

   public void fillRest(){
	for (int row = 0; row < data.length; row ++){
	    for (int col = 0; col < data[row].length; col++){
		if (data[row][col] == '_' ){
		    data[row][col] = alphabet[r.nextInt(alphabet.length)];
		}
	    }
	}
    }
	    				     
    public String wordsInPuzzle(){
	String result = "";
       	for (int i = 0; i < used.size(); i++){
	    if (i % 4 == 0){
		result += "\n";
	    }
	    result += used.get(i) + addSpaces(used.get(i));
	}
	result += "\n";
	return result;
    }

    public String addSpaces(String word){
	int spaces = 15 - word.length();
	String space = " ";
	for (int i = 0; i < spaces; i++){
	    space += " ";
	}
	return space;
    }

    public void randomize( ArrayList<String> L) {
	for (int i = 0; i < L.size(); i++){
	    String x = L.get(r.nextInt(L.size()-i) + i);
	    String y = L.get(i);
	    int flip = L.indexOf(x); // tells us where to put y. 
	    L.set(i, x);
	    L.set(flip, y);
	}
    }

    public String check(){
	String result = "[ ";
	for (int i = 0; i < used.size(); i++){
	    result += used.get(i) + " ";
	}
	result += "]";
	return result;
    }

    public void setSeed(long seed){
	r.setSeed(seed);	
    }

    public int getWordCount(){
	return used.size();
    }


    /***************************************/

    // Time to check!
    public static void main(String[] args) throws FileNotFoundException{
	WordGrid b = new WordGrid(12,12);
        b.loadWordsFromFile("words.txt",true);
	System.out.println( "\nFind these words:\n" + b.wordsInPuzzle());
	System.out.println(b.toString());
    }

    // The end!!
	
}



