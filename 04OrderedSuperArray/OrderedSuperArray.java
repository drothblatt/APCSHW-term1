public class OrderedSuperArray extends SuperArray{
    private String[] OrderedSuperArray;

    public OrderedSuperArray(int size){
	OrderedSuperArray = new String[size];
    }

    public void add(int index, String element){
	add(element);
    }
	
    public void add(String element){
	if (size() == 0){
	    super.add(element);
	} else{
	    for (int i = 0; i < size(); i++){
		if (element.compareTo(get(i)) >= 0){
		    super.add(i,element);
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
	System.out.println(L.toString());
	L.add("Hi");
	System.out.println(L.toString());
        L.add(5,"Ham");
	System.out.println(L.toString());
	L.add("Hippo");
	System.out.println(L.toString());
	L.add("Hop");
	System.out.println(L.toString());
	L.add("Huevos");
	System.out.println(L.toString());
        L.add(2,"Hell");
	System.out.println(L.toString());
	
    }

}
