import java.util.Random;

public class WordGrid{
    private char[][]data;
    private char[] alphabet = {'a','b','c','d','e','f','g','h',
			       'i','j','k','l','m','n','o','p',
			       'q','r','s','t','u','v','w','x',
			       'y','z'};

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
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
	
    }

    /**Set all values in the WordGrid to spaces '_' */
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
	

    public void fillRest(){
	Random r = new Random();
	for (int row = 0; row < data.length; row ++){
	    for (int col = 0; col < data[row].length; col++){
		if (data[row][col] == ' ' ){
		    data[row][col] = alphabet[r.nextInt(alphabet.length)];
		}
	    }
	}
    }

						     




    /***************************************/

    // Time to check!
    public static void main(String[] args){
	WordGrid a = new WordGrid(7,7);
	System.out.println(a.addWord("hello", 2, 3, 0, 0)); //1 - false
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 2, 2, 0, 1)); //2 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 6, 2, 0, -1)); //3 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 1, 2, 1, 0)); //4 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 2, 2, 1, 1)); //5 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 5, 2, 1, -1)); //6 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 2, 6, -1, 0)); //7 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 2, 5, -1, 1)); //8 - true
	System.out.println(a.toString());
	a.clear();

	System.out.println(a.addWord("hello", 6, 6, -1, -1)); //9 - true
	System.out.println(a.toString());
	a.clear();
	
    }
	
}



