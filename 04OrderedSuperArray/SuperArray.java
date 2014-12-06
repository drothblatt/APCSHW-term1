import java.util.Arrays;

public class SuperArray{
    private String[] superArray;
    private int elCount; 

    public SuperArray(){ // Default Constructor
	superArray = new String[10];
    }

    public SuperArray(int size){ // Constuctor that takes a size
	superArray = new String[size];
    }

    // NEWEST METHODS... DECEMBER!!!

    public void insertionSort(){
	if (size() == superArray.length){
            resize(superArray.length*2);
        }
	for (int i = 0; i < size(); i++){
	    String minString = get(i);
	    int posOfMinString = i;
	    while (posOfMinString > 0 && 
		   get(posOfMinString-1).compareTo(minString) > 0){
		superArray[posOfMinString] = superArray[posOfMinString-1];
		posOfMinString--;
	    }
	    superArray[posOfMinString] = minString;
	}
    }
    public boolean verifyInsertionSort(){ //in class 2014-12-03
	SuperArray a1 = new SuperArray(superArray.length);
	SuperArray a2 = new SuperArray(superArray.length);
	for (int i = 0; i < superArray.length; i++){
	    a1.add( (get(i)) );
	    a2.add( (get(i)) );
	}
	a1.insertionSort();
	Arrays.sort(a2.superArray);
	return (a1.equals(a2));
    }

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }



	    
    // end of stuff from 2014-12-03  

    // 2014-12-04
    public int find(String target){
	for (int index = 0; index < size(); index ++){
	    if (target.equals(get(index))){
		return index;
	    }
	}
	return -1;
    }

    
    // end of stuff from 2014-12-04

    // 2014-12-05
    public void selectionSort(){
	int stillUnsorted = 0;
	for (int i = 0; i < size(); i++){
	    String move = get(i);
	    int moveTo = find(minString(stillUnsorted));
	    set(i,minString(stillUnsorted));
	    set(moveTo,move);
	    stillUnsorted++;
	}
    }
    public String minString(int stillUnsorted){
	String min = get(stillUnsorted);
	for (int i = stillUnsorted; i < size() ; i++){
	    if ( (get(i)).compareTo(min) < 0  ) {
		min = get(i);
	    }
	}
	return min;
    }
    // end of stuff from 2014-12-05
    
    public String toString(){ // representation of array [ e1 e2 e3 ... ]
	String result = "[ ";
	for (int i = 0; i < superArray.length; i++){
	    result += superArray[i];
	    result += " ";
	}
	result += " ]";
	return result;
    }


    
    public void add(String e){
	if (elCount < superArray.length){
	    superArray[elCount] = e;
	    elCount ++;
	} else { // note: already gave add() ability to increase 
	         // if needed on day 1, didn't change this fxn on day 2
	    resize(superArray.length*2);
	    superArray[elCount] = e;
	    elCount ++;
	}
    }
    
    public int size(){ // returns number of elements in the list
	int size = 0;
	for (int i = 0; i < superArray.length; i++){
	    if (superArray[i] != null){
		size++;
	    }
	}
	return size;
    }

    public void resize(int newCapacity){
	String[] newArray = new String[newCapacity];
	for (int i = 0; i < newArray.length && i < superArray.length; i++){
	    newArray[i] = superArray[i];
        }
        superArray = newArray;
    }

    public void clear(){
        String[] cleanArray = new String[superArray.length];
	superArray = cleanArray;
    }


    public String get(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return superArray[index];
    }

    public void add(int index, String o){
        if (size() == superArray.length){
            resize(superArray.length*2);
        }
        String[] copyArray = new String[superArray.length];
	for (int i = 0; i < superArray.length; i++){
	    copyArray[i] = superArray[i];
	}
        for (int i = index; i < superArray.length-1; i++){
            superArray[i+1] = copyArray[i];
        }
        set(index,o);
	elCount++;
    }

    public String set(int index, String o){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
	String old = get(index);
        superArray[index] = o;
        return old;
    }


    public String remove(int index){
        String[] origArray = superArray;
	String result;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else{
	    result = superArray[index];
	    for (int i = index; i < superArray.length-1; i++){
		superArray[i] = superArray[i+1];
	    }
	    if (size() == origArray.length) {
	        resize(origArray.length - 1);    
	    } else{
		superArray[superArray.length-1] = null;
	    }
	}
	return result;
    }
    
    public static void main(String[]args){
	SuperArray names = new SuperArray(5);
	names.add("Tyler");
	names.add("Miki");
	names.add("Louis");
	names.add("Ari");
	names.add("Max");
	names.add("Zack");
	names.add("David");
	names.add("Bob");
	System.out.println( names );
	System.out.println("should be index 3: " + names.find("Ari"));
	System.out.println("should be index 6: " + names.find("David"));
	System.out.println("should be index -1: " + names.find("Jake"));

	
	System.out.println("Before:  " + names.toString());
	names.selectionSort();
	System.out.println("After:   " + names.toString());
	

	/*
	// 2014-12-03 (in class)
	//System.out.println("Success?? " + names.verifyInsertionSort());

	if (args[0].equals("0")){ // use good insertionSort
	    System.out.println("Before:  " + names.toString());
	    names.insertionSort();
	    System.out.println("After:  " + names.toString());

	} else if (args[0].equals("1")){ // use badInsertionSort
	    System.out.println("Before:  " + names.toString());
	    names.badInsertionSort();
	    System.out.println("After:  " + names.toString());
	}
	*/

	// end of stuff from 2014-12-03 (in class)

	/*
	System.out.println("Before:  " + names.toString());
	names.insertionSort();
	System.out.println("After:   " + names.toString());
	*/
    }

}
