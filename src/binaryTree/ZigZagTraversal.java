package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 @link
 https://www.educative.io/courses/grokking-the-coding-interview/qVA27MMYYn0
* */

public class ZigZagTraversal {


    public List<List<Integer>> zigzagTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean b = true; //left to right
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for (int i=0; i< size; i++) {
                TreeNode current = queue.poll();
                if (b) {
                    currentLevel.add(current.val);
                } else {
                    currentLevel.add(0, current.val);
                }

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);



            }

            b = !b;

            result.add(currentLevel);


        }





        return result;

    }
}
