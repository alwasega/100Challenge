public class LinkedListIntro extends Node1{
	private Node1 head;

	public LinkedListIntro(){
		head = null;
	}

	/** Adds a node at the start of the list with the specified data.
	 * This added node will be the first node in the list
	 */
       public void addToStart(String itemName, int itemCount){
	 head = new Node1(itemName, itemCount, head);
       }

       /**
	* Removes the head node and returns true if the list contains at least one node. 
	* Returns false if the list is empty.
	*/
      public boolean deleteHeadNode(){
	     if (head != null)
	     {
		    head= head.getLink();
		   return true;
	     }
	     else
		    return false;
      }

     /**
      * Returns the number of nodes in the list
      */
    public int size(){
	  int count = 0;
	  Node1 position = head;
	  while(position != null){
		count++;
	      position = position.getLink();
	  }
	return count;
    }

    public boolean contains(String item){
	return (find(item) != null);
    }
/**
 * Finds the first node containing the target item, and returns a reference to that node. 
 * If target is not in the list, null is returned.
 */
   private Node1 find(String target){
       Node1 position = head;
       String itemAtPosition;
       while(position != null){
	itemAtPosition = position.getItem();
 	if(itemAtPosition.equals(target))
		return position;
	position = position.getLink();
       }
	return null; //target was not found
   }
   public void outputList(){
	Node1 position = head;
        while(position != null){
	System.out.println(position.getItem() + " " + position.getCount());
	position = position.getLink();
	}
   }
   //Main Class
   public static void main (String [] args){
	   LinkedListIntro list = new LinkedListIntro();
	   list.addToStart("Apples", 1);
	   list.addToStart("Bananas", 2);
	   list.addToStart("Cantaloupe", 3);//This is now the head node

	   System.out.println("List has " + list.size() + " nodes.");
	   list.outputList();

	   if(list.contains("Cantaloupe"))
		   System.out.println("Cantaloupe is on the list.");
	   else
		   System.out.println("Cantaloupe is NOT on the list.");

	   list.deleteHeadNode();
	   if(list.contains("Cantaloupe"))
                   System.out.println("Cantaloupe is on the list.");
           else
                   System.out.println("Cantaloupe is NOT on the list.");
	   while(list.deleteHeadNode());//empties the list

	   System.out.println("Start of list: ");
	   list.outputList();
	   System.out.println("End of list");

   }
		   
}
}   
