import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;


// THIS FILE HAS A MAIN THAT CHECKS THE ACTUAL FUNCTIONALITY OF THE FXNS!
// THE SEPERATE DRIVER IN THIS REPO IS TO TEST THE SPEEDS OF THE FXNS!

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
	for (int i = 1; i < c.length; i++){
	    int currentVal = c[i];
	    int j;
	    for ( j = i; j > 0  && currentVal < c[j-1]; j--){
		c[j] = c[j-1];
	    }
	    c[j] = currentVal;
	}
    }

    public static void selection(int[] c){
	for (int i = 0; i < c.length-1; i++){
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

    public static void radix(int[] c){
	int maxVal = c[0];
	for (int i = 0; i < c.length; i++){
	    if (c[i] > maxVal){
		maxVal = c[i];
	    }
	}
	String maxValS = "" + maxVal;
	int maxPass = maxValS.length();
	int passes = 0;

	while (passes < maxPass){
	    ArrayList[] buckets = new ArrayList[10];
	    for (int i = 0; i < 10; i++){
		buckets[i] = new ArrayList(); 
	    }
	    for (int i = 0; i < c.length; i++){
		buckets[((c[i]/(10*passes)) % 10)].add(c[i]);
	    }
	    int ind = 0;
	    for (int j = 0; j < buckets.length; j++) {
		for (int k = 0; k < buckets[j].size(); k++){
		    int n = buckets[j].get(k);
		    c[ind] = n; 
		}
	    }
	    passes++;
	}
    }

    public static String name(){
	return "Rothblatt,David";
    }
    public static int period(){
	return 6;
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
	int[] rs = new int[20];

	for (int i = 0; i < 20; i++){
	    bs[i] = r.nextInt(61) - 10;
	    is[i] = r.nextInt(61) - 10;
	    ss[i] = r.nextInt(61) - 10;
	    rs[i] = r.nextInt(60) + 1;
	}
	/*
	bubble(bs);
	System.out.println("Bubble Sort: "    + toString(bs));

	insertion(is);
	System.out.println("Insertion Sort: " + toString(is));

	selection(ss);
	System.out.println("Selection Sort: " + toString(ss));
	*/

	radix(rs);
	System.out.println("Radix Sort: " + toString(rs));


    }
}
	    


