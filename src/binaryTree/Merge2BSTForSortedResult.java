package binaryTree;

//1305. All Elements in Two Binary Search Trees - Leet Code

// Learning OutCome:
// Inorder Traversal on Binary Search Tree results in ascending order


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Merge2BSTForSortedResult {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> root1Sorted = new ArrayList<Integer>();
        inOrderTraversal(root1, root1Sorted);
        List<Integer> root2Sorted = new ArrayList<Integer>();
        List<Integer> finalOrder = new ArrayList<Integer>();
        inOrderTraversal(root2, root2Sorted);

        int list1Size = root1Sorted.size();
        int list2Size = root2Sorted.size();

        int list1Pointer=0, list2Pointer = 0;

        while ((list1Pointer < list1Size) || (list2Pointer < list2Size)) {

            if (list1Pointer == list1Size) {
                finalOrder.add(root2Sorted.get(list2Pointer));
                list2Pointer++;
            } else if (list2Pointer == list2Size) {
                finalOrder.add(root1Sorted.get(list1Pointer));
                list1Pointer++;
            } else {

                int list1Element = root1Sorted.get(list1Pointer);
                int list2Element = root2Sorted.get(list2Pointer);

                if (list1Element < list2Element) {
                    finalOrder.add(list1Element);
                    list1Pointer++;
                } else if (list2Element < list1Element) {
                    finalOrder.add(list2Element);
                    list2Pointer++;
                } else if (list1Element == list2Element) {
                    finalOrder.add(list1Element);
                    finalOrder.add(list2Element);
                    list1Pointer++;
                    list2Pointer++;
                }


            }



        }
        return finalOrder;
    }

    public void inOrderTraversal(TreeNode  root, List<Integer> output) {
        if (root!= null) {
            if (root.left != null)inOrderTraversal(root.left, output);
            output.add(root.val);
            if (root.right!= null)inOrderTraversal(root.right, output);
        }

    }



}
