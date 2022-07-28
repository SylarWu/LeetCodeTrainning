package tech.sylardaemon.offer;

import java.util.LinkedList;
import java.util.List;

public class Solution32 {
    public int[] levelOrder_1(TreeNode root){
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null){
                result.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return listToArray(result);
    }

    private int[] listToArray(List<Integer> list){
        int[] result = new int[list.size()];
        int i = 0;
        for (int x : list){
            result[i++] = x;
        }
        return result;
    }
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            List<Integer> thisLevel = new LinkedList<>();
            for (int i = queue.size(); i > 0; --i){
                TreeNode cur = queue.poll();
                thisLevel.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            result.add(thisLevel);
        }
        return result;
    }

    public List<List<Integer>> levelOrder_3(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        int level_num = 1;
        while (!queue.isEmpty()){
            LinkedList<Integer> thisLevel = new LinkedList<>();
            for (int i = queue.size(); i > 0; --i){
                TreeNode cur = queue.poll();
                if (level_num % 2 == 0){
                    thisLevel.addFirst(cur.val);
                }else{
                    thisLevel.addLast(cur.val);
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            result.add(thisLevel);
            ++level_num;
        }
        return result;
    }
}
