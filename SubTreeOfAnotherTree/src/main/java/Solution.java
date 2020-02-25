public class Solution {
    /**
     * First step write an algorithm to see if two trees are euqal or not
     * <p>
     * then we iterate through all the nodes of S, since each node in S represents the root of a different subtree
     * <p>
     * then we check of T is equal to the selected node in S
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean equals(TreeNode s, TreeNode t){
        if(s==null && t==null)
            return true;
        if(s == null || t == null)
            return false;
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        return recur(s, t);
    }

    public boolean recur(TreeNode s, TreeNode t){
        return s != null && (equals(s, t) || recur(s.left, t) || recur(s.right, t));
    }

}