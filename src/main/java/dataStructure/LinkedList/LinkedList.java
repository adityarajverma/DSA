package dataStructure.LinkedList;

public class LinkedList
{

    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        int value;
        Node next;

        Node( int value)
        {
            this.value= value;
            this.next= null;
        }
    }


    //Constructor
    public LinkedList(int value)
    {
        Node newNode= new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length=1;
       
    }


    //Append a new node at the end of the list


    //Prepend a new node at the start of the list


    //Insert a new node after a given node

    //Get Head
    public Node getHead()
    {
        return this.head;
    }

    //Get Tail

    public Node getTail()
    {
        return this.tail;
    }

    //Get Length

    public int getLength()
    {
        return this.length;
    }

    
}