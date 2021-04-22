package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> keepTrack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null){
            keepTrack.push(cur);
            cur = cur.left;
        }
        while (!keepTrack.isEmpty()){
            cur = keepTrack.pop();
            res.add(cur.val);
            cur = cur.right;
            while (cur != null){
                keepTrack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}
