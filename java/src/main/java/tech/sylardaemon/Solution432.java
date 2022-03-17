package tech.sylardaemon;

import java.util.HashMap;
import java.util.Map;

public class Solution432 {
    static class TwoWayListNode{
        String key;
        int value;
        TwoWayListNode pre;
        TwoWayListNode next;

        TwoWayListNode(String key, int value, TwoWayListNode pre, TwoWayListNode next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
        TwoWayListNode(String key, int value){
            this(key, value, null, null);
        }

        void stepUp(){
            TwoWayListNode prePreNode = this.pre.pre;
            TwoWayListNode preNode = this.pre;
            TwoWayListNode nextNode = this.next;
            prePreNode.next = this;
            this.pre = prePreNode;
            this.next = preNode;
            preNode.pre = this;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }

        void stepDown(){
            TwoWayListNode preNode = this.pre;
            TwoWayListNode nextNode = this.next;
            TwoWayListNode nextNextNode = this.next.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            nextNode.next = this;
            this.pre = nextNode;
            this.next = nextNextNode;
            nextNextNode.pre = this;
        }

    }


    class AllOne {
        private Map<String, TwoWayListNode> mapping;
        private TwoWayListNode head;
        private TwoWayListNode tail;

        public AllOne() {
            mapping = new HashMap<>();
            head = new TwoWayListNode(null, -1);
            tail = new TwoWayListNode(null, -1);
            head.next = tail;
            tail.pre = head;
        }

        public void inc(String key) {
            TwoWayListNode node;
            if (!mapping.containsKey(key)){
                node = new TwoWayListNode(key, 1, tail.pre, tail);
                tail.pre.next = node;
                tail.pre = node;
                mapping.put(key, node);
                return;
            }
            node = mapping.get(key);
            ++node.value;
            while (node != head.next && node.value > node.pre.value){
                node.stepUp();
            }
        }

        public void dec(String key) {
            TwoWayListNode node;
            if (!mapping.containsKey(key)){
                return;
            }
            node = mapping.get(key);
            --node.value;
            while (node != tail.pre && node.value < node.next.value){
                node.stepDown();
            }
            if (node.value == 0){
                tail.pre = node.pre;
                mapping.remove(key, node);
            }
        }

        public String getMaxKey() {
            if (head.next == tail){
                return "";
            }
            return head.next.key;
        }

        public String getMinKey() {
            if (head.next == tail){
                return "";
            }
            return tail.pre.key;
        }
    }
}
