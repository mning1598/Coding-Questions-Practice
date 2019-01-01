package crackingthecodinginterview6;

import crackingthecodinginterview6.FirstCommonAncestor.TreeNode;

/**
 * Tl and T2 are two very large binary trees, with Tl much bigger than 
 * T2. Create an algorithm to determine if T2 is a subtree of Tl.
 * @author Michael Ning
 *
 */
public class CheckSubtree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(20);
        t1.left = new TreeNode(10);
        t1.right = new TreeNode(30);
        t1.left.left = new TreeNode(5);
        t1.left.right = new TreeNode(15);
        t1.right.left = new TreeNode(25);
        t1.right.right = new TreeNode(35);
        t1.left.left.left = new TreeNode(3);
        t1.right.right.right = new TreeNode(100);
        
        TreeNode t2 = new TreeNode(10);
        t2.left = new TreeNode(5);
        t2.right = new TreeNode(15);
        t2.left.left = new TreeNode(3);
        //t2.right.right = new TreeNode(16);

        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        inOrderToString(t1, sb1);
        inOrderToString(t2, sb2);
        
        boolean ans = containsTree(sb1, sb2);
        if(ans) {
            System.out.print("Tree 2 is a subtree of Tree 1!");
        }
        else {
            System.out.print("Tree 2 is NOT a subtree of Tree 1!");
        }
    }
    
    public static boolean containsTree(StringBuilder sb1, StringBuilder sb2) {
        
        if(sb1.indexOf(sb2.toString()) == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public static void inOrderToString(TreeNode t, StringBuilder sb) {
        if(t == null) {
            sb.append("X ");
            return;
        }
        sb.append(t.val + " ");
        inOrderToString(t.left, sb);
        inOrderToString(t.right, sb);
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
