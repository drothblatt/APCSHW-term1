import java.util.Random;
public class Driver{

    // SORTS.JAVA HAS A MAIN THAT CHECKS THE ACTAUL FUNCTIONALITY OF THE FXNS!

    public static void main(String[]args){
	Random r = new Random();

	if (args.length > 0){
	    if (args[0].equals("1")){
		int[] bs = new int[200000];
		for (int i = 0; i < 20; i++){
		    bs[i] = r.nextInt(2000) - 10;
		}
		Sorts.bubble(bs);
		System.out.println("Bubble Sort is done!");
	    } else if (args[0].equals("2")){
		int[] ss = new int[200000];
		for (int i = 0; i < 20; i++){
		    ss[i] = r.nextInt(2000) - 10;
		}
		Sorts.selection(ss);
		System.out.println("Selection Sort is done!");
	    } else if (args[0].equals("3")){
		int[] is = new int[200000];
		for (int i = 0; i < 20; i++){
		    is[i] = r.nextInt(2000) - 10;
		}
		Sorts.insertion(is);
		System.out.println("Insertion Sort is done!");
	    } else{
		System.out.println("Nothing done. Try again.");
	    }
	}
    }
}
