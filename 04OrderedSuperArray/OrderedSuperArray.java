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
	
    }

}
