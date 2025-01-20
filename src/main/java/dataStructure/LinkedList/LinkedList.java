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

/*    Write a method called hasLoop that is part of the linked list class.

    The method should be able to detect if there is a cycle or loop present in the linked list.

    You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.

    This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.

    The method should follow these guidelines:



    Create two pointers, slow and fast, both initially pointing to the head of the linked list.

    Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.

    If there is a loop in the list, the fast pointer will eventually meet the slow pointer. If this occurs, the method should return true.

    If the fast pointer reaches the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.



    Output:

    Return true if the linked list has a loop.

    Return false if the linked list does not have a loop.



    Constraints:

    You are not allowed to use any additional data structures (such as arrays) or modify the existing data structure.

    You can only traverse the linked list once.


    Method signature:

    public boolean hasLoop()*/

    public boolean hasLoop()
    {
        Node slow=head;
        Node fast=head;

        if(head==null || head.next==null)
        {
            return false;
        }
        if(fast.next.next==null)
        {
            return false;
        }

        while(fast.next!=null)
        {
            slow=slow.next;
            if(fast.next.next!=null)
            {
                fast=fast.next.next;
            }
            else{
                fast=fast.next;
            }

            if (slow==fast)
            {
                return true;
            }
        }
        return false;

    }

/*    LL: Find Kth Node From End ( ** Interview Question)
    Implement a method called findKthFromEnd that returns the k-th node from the end of the list.

    If the list has fewer than k nodes, the method should return null.

    Note: This implementation of the Linked List class does not have the length attribute.

    Method signature:

    public Node findKthFromEnd(int k)*/

    public Node findKthFromEnd(int k)
    {
        if (head == null || k <= 0)
        {
            return null; // Edge case: empty list or invalid k
        }

        Node slow=head;
        Node fast=head;

        for(int i=0;i<k;i++)
        {
            if(fast==null)
            {
                return null;
            }
            fast=fast.next;
        }
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

}



