import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

public class HashIndex<K, N>{ 
// Index storage using hashing with chaining    
    
    K cunyID; //Key is cunyID
    N name; //Holds value for the names
  
    HashIndex<K, N> next; 
  
    // Constructor 
    public HashIndex(K cunyID, N name){ 
        this.cunyID = cunyID; 
        this.name = name;
        this.next = null; 
    }

    class Map<K, N>{
        private ArrayList<HashIndex<K, N>> bucketArray; //bucketArray stores array of chains
        private int numBuckets;
        private int size; //size of array list

        public Map(){
            bucketArray = new ArrayList<>();
            numBuckets = 99999999; //max out buckets to avoid doubling the hash table size due to surpassing the threshold limits
            size = 0;
            for (int i = 0; i < numBuckets; i++){
                bucketArray.add(null); 
            }
        }

        private int getBucketIndex(K cunyID){ //finds the index from the bucket for a key
            int hCode = cunyID.hashCode(); //hCode shortened for hash code to not to be confused with .hashCode() from Java
            int index = hCode % numBuckets; 
            return index; //returns the index for a key
        } 

        public void add(K cunyID, N name){
            int bucketIndex = getBucketIndex(cunyID);
            HashIndex<K, N> head = bucketArray.get(bucketIndex);
            while(head != null){ //cannot use if statement here b/c need to check next head and so on for matching/present ID
                if(head.cunyID.equals(cunyID)){ //checks if ID is present in the hash
                    head.name = name;
                    return;
                }
                head = head.next;
            }
            size++; //increase size while adding
            HashIndex<K, N> newNode = new HashIndex<K, N>(cunyID, name); 
            newNode.next = head;
            bucketArray.set(bucketIndex, newNode); //adds both the key(cunyID) and the value(name) to the hash
        }

        public void remove(K cunyID){
            
        }

        public N get(K cunyID){ 
            int bucketIndex = getBucketIndex(cunyID); 
            HashIndex<K, N> head = bucketArray.get(bucketIndex);  
            while(head != null){ 
                if(head.cunyID.equals(cunyID)){
                    return head.name; //returns the name for a key
                } 
                head = head.next; 
            } 
            return null; // If key isn't not found return null value
        }


}
