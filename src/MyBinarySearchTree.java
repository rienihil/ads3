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
        return get(root, key).val;
    }

    private Node get(Node current, K key){
        if (current == null){
            return null;
        }
        if (key==current.key){
            return current;
        }
        if (compare(key,current.key)<0){
            return get(current.left,key);
        }
        else {
            return get(current.right,key);
        }
    }

    public void delete(K key){

    }

    public Iterable<K> iterator(){
        return null;
    }
}

