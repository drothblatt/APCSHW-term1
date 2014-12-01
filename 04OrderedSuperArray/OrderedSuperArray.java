public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
    }
    
    public void add(String element){
	for (int i = 0; i < OrderedSuperArray.length; i++){
	    if (element.compareTo(OrderedSuperArray.get(i+1)) <= 0){
		super.add(element);
	    }
	}
	
    }






}