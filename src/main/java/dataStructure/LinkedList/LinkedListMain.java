package dataStructure.LinkedList;

public class LinkedListMain {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("LL before remove():");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("LL after remove() in middle:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(0).value);
        System.out.println("LL after remove() of first node:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("LL after remove() of last node:");
        myLinkedList.printList();

        System.out.println("\nReverse Linked List");
        myLinkedList.reverse();
        myLinkedList.printList();


        System.out.println("\nFind Middle Node");
        myLinkedList.append(6);
        myLinkedList.append(3);
        myLinkedList.append(4);
        System.out.println("Print All list before finding middle Node");
        myLinkedList.printAll();
        System.out.println("Miidle Node : " +myLinkedList.findMiddleNode().value);


        System.out.println("\nFind Kth element Node");
        System.out.println(myLinkedList.findKthFromEnd(4).value);


        /*
            EXPECTED OUTPUT:
            ----------------
            LL before remove():
            1
            2
            3
            4
            5

            Removed node:
            3
            LL after remove() in middle:
            1
            2
            4
            5

            Removed node:
            1
            LL after remove() of first node:
            2
            4
            5

            Removed node:
            5
            LL after remove() of last node:
            2
            4

            Reverse Linked List
            4
            2

        */

    }

}
