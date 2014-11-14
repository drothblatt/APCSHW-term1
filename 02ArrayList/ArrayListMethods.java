import java.util.*;

public class ArrayListMethods{
    
    public static void collapseDuplicates(ArrayList<Integer> L){ // went with static. 
	for (int i = 0; i < L.size()-1; i++){
	    if (L.get(i).equals(L.get(i+1))){
		L.remove(i+1); 
		i--; // want to stay on index of beginning of consecutive dups until only one remains. 
	    }
	}
    }
    public static void randomize( ArrayList<Integer> L) {
	Random r = new Random();
	for (int i = 0; i < L.size(); i++){
	    int x = L.get(r.nextInt(L.size()-i) + i);
	    int y = L.get(i);
	    int flip = L.indexOf(x); // tells us where to put y. 
	    L.set(i, x);
	    L.set(flip, y);
	}
    }

    public static void main(String[]args){
	Random r = new Random();
	ArrayList<Integer> L = new ArrayList<Integer>();
	
	// Testing collapseDuplicates(L)...

	for (int i = r.nextInt(5)+1; i < 32; i += r.nextInt(8) ){
	    int reps = r.nextInt(4)+1;
	    while (reps > 0){
		L.add(new Integer(i));
		reps --;
	    }
	}
	
	System.out.println("Testing collapseDuplicates(L)");
	System.out.println(L); //toString() not needed. cool. 
	collapseDuplicates(L);
       	System.out.println(L);

	// Testing randomize(L)...

	System.out.println("\nTesting randomize(L)");
       	System.out.println(L);
	randomize(L); // no issues with using the list already made. 
	System.out.println(L);
      
    }
}
    
