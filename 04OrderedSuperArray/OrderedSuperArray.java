public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }

    public boolean add(int index, String element){ //should be a boolean instead
	if (index ==  OrderedSuperArray.size()-1){
	    return (element.compareTo(OrderedSuperArray.get(i-1)) >= 0);
	} else{
	    return (element.compareTo(OrderedSuperArray.get(i+1)) <= 0);
	}
    }
	
    public void add(String element){
	for (int i = 0; i < OrderedSuperArray.length; i++){
	    if (add(i, element)){
		super.add(i,element);
	    }
	}
	
    }

    public static void main(String[]args){
	OrderedSuperArray L = new OrderedSuperArray(10);
	System.out.println("L:  " + L.toString());

	L.add("Hello");
	System.out.println(L.toString());
	L.add("Hat");
	System.out.println(L.toString());
	L.add("Hi");
	System.out.println(L.toString());

	System.out.println("should be true: " + add(0,"Ham"));
	L.add("Ham");
	System.out.println(L.toString());
	L.add("Hippo");
	System.out.println(L.toString());
	L.add("Hop");
	System.out.println(L.toString());
	L.add("Huevos");
	System.out.println(L.toString());
	System.out.println("should be true: " + add(2,"Hell"));
	L.add("Hell");
	System.out.println(L.toString());
    }

}
