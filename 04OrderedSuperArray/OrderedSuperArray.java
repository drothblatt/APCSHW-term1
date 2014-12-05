public class OrderedSuperArray extends SuperArray{
    private String[] OrderedSuperArray;

    public OrderedSuperArray(int size){
	OrderedSuperArray = new String[size];
    }
    public OrderedSuperArray(){
	OrderedSuperArray = new String[10];
    }

    public void add(int index, String element){
	add(element);
    }
	
    public void add(String element){
	boolean done = false; // allows for end of while loop
	int i = 0; // index
	if (size() == 0){
	    super.add(element);
	} else{
	    do{
		if (element.compareTo(get(i)) <= 0){
		    super.add(i,element);
		    done = true;
		} else{
		    i++;
		}
	    } while (!done && i < size());
	    if (i == size()){
		super.add(element);
	    }
	}
    }

    public int find(String target){
	int beg = 0;
	int end = size()-1;   
	int index = (beg + end)/2;
	boolean found = false;
	while (beg <= end){
		index = (beg + end)/2;
		if (target.compareTo(get(index)) == 0){
		    return index; //this must be the answer
		} else if (target.compareTo(get(index)) < 0){
		    end = index - 1;
		} else if (target.compareTo(get(index)) > 0){	
		    beg = index + 1;
		}
	}
	return -1;
    }


    public static void main(String[]args){
	OrderedSuperArray L = new OrderedSuperArray(10);
	System.out.println(L.toString());

	L.add("Hello");
	System.out.println(">> " + L.toString());
	L.add("Hat");
	System.out.println(">> " + L.toString());
	L.add("Hi");
	System.out.println(">> " + L.toString());
        L.add(5,"Ham");
	System.out.println(">> " + L.toString());
	L.add("Hippo");
	System.out.println(">> " + L.toString());
	L.add("Hi");
	System.out.println(">> " + L.toString());
	L.add("Hop");
	System.out.println(">> " + L.toString());
	L.add("Huevos");
	System.out.println(">> " + L.toString());
        L.add(2,"Hell");
	System.out.println(">> " + L.toString());
	L.add("Homicide");
       	System.out.println(">> " + L.toString());
	L.add("Ha");
       	System.out.println(">> " + L.toString());
	L.add("Huge");
	System.out.println(">> " + L.toString());
	L.add("Howdy");
	System.out.println(">> " + L.toString());

	
	System.out.println("Hell - should be at 3:  " + L.find("Hell"));
	System.out.println("Hi  - should be at 5:  " + L.find("Hi"));
	System.out.println("Hop - should be at 9:  " + L.find("Hop"));
	System.out.println("Howdy - should be at 10:  " + L.find("Howdy"));
	System.out.println("Hippo - should be at 7:  " + L.find("Hippo"));
       	System.out.println("Hot - not in L. should be -1:  " + L.find("Hot"));
	System.out.println("Harry - not in L. should be -1:  " + L.find("Harry"));

	

	
    }

}
