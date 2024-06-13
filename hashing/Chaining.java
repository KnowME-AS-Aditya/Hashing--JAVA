/*
 * Data Structures and Algorithms--Greedy
 */
package hashing;
import java.util.*;

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
class Node{
    int key;
    Node next;
    Node(int key){
        this.key=key;
        this.next=null;
    }
}
public class Chaining {

    /**
     * @param args the command line arguments
     */
    List<LinkedList<Node>> hashTable;
    int size;

    public Chaining(int size) {
        this.size = size;
        this.hashTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        LinkedList<Node> chain = hashTable.get(index);
        for (Node node : chain) {
            if (node.key == key) {
                return; // Key already exists, no need to insert
            }
        }
        chain.add(new Node(key));
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        LinkedList<Node> chain = hashTable.get(index);
        for (Node node : chain) {
            if (node.key == key) {
                return true;
            }
        }
        return false;
    }

      public static void main(String[] args) {
        // TODO code application logic here
        Chaining hashTable = new Chaining(10);

        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(35);
        hashTable.insert(8);
        hashTable.insert(18);

        System.out.println(hashTable.search(15)); // true
        System.out.println(hashTable.search(25)); // true
        System.out.println(hashTable.search(35)); // true
        System.out.println(hashTable.search(18)); // false
    }
}

  
