package crackingthecodinginterview6;

import java.util.ArrayList;
import java.util.LinkedList;
//FIX LATER
/**
 * A binary search tree was created by traversing through an array from 
 * left to right and inserting each element. Given a binary search tree 
 * with distinct elements, print all possible arrays that could have led 
 * to this tree. 
 * @author Michael Ning
 *
 */
public class BSTSequences {
    private static ArrayList<LinkedList<TreeNode>> res;
    public static void main(String[] args) {
        TreeNode t = new TreeNode(20);
        t.left = new TreeNode(10);
        t.right = new TreeNode(30);

        
        res = new LinkedList<TreeNode>();
        LinkedList<TreeNode> before = new LinkedList<TreeNode>();
        LinkedList<TreeNode> after =  new LinkedList<TreeNode>();
        
        findTraversals(before, after, t);
        for(LinkedList<TreeNode> list: res) {
            for(TreeNode t1 : list) {
                System.out.print(t1.val + " ");
            }
            System.out.println();
        }
    }
    
    public static ArrayList<LinkedList<TreeNode>> findSequences(TreeNode root) {
        
        return res;
    }
    
    public static void findTraversals(LinkedList<TreeNode> before, LinkedList<TreeNode> after, TreeNode root) {
        before.add(root);
        if(root.left != null) {
            after.add(root.left);
        }
        if(root.right != null) {
            after.add(root.right);
        }
        if(after.isEmpty()) {
            res.add(before);
        }
        for(TreeNode x: after) {
            LinkedList<TreeNode> btemp = (LinkedList<TreeNode>) before.clone();
            LinkedList<TreeNode> atemp = (LinkedList<TreeNode>) after.clone();
            after.remove(x);
            findTraversals(btemp, atemp, x);
        }
        
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
