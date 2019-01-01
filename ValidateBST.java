package crackingthecodinginterview6;

import crackingthecodinginterview6.CheckTreeBalance.TreeNode;

public class ValidateBST {
    
    static Integer last = null;
    public static void main(String[] args) {
        TreeNode t = new TreeNode(20);
        t.left = new TreeNode(10);
        t.right = new TreeNode(30);
        t.left.left = new TreeNode(5);
        t.left.right = new TreeNode(15);
        t.left.right.left = new TreeNode(8);
        t.right.left = new TreeNode(25);
        t.right.right = new TreeNode(35);
        t.left.left.left = new TreeNode(3);
        t.right.right.right = new TreeNode(100);
        
        boolean ans = checkBST(t);
        if(ans) {
            System.out.println("The tree is a BST!");
        }
        else {
            System.out.println("The tree is NOT a BST.");
        }
    }
    
    public static boolean checkBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!checkBST(root.left)) {
            return false;
        }
        if(last != null && last >= root.val) {
            return false;
        }
        last = root.val;
        if(!checkBST(root.right)) {
            return false;
        }
        
        return true;
        
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
