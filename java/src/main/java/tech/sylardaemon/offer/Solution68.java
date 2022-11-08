package tech.sylardaemon.offer;

import java.util.LinkedList;
import java.util.List;

public class Solution68 {
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null){
            if (node.val < p.val && node.val < q.val){
                node = node.right;
            }else if (node.val > p.val && node.val > q.val){
                node = node.left;
            }else{
                break;
            }
        }
        return node;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        return recursive_method(root, p, q);
    }

    private TreeNode recursive_method(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q){
            // 当前node为null结束这层递归
            // 如果找到了任一p或者q则返回当前节点，即p或q，且非null
            return node;
        }

        TreeNode left = recursive_method(node.left, p, q);
        TreeNode right = recursive_method(node.right, p, q);
        if (left == null){
            // 左边没找到返回右边
            // 右边没找到返回null，则这个子树p或q都没有，那么祖先肯定不是这个节点也就是返回null
            // 如果右边找到了有可能是p或q，也有可能是p和q的最小祖先，那么最终返回到最后一层
            return right;
        }
        if (right == null){
            // 同理
            return left;
        }
        // 如果左右都不是null那么可以肯定这个节点就是最小公共祖先
        // 因为如果再递归回上一层，只有有left或者right其中一个不为null，所以这个节点肯定是最小公共祖先
        return node;
    }

    private TreeNode path_method(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
        LinkedList<TreeNode> path_1 = new LinkedList<>();
        LinkedList<TreeNode> path_2 = new LinkedList<>();
        recursive_find_path(root, p, path_1);
        recursive_find_path(root, q, path_2);
        int i = 0;
        while (i < path_1.size() && i < path_2.size() && path_1.get(i) == path_2.get(i)){
            ++i;
        }
        return path_1.get(i - 1);
    }

    private boolean recursive_find_path(TreeNode node, TreeNode target, LinkedList<TreeNode> path){
        if (node == null){
            return false;
        }
        if (node == target){
            path.addFirst(node);
            return true;
        }
        boolean left = recursive_find_path(node.left, target, path);
        boolean right = recursive_find_path(node.right, target, path);
        if (left || right){
            path.addFirst(node);
            return true;
        }
        return false;
    }


}
