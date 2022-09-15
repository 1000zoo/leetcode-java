//https://leetcode.com/problems/range-sum-of-bst/
//2022-09-15

package tree;

import java.util.*;

public class RangeSumOfBST {
    //Runtime: 36 ms, faster than 5.20% of Java online submissions for Range Sum of BST.
    //Memory Usage: 67.6 MB, less than 27.20% of Java online submissions for Range Sum of BST.
    public static int rangeSumBST(TreeNode root, int low, int high) {
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        int sum = 0;

        while (true) {
            sum = curr.val >= low && curr.val <= high ? sum + curr.val : sum;
            if (curr.left != null) {
                st.push(curr);
                curr = curr.left;
            } else if (curr.right != null) {
                curr = curr.right;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                while (!st.isEmpty() && st.peek().right == null) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    break;
                }
                curr = st.pop().right;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(){{
            add(10);
            add(5);
            add(15);
            add(3);
            add(7);
            add(13);
            add(18);
            add(1);
            add(null);
            add(6);
        }};
        TreeNode root = new TreeNode(list);
        rangeSumBST(root, 6, 10);

    }
}
