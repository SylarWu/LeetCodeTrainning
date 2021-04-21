package tech.sylardaemon;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution705 {
    class MyHashSet {

        LinkedList<Integer>[] data;
        int max_len;


        /** Initialize your data structure here. */
        public MyHashSet() {
            this.max_len = 1000;
            this.data = new LinkedList[this.max_len];
            for (int i = 0; i < this.max_len ; ++i){
                this.data[i] = new LinkedList<>();
            }
        }

        public void add(int key) {
            if (this.contains(key)){
                return;
            }
            this.data[key % this.max_len].addFirst(key);
        }

        public void remove(int key) {
            Iterator<Integer> it = this.data[key % this.max_len].iterator();
            while (it.hasNext()){
                Integer x = it.next();
                if (x == key){
                    this.data[key % this.max_len].remove(x);
                    return;
                }

            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            for (Integer x : this.data[key % this.max_len]){
                if (x.equals(key)){
                    return true;
                }
            }
            return false;
        }
    }
}
