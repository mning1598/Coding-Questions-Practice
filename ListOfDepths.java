package crackingthecodinginterview6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Creates a linked list of all nodes at each depth given a binary tree.
 * @author Michael Ning
 *
 */
public class ListOfDepths {

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
        ArrayList<LinkedList<TreeNode>> a = null;
        a = createDepthList(t);
        printResult(a);

    }
    
    public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for(LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((TreeNode)i.next()).val);
            }
            System.out.println();
            depth++;
        }
    }
    public static ArrayList<LinkedList<TreeNode>> createDepthList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
        findLists(res, 0, root);
        return res;
    }
    
    public static void findLists(ArrayList<LinkedList<TreeNode>> res, int depth, TreeNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> level = null;
        if(res.size() == depth) {
            level = new LinkedList<TreeNode>();
            res.add(level);
        }
        else {
            level = res.get(depth);
        }
        level.add(root);
        
        findLists(res, depth+1, root.left);
        findLists(res, depth+1, root.right);
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



