import java.util.Random;
import java.util.Arrays;

public class TimeTests{

    public static void main(String[]args){
	Random r = new Random();
	long startTime, endTime;
	int[] a = new int[50000];

	// adding random numbers to array
	for (int i = 0; i < a.length; i++){
	    a[i] = r.nextInt(Integer.MAX_VALUE);
	}

	// testing bubble sort
	int[] bs = Arrays.copyOf(a, a.length);
	startTime = System.currentTimeMillis();
	Sorts.bubble(bs);
	endTime = System.currentTimeMillis();
	System.out.println("Bubble Sort:\n" + (endTime-startTime));

	// testing selection sort 
	int[] ss = Arrays.copyOf(a, a.length);
	startTime = System.currentTimeMillis();
	Sorts.selection(ss);
	endTime = System.currentTimeMillis();
	System.out.println("Selection Sort:\n" + (endTime-startTime));

	// testing insertion sort
	int[] is = Arrays.copyOf(a, a.length);
	startTime = System.currentTimeMillis();
	Sorts.insertion(is);
	endTime = System.currentTimeMillis();
	System.out.println("Insertion:\n" + (endTime-startTime));

	// testing Arrays sort
	int[] as = Arrays.copyOf(a, a.length);
	startTime = System.currentTimeMillis();
	Arrays.sort(as);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays Sort:\n" + (endTime-startTime));

    }
}
