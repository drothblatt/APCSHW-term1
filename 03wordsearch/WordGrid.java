public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	for (int row = 0; row < data.length; row++){
	    for (int i = 0; i < data[row].length; i++){
		data[row][i] = '_';
	    }
	}
	
    }

    /**Set all values in the WordGrid to spaces ' ' */
    private void clear(){
	for (int row = 0; row < data.length; row++){
	    for (int i = 0; i < data[row].length; i++){
		data[row][i] = ' ';
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
	

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	boolean result = true;
	if (word > data[row].length) {
	    result = false;
	    return result;
	}
	for (int boxPos = col && int wordPos = 0; start < word.length(); start++ && wordPos++){
	    if (data[row][boxPos] == ' ' || word.chatAt(wordPos) == data[row][boxPos] ){
		data[row][boxPos] == word.charAt(wordPos);
	    } else{
		result = false;
		return result;
	    }
	}


	return result;
    }

    //vertical + diagonal should be implemented as well.

    public static void main(String[] args){
	WordGrid firstTry = new WordGrid(5,5);
	System.out.println(firstTry.toString());
	firstTry.clear();
	System.out.println("new box..." + firstTry.toString() + "...end of new box");
    }
	

}
