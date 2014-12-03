public class SuperArray{
    private String[] superArray;
    private int elCount; 

    public SuperArray(){ // Default Constructor
	superArray = new String[10];
    }

    public SuperArray(int size){ // Constuctor that takes a size
	superArray = new String[size];
    }

    // basic methods for part 1...

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
            resize(superArray.length+1);
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

}
