package dataStructures.Tree;

import java.util.stream.Stream;

public class AVLBinaryTree<T extends Comparable<T>> {
    public class Node<T> {
        int height;
        T key;
        Node<T> left;
        Node<T> right;

        public Node(T key) {
            this.key = key;
        }
    }

    private Node<T> root;

    private void updateHeight(Node<T> node){node.height = 1 + Math.max(height(node.left),height(node.right));}

    private int height(Node<T> node){return node == null ? -1 : node.height;}

    public int getBalance(Node<T> node){return (node == null) ? 0 : height(node.right) - height(node.left);}

    public Node<T> rightRotation(Node<T> y){
        Node<T> x = y.left;
        Node<T> z = x.right;

        y.left = z;
        x.right = y;

        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node<T> leftRotation(Node<T> y){
        Node<T> x = y.right;
        Node<T> z = x.left;

        x.left = y;
        y.right = z;

        updateHeight(x);
        updateHeight(y);
        return x;
    }

    public static<T extends Comparable<T>> AVLBinaryTree<T> of(T... elements){
        AVLBinaryTree<T> avlBinaryTree = new AVLBinaryTree<>();
        Stream.of(elements).forEach(avlBinaryTree::insert);
        return avlBinaryTree;
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private Node<T> insert(Node<T> node, T element) {
        if (node == null) {
            return new Node<>(element);
        }

        int compareResult = node.key.compareTo(element);

        if (compareResult < 0) {
            node.left = insert(node.left, element);
        } else if (compareResult > 0) {
            node.right = insert(node.right, element);
        } else {
            System.out.println("Duplicate key!!!!");
        }

        return rebalance(node);
    }

    private Node<T> delete(Node<T> node, T element){
        if(node == null){
            return null;
        }

        if(node.key.compareTo(element) > 0){
            node.right = delete(node.right,element);
        }else if(node.key.compareTo(element) < 0) {
            node.left = delete(node.left,element);
        }else{
            if(node.left == null){
                node = node.right;
            }else if(node.right == null){
                node = node.left;
            }else{
                Node<T> mostLeftChild = max(node.left);
                node.key = mostLeftChild.key;
                node = mostLeftChild;
                node.right = delete(node.right,node.key);
            }
        }
        if(node != null){
            node = rebalance(node);
        }
        return node;
    }
    private Node<T> max(Node<T> node){
        if(node == null){
            return null;
        }
        return max(node.right);
    }
    private Node rebalance(Node<T> root) {
        updateHeight(root);
        int balance = getBalance(root);

        if (balance > 1) {
            if(height(root.right.right) > height(root.right.left)){
                root = leftRotation(root);
            } else if(height(root.right.left) > height(root.right.right)){
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        } else if (balance < 1) {
            if(height(root.left.left) > height(root.left.right)){
                root = rightRotation(root);
            }else if(height(root.left.right) > height(root.left.left)){
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        }
        return root;
    }


}