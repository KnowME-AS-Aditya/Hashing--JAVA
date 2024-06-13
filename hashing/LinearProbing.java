/*
 * Data Structures and Algorithms--Greedy
 */
package hashing;

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
import java.util.*;
public class LinearProbing {

    /**
     * @param args the command line arguments
     */
    private int[] table;
    private int size;
    public LinearProbing(int size){
        this.table=new int[size];
        this.size=size;
        Arrays.fill(table,0);
    }
    public void insert(int key){
        int hash_func=key%size;
        while(table[hash_func]!=0){
            hash_func=(hash_func+1)%size;
        }
        table[hash_func]=key;
    }
    public boolean search(int key){
        int hash=key%size;
        while(table[hash]!=0){
            if(table[hash]==key)
                 return true;
            hash=(hash+1)%size;
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LinearProbing ht=new LinearProbing(10);
        ht.insert(8);
        ht.insert(3);
        ht.insert(13);
        ht.insert(5);
        ht.insert(4);
        ht.insert(10);
        System.out.println("Hash Table is: "+Arrays.toString(ht.table));
        if(ht.search(5))
            System.out.println("Is present.");
        else
            System.out.println("Not Present!!");
     
    }
    
}
