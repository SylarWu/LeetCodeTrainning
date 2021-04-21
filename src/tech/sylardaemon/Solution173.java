package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution173 {
    class BSTIterator {
//
//        private LinkedList<TreeNode> keepTrack;
//
//        public BSTIterator(TreeNode root) {
//            TreeNode cur = root;
//            this.keepTrack = new LinkedList<>();
//            while (cur != null){
//                this.keepTrack.push(cur);
//                cur = cur.left;
//            }
//        }
//
//        public int next() {
//            TreeNode res = this.keepTrack.pop();
//            TreeNode cur = res.right;
//            while (cur != null){
//                this.keepTrack.push(cur);
//                cur = cur.left;
//            }
//            return res.val;
//        }
//
//        public boolean hasNext() {
//            return !this.keepTrack.isEmpty();
//        }

        private LinkedList<TreeNode> keepTrack;
        private Iterator<TreeNode> cur;

        public BSTIterator(TreeNode root) {
            this.keepTrack = new LinkedList<>();
            travel(root);
            this.cur = this.keepTrack.iterator();
        }

        private void travel(TreeNode t){
            if (t == null){
                return;
            }
            travel(t.left);
            this.keepTrack.add(t);
            travel(t.right);
        }

        public int next() {
            return this.cur.next().val;
        }

        public boolean hasNext() {
            return this.cur.hasNext();
        }
    }
}
