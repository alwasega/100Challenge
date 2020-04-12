/*Notes**
 *A linked list is a data structure consisting of a single chain of nodes, each connected to the next by a link. 
 The example code below is an example of a linked list class. 
 In a linked list, a node is an object of some node class. Each node has a place(s) for some data and a place to hold a link to another node. 

 The first node in a linked list is called the head node. Starting from this node, one can traverse the entire linked list, visiting each node exactly once. 

 A linked list object does not directly contain all the nodes in the linked list. It contains only the instance variable head that contains a reference to the first or head node. However, every node can be reached from this head node. 
 * */
private class Node1{
	private String item;
	private int count;
	private Node1 link; //a reference to the next node

	//Constructor
	public Node1(){
		link = null;
		item = null; 
		count = 0;
	}

	public Node1 (String newItem, int newCount, Node1 linkValue){
		setData(newItem, newCount);
		link = linkValue;
	}

	public void setData(String newItem, int newCount){
		item = newItem;
		count = newCount;
	}
	
	public void setLink(Node1 newLink){
		link = newLink;
	}

	public String getItem(){
		return item;
	}

	public int getCount(){
		return count;
	}

	public Node1 getLink(){
		return link;
	}
	
}

