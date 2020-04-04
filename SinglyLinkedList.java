/*NOTES**
A linked list, in its simplest form, is a collection of nodes that collectively form a linear sequence. In a singly linked list, each node stores a reference to an object that is an element of the sequence, as well as a refernce to the next node of the list. lizryan

Minimally, a linked list instance must keep reference to the head, which is the first node of the list. The last node is the tail, and can be found by traversing the linked list, starting from the head and moving from one node to another by following each node's next reference. The tail can be identified as the node that has null as its next reference. The process of traversing the list is known as link hopping/ pointer hopping. However, storing an explicit reference to the tail node is a common efficiency to avoid such a traversal. Similarly, it is common for a linked list instance to keep count of the total number of nodes that comprise the list (known as the size of the list) to avoid traversing the list to count the nodes. 

***A linked list contains an element, and a pointer to next. 

**IMPLEMENTING A SINGLY-LINKED LIST CLASS
A singly-linked list class supports the following methods: 
             - size(): Returns the number of elements in the list.
             - isEmpty() : Returns true if the list is empty, and false otherwise.
             - first() : Returns (but does not remove) the first element in the list.
             - last(): Returns (but does not remove) the last element in the list.
             - addFirst(e): Adds a new element to the front of the list.
             - addLast(e): Adds a new element to the end of the list.
             - removeFirst(): Removes and returns the first element of the list. 
If the first(), last(), and removeFirst() are called on a list that is empty, we will return a null reference and leave the list unchanged. 

The implementation below uses Java's generics framework to define a class with a formal type parameter E that represents the user's desired element type. Also, it uses Java's support for nested classes to define the Node class, thereby, providing strong ecapsulation.*/

public static SinglyLinkedList{

    //Use a nested class to represent the Node
    private static class Node<E>{
	private E element;           //reference to the element stored at this node
	private Node<E> next;   //reference to the subsequent node in the list

	//constructor
	public Node(E e, Node<E> n){
	    element = e;
	    next = n;
	}

	public E getElement(){return element; }
	public Node<E> getNext(){return next; }
	public void setNext(Node<E> n){next = n; }
    } //end of nested node class

    //Getting onto the SinglyLinkedList class

    //Instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    //Constructor
    public SinglyLinkedList(){
	//empty
    }

    //access methods
    public int size(){return size; }
    
    public boolean isEmpty(){ return size ==0; }

    public E first(){
	if (isEmpty())
	    return null;
	return head.getElement()
    }

    public E last(){
	if (isEmpty())
	    return null;
	return tail.getElement()
    }

    //update methods
    public void addFirst(E e){
	head = new Node<>(e, head);
	if (size==0)
	    tail = head;
	size++;
    }

    public void addLast(E e){
	Node<E> newest = new Node<>(e, null); //node will eventually be the tail
	if(isEmpty())
	    head = newest;
 	else
	    tail.setNext(newest); //new node after existing tail
	tail = newest;                  //new node becomes the tail
	size++;
	}

    public E removeFirst(){
	if(isEmpty())
	    return null;
	E answer = head.getElement();
	head = head.getNext();     //will become null if list had only one node
	size--;
	if(size==0)
	    tail=null;
	return answer;
    }
}
