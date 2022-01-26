package binaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        // Beginning with the root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            //Get current level size
            int  size = queue.size();
            List<Integer> listOfCurrentLevel = new ArrayList<>();

            //iterate through all nodes remaining in the queue
            for (int i=0;i<size;i++) {
                TreeNode currentNode = queue.remove();
                listOfCurrentLevel.add(currentNode.val);
                if (currentNode.left!=null) {
                    queue.add(currentNode.left);

                }
                if (currentNode.right!= null){
                    queue.add(currentNode.right);
                }


            }

            output.add(listOfCurrentLevel);



        }

        return output;








    }
}
