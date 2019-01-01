package crackingthecodinginterview6;


/**
 * Finds the first common ancestor between two nodes in a binary tree.
 * @author Michael Ning
 *
 */
public class FirstCommonAncestor {

    
    public static void main(String[] args) {
        TreeNode t = new TreeNode(20);
        t.left = new TreeNode(10);
        t.right = new TreeNode(30);
        t.left.left = new TreeNode(5);
        t.left.right = new TreeNode(15);
        t.right.left = new TreeNode(25);
        t.right.right = new TreeNode(35);
        t.left.left.left = new TreeNode(3);
        t.right.right.right = new TreeNode(100);
        
        System.out.println(findCommonAnc(t, t.left.right, t.left.left.left).val);
    }
    
    public static TreeNode findCommonAnc(TreeNode root, TreeNode t1, TreeNode t2) {
        if(root==null || root==t1 || root==t2) {
            return root;
        }
        TreeNode left = findCommonAnc(root.left, t1, t2);
        TreeNode right = findCommonAnc(root.right, t1, t2);
        if(left == null && right == null) {
            return null;
        }
        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        return right;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
            left = null;
            right = null;
        }
        
    }
}
