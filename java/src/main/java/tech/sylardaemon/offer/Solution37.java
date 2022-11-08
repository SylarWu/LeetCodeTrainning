package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution37 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null){
                return "";
            }
            StringBuilder result = new StringBuilder();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                result.append(",");
                if (cur == null){
                    result.append("null");
                }else{
                    result.append(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            return result.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0){
                return null;
            }
            String[] str_nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(str_nodes[0]));
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int cur = 1;
            while (cur < str_nodes.length){
                TreeNode node = queue.poll();
                if ("null".equals(str_nodes[cur])){
                    node.left = null;
                }else{
                    node.left = new TreeNode(Integer.parseInt(str_nodes[cur]));
                    queue.offer(node.left);
                }
                if ("null".equals(str_nodes[cur + 1])){
                    node.right = null;
                }else{
                    node.right = new TreeNode(Integer.parseInt(str_nodes[cur + 1]));
                    queue.offer(node.right);
                }
                cur += 2;
            }
            return root;
        }
    }
}
