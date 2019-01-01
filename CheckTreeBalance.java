package crackingthecodinginterview6;

/**
 * Checks whether a tree is balanced or not. The height of subtrees can not be greater than 1.
 * @author Michael Ning
 *
 */
public class CheckTreeBalance {

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
        
        boolean ans = checkBalance(t);
        if(ans) {
            System.out.println("The tree is balanced!");
        }
        else {
            System.out.println("The tree is NOT balanced.");
        }
    }
    
    public static boolean checkBalance(TreeNode root) {
        if(root == null) {
            return true;
        }
        int diff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(diff) <= 1) {
            return checkBalance(root.left) && checkBalance(root.right);
        }
        return false;
        
    }
    
    public static int getHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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


