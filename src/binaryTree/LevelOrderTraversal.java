package binaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**

 #Time complexity#
 The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the
 tree. This is due to the fact that we traverse each node once.

 #Space Complexity

 The space complexity of the above algorithm will be O(N) as we need to return a list containing
 the level order traversal.
 We will also need O(N) space for the queue.
 Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
 therefore we will need O(N) space to store them in the queue.

 */
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
