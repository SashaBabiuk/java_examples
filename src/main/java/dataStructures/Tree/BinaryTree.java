package dataStructures.Tree;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class BinaryTree<T extends Comparable<T>>{
    class Node<T>{
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }
    Node<T> root;
    public static <T extends Comparable<T>> BinaryTree<T> of(T... elements) {
        BinaryTree<T> binaryTree = new BinaryTree<>();
        Stream.of(elements).
                forEach(binaryTree::insert);
        return binaryTree;
    }

    public boolean insert(T element) {
        if(root == null){
            root = new Node<>(element);
            return true;
        }else {
            return insert(root,element);
        }
    }

    private boolean insert(Node<T> current, T element) {
        if (element.compareTo(current.value) < 0) { // left
            if (current.left == null) {
                current.left = new Node<>(element);
                return true;
            } else {
                return insert(current.left, element);
            }
        } else if (element.compareTo(current.value) > 0) { // go right
            if (current.right == null) {
                current.right = new Node<>(element);
                return true;
            } else {
                return insert(current.right, element);
            }
        } else {
            // Element already exists in the tree
            return false;
        }
    }

    public boolean contains(T element) {
        return contains(root,element);
    }

    private boolean contains(Node<T> current,T element){
        if (current == null) {
            return false;
        } else if(current.value.compareTo(element) > 0){ //go left
            return contains(current.left,element);
        }else if(current.value.compareTo(element) < 0){ //go right
            return contains(current.right,element);
        }else {
            return true;
        }
    }


    public int depth() {
        return depth(root);
    }
    private int depth(Node<T> current){
        if(current == null){
            return 0;
        }else{
            return Math.max(depth(current.left), depth(current.right)) + 1;
        }
    }

    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root,consumer);
    }
    private void inOrderTraversal(Node<T> current,Consumer<T> consumer){
        if(consumer != null){
            inOrderTraversal(current.left,consumer);
            consumer.accept(current.value);
            inOrderTraversal(current.right,consumer);
        }
    }

    public Node<T> findElement(T element) {
        return findElement(root, element);
    }

    private Node<T> findElement(Node<T> node, T element) {
        if (node == null) {
            return null;
        }

        int compareResult = node.value.compareTo(element);

        if (compareResult == 0) {
            return node;
        } else if (compareResult < 0) {
            return findElement(node.right, element);
        } else {
            return findElement(node.left, element);
        }
    }

    public Node<T> remove(T value){
        return remove(root,value);
    }

    private Node<T> remove(Node<T> root,T value){
        if(root == null){
            return root;
        }

        if(root.value.compareTo(value) > 0){
            root.right = remove(root.right,value);
        } else if (root.value.compareTo(value) < 0) {
            root.left = remove(root.left,value);
        }else{
            if(root.left == null){
                return root.left;
            }else if(root.right == null){
                return root.left;
            }
            root.value = min(root.right).value;
            root.right = remove(root.right, root.value);
        }
        return root;
    }

    public Node<T> min(Node<T> current){
        if(current.left == null){return current;}
        return min(current.left);
    }

    public void printTree(){
        printTree(root,1);
    }


    private Node<T> printTree(Node<T> root,int level) {
        if (root == null) {
            return root;
        }

        printTree(root.right,level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("-----");
        }
        System.out.println(root.value);
        printTree(root.left,level+1);
        return root;
    }

    public int getCountElements(){
        return getCountElements(root);
    }

    private int getCountElements(Node<T> current){
        if(current != null){
            return 1 + getCountElements(current.left) + getCountElements(current.right);
        }
        return 0;
    }
 }
