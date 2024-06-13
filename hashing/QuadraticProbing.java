
package hashing;

import java.util.Arrays;

/**
 *
 * @author Aditya Ranjan Sahoo <adityaen.official101@gmail.com>
 */
public class QuadraticProbing {
    private int[] table;
    private int size;
    public QuadraticProbing(int size){
        this.table=new int[size];
        this.size=size;
        Arrays.fill(table,0);
    }
    public void insert(int key){
        int hash_func=key%size;
        int counter=0;
        while(table[hash_func]!=0){
            hash_func=(hash_func+counter*counter)%size;
            counter++;
             if (counter == size) {
                throw new RuntimeException("Hash table is full");
            }
        }
        table[hash_func]=key;
    }
    public boolean find(int key){
        int hash=key%size;
        int counter=1;
        while(table[hash]!=0){
            if(table[hash]==key)
                return true;
            hash=(hash+counter*counter)%size;
        }
        return false;
    }
    public static void main(String[] args){
        QuadraticProbing ht=new QuadraticProbing(11);
        ht.insert(8);
        ht.insert(3);
        ht.insert(13);
        ht.insert(6);
        ht.insert(4);
        ht.insert(10);
        ht.insert(23);
        ht.insert(43);
        System.out.println("Hash Table is: "+Arrays.toString(ht.table));
        if(ht.find(23))
            System.out.println("Is present.");
        else
            System.out.println("Not Present!!");
    }

}
