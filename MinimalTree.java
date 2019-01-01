package crackingthecodinginterview6;

import crackingthecodinginterview6.ListOfDepths.TreeNode;

/**
 * Creates a binary search tree given a sorted array of ints.
 * @author Michael Ning
 *
 */
public class MinimalTree {
    
    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        int[] nums = {1,2,3,4,5,6,7};
        
        t = convert(nums, 0, nums.length -1);
        System.out.println(t.val);
        printPostorder(t);
        System.out.println();
        printInorder(t);
        System.out.println();
        printPreorder(t);

    }
    
    public static TreeNode convert(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start+end)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = convert(nums,start,mid-1);
        t.right = convert(nums,mid+1, end);
        
        return t;
    }
    

    
    static void printPostorder(TreeNode node) { 
        if (node == null) 
            return; 
        printPostorder(node.left); 
        printPostorder(node.right); 
        System.out.print(node.val + " "); 
    } 
  
    static void printInorder(TreeNode node) { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.val + " "); 
        printInorder(node.right); 
    } 
  
    static void printPreorder(TreeNode node) 
    { 
        if (node == null) 
            return; 
        System.out.print(node.val + " "); 
        printPreorder(node.left); 
        printPreorder(node.right); 
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


