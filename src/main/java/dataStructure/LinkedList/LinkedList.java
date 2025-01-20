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

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }


    //Append a new node at the end of the list
    public void append(int value)
    {
        Node newNode= new Node(value);
        if (length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else {
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }


    //Prepend a new node at the start of the list
    public void prepend(int value)
    {
        Node newNode=new Node(value);
        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }


    //Insert a new node after a given node
    public void insert(int index, int value)
    {

    }

    //get
    public Node get(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }

        if(length==1)
        {
            return head;
        }
        Node temp= head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    //set
    public boolean set(int index , int value)
    {
        Node temp=get(index);
        if(temp==null)
        {
            return  false;
        }
        else
        {
            temp.value=value;
            return  true;
        }
    }

    //remove last
    public Node removeLast()
    {
        if(length==0)
        {
            return null;
        }
        Node pre= head;
        Node temp= head;
        while(temp.next!=null)
        {
            pre=temp;
            temp=temp.next;
        }
        pre.next=null;
        tail=pre;
        length--;
        if(length==0)
        {
            head=null;
            tail=null;
        }
        return temp;
    }

    //remove first
    public Node removeFirst()
    {
        if(length==0)
        {
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0)
        {
            head=null;
            tail=null;
        }
        return temp;
    }

    //remove
    public Node remove(int index)
    {
        if(index<0 ||index>=length)
        {
            return null;
        }
        if(index==0)
        {
            return removeFirst();
        }
        if(index==length-1)
        {
            return removeLast();
        }
        Node pre= get(index-1);
        Node temp=pre.next;
        pre.next=temp.next;
        temp.next=null;
        length--;
        return temp;

    }

    //Reverse Linked List
    public void reverse()
    {
        Node temp= head;
        head=tail;
        tail=temp;

        Node before=null;
        Node after= temp.next;

        for (int i=0;i<length;i++)
        {
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }

    }

    //

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

/*    Implement a method called findMiddleNode that returns the middle node of the linked list.
    If the list has an even number of nodes, the method should return the second middle node.
    Note: this LinkedList implementation does not have a length member variable.

    Method signature:
    public Node findMiddleNode()*/
    public Node findMiddleNode()
    {
        Node slow=head;
        Node fast=head;

        if(head==null)
        {
            return null;
        }

        //If length is 1
        if(slow.next==null)
        {
            return head;
        }
        //If length is 2
        if(head.next==null)
        {
            return head;
        }

        while(fast.next!=null)
        {
            slow=slow.next;
            if(fast.next.next !=null) {
                fast = fast.next.next;
            }
            else
            {
                fast=fast.next;
            }
        }
        return slow;
    }

    
}