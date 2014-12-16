import java.util.Random;

public class Sorts{
    public static void bubble(int[] c){
	int higher = 0;
	boolean noSwaps = false;
	while (!noSwaps){
	    noSwaps = true;
	    for (int i = 0; i < c.length-1; i++){
		if (c[i] > c[i+1]){
		    higher = c[i];
		    c[i] = c[i+1];
		    c[i+1] = higher;
		    noSwaps = false;
		}
	    }
	}
    }

    public static void insertion(int[] c){
    }

    public static void selection(int[] c){
    }




    public static void main(String[]args){
	Random r = new Random();
	int[] c = new int[20];
	for (int i = 0; i < 20; i++){
	    c[i] = r.nextInt(61) - 10;
	}
	bubble(c);
	System.out.println(c.toString());
    }
}
	    


