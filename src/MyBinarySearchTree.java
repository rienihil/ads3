import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyBinarySearchTree<K extends Comparable<K>, V> {
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key=key;
            this.val=val;
            this.left=null;
            this.right=null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }
    private Node root;
    private int size;

    public MyBinarySearchTree(){
        root=null;
        size=0;
    }

    private int compare(K key1, K key2){
        return key1.compareTo(key2);
    }

    public void put(K key, V val){
        root=put(root, key, val);
    }

    private Node put(Node current, K key, V val){
        size++;
        if (current == null)
            return new Node(key, val);
        if (compare(key, current.key)<0) {
            current.left = put(current.left, key, val);
        }
        else {
            current.right = put(current.right, key, val);
        }
        return current;
    }

    public V get(K key){
        return getNode(root, key).val;
    }

    public int getSize() {
        return size;
    }

    private Node getNode(Node current, K key){
        if (current == null){
            return null;
        }
        if (key==current.key){
            return current;
        }
        else if (compare(key,current.key)<0){
            return getNode(current.left,key);
        }
        else {
            return getNode(current.right,key);
        }
    }

    public void delete(K key){
        root=delete(root, key);
    }

    private Node delete(Node current, K key){
        if (current==null){
            return null;
        }
        size--;
        if (compare(key,current.key)<0){
            return delete(current.left, key);
        }
        else if (compare(key,current.key)>0){
            return delete(current.right, key);
        }
        else {
            if (current.left == null && current.right == null){
                return null;
            }
            if (current.left == null){
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            Node minVal = findMinVal(current.left);
            current = minVal;
            current.left = delete(current.left, minVal.key);
        }
        return current;
    }
    private Node findMinVal(Node node) {
        return node.right == null ? node : findMinVal(node.right);
    }

    public Iterator<K> iterator(){
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<K> {
        List<K> list = new ArrayList<>();
        int index=0;

        public BSTIterator(){
            inOrder(root);
        }

        private void inOrder(Node node){
            if (node!=null){
                inOrder(node.left);
                list.add(node.key);
                inOrder(node.right);
            }
        }

        @Override
        public boolean hasNext() {
            return index<list.size();
        }

        @Override
        public K next() {
            return list.get(index++);
        }
    }
}

