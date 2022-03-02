package tech.sylardaemon;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    class LRUCache {
        class TwoWayListNode{
            int key;
            int value;
            TwoWayListNode pre;
            TwoWayListNode next;
            TwoWayListNode(int _key, int _value, TwoWayListNode _pre, TwoWayListNode _next){
                this.key = _key;
                this.value = _value;
                this.pre = _pre;
                this.next = _next;
            }

            TwoWayListNode(int _key, int _value){
                this(_key, _value, null, null);
            }
        }

        private void moveToHead(TwoWayListNode head, TwoWayListNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;

            headInsert(head, node);
        }

        private void headInsert(TwoWayListNode head, TwoWayListNode node){
            node.pre = head;
            node.next = head.next;
            node.pre.next = node;
            node.next.pre = node;
        }

        private TwoWayListNode removeTail(TwoWayListNode tail){
            TwoWayListNode readyToRemove = tail.pre;
            readyToRemove.pre.next = readyToRemove.next;
            readyToRemove.next.pre = readyToRemove.pre;
            return readyToRemove;
        }

        private int size;
        private int capacity;
        private Map<Integer, TwoWayListNode> mapping;
        private TwoWayListNode dummyHead;
        private TwoWayListNode dummyTail;

        public LRUCache(int capacity) {
            size = 0;
            this.capacity = capacity;
            dummyHead = new TwoWayListNode(0, 0);
            dummyTail = new TwoWayListNode(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            mapping = new HashMap<>();
        }

        public int get(int key) {
            if (this.mapping.containsKey(key)){
                TwoWayListNode x = this.mapping.get(key);
                moveToHead(this.dummyHead, x);
                return x.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (this.mapping.containsKey(key)){
                TwoWayListNode x = this.mapping.get(key);
                x.value = value;
                moveToHead(this.dummyHead, x);
            }else {
                TwoWayListNode x = new TwoWayListNode(key, value);
                headInsert(this.dummyHead, x);
                this.mapping.put(key, x);
                if (this.size >= this.capacity){
                    TwoWayListNode readyToRemove = removeTail(this.dummyTail);
                    this.mapping.remove(readyToRemove.key, readyToRemove);
                }else{
                    ++this.size;
                }
            }
        }
    }
}
