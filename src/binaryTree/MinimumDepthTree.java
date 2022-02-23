package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthTree {

           public static int findDepth(TreeNode root) {
            // TODO: Write your code cbcbcbcbc

            Queue<TreeNode> queue = new LinkedList<>();
            int levels = 0;
            int minValue = Integer.MAX_VALUE;

            if (root == null) return levels;
            queue.add(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                levels++;

                TreeNode current = queue.remove();

                for (int i=0; i<size; i++) {
                    if (current.left == null && current.right == null) {

                       return levels;

                    }



                    if (current.left != null) queue.add(current.left);
                    if (current.right != null) queue.add(current.right);
                }


            }

            return -1;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            System.out.println("Tree Minimum Depth: " + MinimumDepthTree.findDepth(root));
            root.left.left = new TreeNode(9);
            root.right.left.left = new TreeNode(11);
            System.out.println("Tree Minimum Depth: " + MinimumDepthTree.findDepth(root));
        }


}
