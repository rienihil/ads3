import java.util.Iterator;

public class Main {
    public static <K> void main(String[] args){
        MyHashTable<MyTestingClass, String> ht = new MyHashTable<>();

        MyBinarySearchTree<Integer, String> bst = new MyBinarySearchTree<>();
        bst.put(2, "a");
        bst.put(6, "g");
        bst.put(9, "bg");
        bst.put(0,"fs");
        System.out.println(bst.get(0));
        System.out.println(bst.get(6));
    }
}