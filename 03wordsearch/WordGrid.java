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
	boolean result = false;
        if (row >= data.length || col >= data[row].length){
	    throw new ArrayIndexOutOfBoundsException();
	}  
	if (word.length() > data[row].length - col){
	    return result;
	}
	for (int pos = 0; pos < word.length(); pos++){
	    if (data[row][col+pos] != ' ' &&  word.charAt(pos) != data[row][col+pos] ){
		return result;
	    }
	}
	for (int pos = 0; pos < word.length(); pos++){
	    data[row][col+pos] = word.charAt(pos);
	}
	result = true;
	return result;
    }

    //vertical + diagonal should be implemented as well.

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */

    public boolean addWordVertical(String word,int row, int col){
	boolean result = false;
        if (row >= data.length || col >= data[row].length){
	    throw new ArrayIndexOutOfBoundsException();
	}  
	if (word.length() > data.length - row){
	    return result;
	}
	for (int pos = 0; pos < word.length(); pos++){
	    if (data[row+pos][col] != ' ' &&  word.charAt(pos) != data[row+pos][col] ){
		return result;
	    }
	}
	for (int pos = 0; pos < word.length(); pos++){
	    data[row+pos][col] = word.charAt(pos);
	}
	result = true;
	return result;
    }


   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left-top to bottom-right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */

    public boolean addWordDiagonal(String word,int row, int col){
	boolean result = false;
        if (row >= data.length || col >= data[row].length){
	    throw new ArrayIndexOutOfBoundsException();
	}  
	if (word.length() > data.length - row){
	    return result;
	}
	for (int pos = 0; pos < word.length(); pos++){
	    if (data[row+pos][col+pos] != ' ' &&  word.charAt(pos) != data[row+pos][col+pos] ){
		return result;
	    }
	}
	for (int pos = 0; pos < word.length(); pos++){
	    data[row+pos][col+pos] = word.charAt(pos);
	}
	result = true;
	return result;
    }

    public String reverse(String word){
	String reverse = "";
	for (int i = word.length()-1; i >= 0; i--){
	    reverse += word.charAt(i);
	}
	return reverse;
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

    public boolean addWordHorizontalRev(String word, int row, int col){
	col = col - word.length()+1;
	return addWordHorizontal(reverse(word),row,col);
    }

    public boolean addWordVerticalRev(String word, int row, int col){
	row = row - word.length()+1;
	return addWordVertical(reverse(word),row,col);
    }









    // Time to check!
    public static void main(String[] args){
	WordGrid firstTry = new WordGrid(5,5);

	System.out.println("Expecting Watermelon: " + firstTry.reverse("Watermelon"));

	System.out.println(firstTry.toString());
	firstTry.clear();
	System.out.println("new box..." + firstTry.toString() + "...end of new box \n");
	try {
	    // addWordHorizontal
	    System.out.println("trying addWordHorizontal (false): " + firstTry.addWordHorizontal("pizza",3,3) );
	    System.out.println("trying addWordHorizontal (true): " + firstTry.addWordHorizontal("pizza",3,0) );
	    System.out.println("trying addWordHorizontal (false): " + firstTry.addWordHorizontal("pizzas",4,0) );
	    System.out.println("trying addWordHorizontal (false): " + firstTry.addWordHorizontal("hi",3,3) );
	    System.out.println("trying addWordHorizontal (true): " + firstTry.addWordHorizontal("hi",4,3) );
	    System.out.println("trying addWordHorizontal (true): " + firstTry.addWordHorizontal("yay",2,1) );
	    System.out.println("trying addWordHorizontal (false): " + firstTry.addWordHorizontal("pizza",2,0) );
	    
	    // let's see how it looks, then clear it to try something else
	    System.out.println(firstTry.toString() +"\n\n");
	    firstTry.clear();
	    System.out.println("new box..." + firstTry.toString() + "...end of new box \n");


	    // addWordVertical
	    System.out.println("trying addWordVertical (false): " + firstTry.addWordVertical("pizza",3,3) );
	    System.out.println("trying addWordVertical (false): " + firstTry.addWordVertical("pizza",3,0) );
	    System.out.println("trying addWordVertical (false): " + firstTry.addWordVertical("pizzas",4,0) );
	    System.out.println("trying addWordVertical (true): " + firstTry.addWordVertical("hi",3,3) );
	    System.out.println("trying addWordVertical (false): " + firstTry.addWordVertical("pizza",0,3) );	    
	    System.out.println("trying addWordVertical (true): " + firstTry.addWordVertical("pizza",0,4) );
	    System.out.println("trying addWordVertical (true): " + firstTry.addWordVertical("yay",2,1) );
	    System.out.println("trying addWordVertical (false): " + firstTry.addWordVertical("pizza",0,1) );

	    	    
	    // let's see how it looks, then clear it to try something else
	    System.out.println(firstTry.toString() +"\n\n");
	    System.out.println("trying addWordHorizontal (false): " + firstTry.addWordHorizontal("pizza",4,0) );
	    System.out.println("trying addWordHorizontal (true): " + firstTry.addWordHorizontal("pop",0,2) );
	    System.out.println(firstTry.toString() +"\n\n"); // should have pop and pizza crossing...
	    firstTry.clear();

	    // addWordDiagonal
	    System.out.println("trying addWordDiagonal (false): " + firstTry.addWordDiagonal("pizza",3,3) );
	    System.out.println("trying addWordDiagonal (false): " + firstTry.addWordDiagonal("pizza",3,0) );
	    System.out.println("trying addWordDiagonal (false): " + firstTry.addWordDiagonal("pizzas",4,0) );
	    System.out.println("trying addWordDiagonal (false): " + firstTry.addWordDiagonal("pizza",1,3) );
	    System.out.println("trying addWordDiagonal (true): " + firstTry.addWordDiagonal("pizza",0,0) );
	    System.out.println(firstTry.toString() +"\n");
	    firstTry.clear();
	    System.out.println("trying addWordDiagonal (true): " + firstTry.addWordDiagonal("hit",2,2) );
	    System.out.println("trying addWordDiagonal (true): " + firstTry.addWordDiagonal("yay",0,2) );
	    System.out.println("trying addWordDiagonal (false): " + firstTry.addWordDiagonal("pizza",2,1) );
	    //addWord("pizza",0,1) --> error...why?... should just be false. 

	    System.out.println(firstTry.toString() +"\n\n");
	    System.out.println("trying addWordHorizontal (false): " + firstTry.addWordHorizontal("pizza",4,0) );
	    System.out.println("trying addWordHorizontal (true): " + firstTry.addWordHorizontal("fight",4,0) );
	    System.out.println("trying addWordHorizontal (true): " + firstTry.addWordHorizontal("great",1,0) );

	    
	    System.out.println("trying addWordHorizontalRev (true): " + firstTry.addWordHorizontalRev("tilt",3,4) );
	    System.out.println(firstTry.toString() +"\n\n"); // should have hit and fight meeting at bottom right...

	    firstTry.clear();
	    System.out.println("trying addWordVerticalRev (true): " + firstTry.addWordVerticalRev("goof",4,0) );
	    System.out.println(firstTry.toString()); 

	    firstTry.clear();

	} catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("Oops. Tried to access either a non-existant row or column. Fix this!");
	}



    }
	
}
