package dataStructure.DoubleLinkedList.binarySearchTree;

public class BinarySearchTree {

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }

    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (value == temp.value) return false;
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;

            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;

            }
        }


    }

    public boolean contains(int value) {

        if (root == null) {
            return false;
        } else {
            Node temp = root;

            while (temp != null) {
                if (temp.value == value) {
                    return true;
                }
                if (value < temp.value) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            return false;

        }
    }


}
