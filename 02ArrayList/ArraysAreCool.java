import java.util.ArrayList;

public class ArraysAreCool{
    // Modify the list so that consecutive duplicates are removed
    public static void collapseDuplicates(ArrayList<Integer> L){ // went with static. 
	for (int i = 0; i < L.size()-1; i++){
	    if (L.get(i).equals(L.get(i+1))){
		L.remove(i+1); 
		i--; // want to stay on index of beginning of consecutive dups until only one remains. 
	    }
	}
    }

    public static void main(String[]args){
	ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(new Integer(1));
	L.add(new Integer(1));
	L.add(new Integer(1));
	L.add(new Integer(3));
	L.add(new Integer(2));
	L.add(new Integer(2));
	L.add(new Integer(8));
	L.add(new Integer(9));
	L.add(new Integer(9));
	L.add(new Integer(4));
	L.add(new Integer(4));
	L.add(new Integer(7)); // lucky 7s!
	L.add(new Integer(7));
	L.add(new Integer(7));
	// -----------------//
	System.out.println(L); //toString() not needed. cool. 
	collapseDuplicates(L);
       	System.out.println("Expecting [1, 3, 2, 8, 9, 4, 7]... \n" + L);
    }
}
    
