public class SuperArray{
    private Object[] superArray;
    private int elCount; 

    public SuperArray(){ // Default Constructor
	superArray = new Object[10];
    }

    public SuperArray(int size){ // Constuctor that takes a size
	superArray = new Object[size];
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

    public void add(Object e){
	if (elCount < superArray.length){
	    superArray[elCount] = e;
	    elCount += 1;
	} else { // note: already gave add() ability to increase 
	         // if needed on day 1, didn't change this fxn on day 2
	    resize(superArray.length+1);
	    superArray[elCount] = e;
	    elCount += 1;
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

    public void resize(int newSize){
	Object[] newArray = new Object[newSize];
	for (int i = 0; i < newArray.length && i < superArray.length; i++){
	    newArray[i] = superArray[i];
        }
        superArray = newArray;
    }

    // extra methods in part 1...

    public void clear(){
	Object[] newArray = new Object[superArray.length];
	superArray = newArray;
    }

    /*   public Object get(int index){
	return superArray[index];
	} 

    public void set(int index, Object e){
	superArray[index] = e;
	}  */

    // ... end of extra methods



    public Object get(int index){
        if (index < 0 || index >= size()) {
            System.out.println("Error. Index is out of range.");
            return null;
        }
	    return superArray[index];
    }
    /*
    public void add(int index, Object o){
        if (size() == superArray.length){
            resize(superArray.length+1);
        }
        Object[] copyArray = superArray;
       	System.out.println(toString());
	String copyArrayString = "[ ";
	for (int i = 0; i < copyArray.length; i++){
	    copyArrayString += copyArray[i] + " ";
	}
	copyArrayString += " ]";
	System.out.println(copyArrayString);
        for (int i = 0; i < superArray.length-1; i++){
            superArray[i+1] = copyArray[i];
	    System.out.println("copyArray[i]" + copyArray[i]);
	    System.out.println(toString());

        }
        set(index,o);
    }
    */

    public Object set(int index, Object o){
        if (get(index) != null){
	    Object result = get(index);
            superArray[index] = o;
	    return result;
        }
        return null;
    }


    public Object remove(int index){
        Object[] origArray = superArray;
	Object result;
        if (index < 0 || index >= /*superArray.*/size()) {
            System.out.println("Error. Index is out of range.");
            return null;
        } else{
	    result = superArray[index];
	    for (int i = index; i < superArray.length-1; i++){
		superArray[i] = superArray[i+1];
	    }
	    if (/*origArray.*/size() == origArray.length) {
		/*superArray.*/resize(origArray.length - 1);    
	    } else{
		superArray[superArray.length-1] = null;
	    }
	}
	return result;
    }





    public static void main(String[]args){
	SuperArray L = new SuperArray(6);
	System.out.println(L.toString());

	L.add("Hi");
	System.out.println(L.size());
	L.add(1);
	System.out.println(L.size());
	L.add(2);
	System.out.println(L.size());
	L.add("sup");
	System.out.println("should be 4:" + L.size());
	System.out.println(L.toString());
	L.add(9);
	System.out.println("should be 5:" + L.size());
	System.out.println(L.toString());

	System.out.println("should be 'sup':" + L.get(3));
	System.out.println(L.get(8));

	System.out.println("checking the add method");

	//L.add(3, "not much");
	System.out.println(L.toString());


	L.resize(15);
	System.out.println(L.size());
	System.out.println(L.toString());
	/* L.resize(2);
	System.out.println(L.size());
	System.out.println(L.toString()); */

	//L.clear();
	System.out.println(L.toString());

	L.resize(10);
	L.set(5,true);
	System.out.println(L.toString());
	System.out.println("should be 'true':" + L.get(5));
	
	System.out.println(" ** removed ** ");
	System.out.println(L.remove(3));
	System.out.println(L.toString());
	// running code has confirmed remove fxn works!
	System.out.println("checking set");
	System.out.println(L.set(10,false));
	System.out.println(L.set(2, "hullo"));

	System.out.println(L.toString());




    }




}
