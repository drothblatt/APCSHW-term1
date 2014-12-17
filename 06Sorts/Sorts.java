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
	for (int i = 0; i < c.length; i++){
	    int indOfMin = i;
	    for (int j = i + 1; j < c.length; j++){ // finds index of smallest val
		if (c[j] < c[indOfMin]){
		    indOfMin = j; 
		}
	    }
	    int moveOut = c[i]; // moving day: old value moves out, smallest moves in!
	    c[i] = c[indOfMin];
	    c[indOfMin] = moveOut;
	}
    }


    public static String toString(int[] c){
	String result = "[ "; 
	for (int i = 0; i < c.length; i++){
	    result += c[i] + " ";
	}
	result += " ]";
	return result;
    }
	   
    public static void main(String[]args){

	Random r = new Random();
	int[] bs = new int[20];
	int[] is = new int[20];
	int[] ss = new int[20];

	for (int i = 0; i < 20; i++){
	    bs[i] = r.nextInt(61) - 10;
	    is[i] = r.nextInt(61) - 10;
	    ss[i] = r.nextInt(61) - 10;
	}

	bubble(bs);
	System.out.println("Bubble Sort: "    + toString(bs));

	selection(ss);
	System.out.println("Selection Sort: " + toString(ss));

    }
}
	    


