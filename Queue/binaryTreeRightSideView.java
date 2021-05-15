package Queue;

import java.util.ArrayList;
import java.util.List;

public class binaryTreeRightSideView {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideViewList(root, ans, 0);
        return ans;
    }

    private static void rightSideViewList(TreeNode root, List<Integer> ans, int currDepth) {
        if (root == null)
            return;
        if (currDepth == ans.size())
            ans.add(root.val);
        rightSideViewList(root.right, ans, currDepth + 1);
        rightSideViewList(root.left, ans, currDepth + 1);
    }

    private static void leftSideViewList(TreeNode root, List<Integer> ans, int currDepth) {
        if (root == null)
            return;
        if (currDepth == ans.size())
            ans.add(root.val);
        leftSideViewList(root.right, ans, currDepth + 1);
        leftSideViewList(root.left, ans, currDepth + 1);
    }
}
