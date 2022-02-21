package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 @link
 https://www.educative.io/courses/grokking-the-coding-interview/m2N6GwARL8r
 * */
public class ReverseLevelOrderTraversal {


    public List<List<Integer>> reverseLevelOrderTraversal(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                currentLevel.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);


            }
            output.add(0, currentLevel);


        }

        return output;

    }

}
