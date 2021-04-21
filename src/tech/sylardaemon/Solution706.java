package tech.sylardaemon;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution706 {
    class MyHashMap {
        class Pair{
            private int key;
            private int value;

            public Pair(int key, int value){
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
        private LinkedList<Pair>[] data;
        private int max_len;


        /** Initialize your data structure here. */
        public MyHashMap() {
            this.max_len = 1000;
            this.data = new LinkedList[this.max_len];
            for (int i = 0; i < this.max_len; ++i){
                this.data[i] = new LinkedList();
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key % this.max_len;
            for (Pair p : this.data[index]) {
                if (p.getKey() == key) {
                    p.setValue(value);
                    return;
                }
            }
            this.data[index].addFirst(new Pair(key,value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = key % this.max_len;
            for (Pair p : this.data[index]) {
                if (p.getKey() == key) {
                    return p.getValue();
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = key % this.max_len;
            Iterator<Pair> it = this.data[index].iterator();
            while(it.hasNext()){
                Pair p = it.next();
                if (p.getKey() == key){
                    this.data[index].remove(p);
                    return;
                }
            }
        }
    }
}
