public class OrderedSuperArray extends SuperArray{
    private String[] OrderedSuperArray;

    public OrderedSuperArray(int size){
	OrderedSuperArray = new String[size];
    }

    public boolean add(int index, String element){ //should tell us true or false
	boolean rightPlace = false;
	if (size() == 0){
	    rightPlace = true;
	} else if (index == size()){
	    rightPlace =  (element.compareTo(get(index-1)) >= 0);
	} else if (index == 0 && size() > 1){
	    rightPlace =  (element.compareTo(get(index+1)) <= 0);
	} else if (index + 1 < size() && index-1 >0){
	    rightPlace =  (element.compareTo(get(index+1)) <= 0) && 
		          (element.compareTo(get(index-1)) >= 0);
	}
	System.out.println( "Is " + element + " at index " + index + " properly sorted? " + rightPlace);
	return rightPlace;
    }
	
    public void add(String element){
	if (size() == 0){
	    super.add(element);
	} else{
	    for (int i = 0; i < size(); i++){
		if (element.compareTo(get(i)) <= 0){
		    super.add(i-1,element);
		    System.out.println("should've added");
		}
	    }
	
	}
    }

    public static void main(String[]args){
	OrderedSuperArray L = new OrderedSuperArray(10);
	System.out.println("L: " + L.toString());

	L.add("Hello");
	System.out.println(L.toString());
	L.add("Hat");
	/*
	System.out.println(L.toString());
	L.add("Hi");
	System.out.println(L.toString());

        L.add(0,"Ham");
	L.add("Ham");
	System.out.println(L.toString());
	L.add("Hippo");
	System.out.println(L.toString());
	L.add("Hop");
	System.out.println(L.toString());
	L.add("Huevos");
	System.out.println(L.toString());
        L.add(2,"Hell");
	L.add("Hell");
	System.out.println(L.toString());
	*/
    }

}
