package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {


        public List<Integer> inorder(TreeNode root) {
            List<Integer> output = new ArrayList<>();
            inorder(root, output);
            return output;
        }
        public void inorder(TreeNode root, List<Integer> list) {
            if (root!=null) {
                if(root.left != null) inorder(root.left, list);
                list.add(root.val);
                if(root.right != null) inorder(root.right, list);
            }

        }

}
