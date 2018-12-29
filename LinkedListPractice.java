package crackingthecodinginterview6;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class LinkedListPractice {
        
    static class Node {
        Node next;
        int data;

        Node(){
            
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(Node next) {
            this.next = next;
        }
    }
    
    public static void main(String[] args) {

        Node nh = new Node(0);
        Node n1 = new Node(2);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        Node n4 = new Node(6);
        Node n5 = new Node(5);
        Node n6 = new Node(4);
        
        nh.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        
        Node n11 = new Node(7);
        Node n12 = new Node(1);
        Node n13 = new Node(6);
        Node n14 = new Node(4);
        Node n15 = new Node(3);
        Node n16 = new Node(8);
        
//        Node n21 = new Node(5);
        Node n22 = new Node(9);
        Node n23 = new Node(2);
        Node n24 = new Node(4);
        Node n25 = new Node(3);
        Node n26 = new Node(8);
        
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;
//        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;
        n25.next = n26;
        
        n11 = intersect(n11, n22);
        while(n11 != null) {
            System.out.println(n11.data);
            n11 = n11.next;
        }
        //nh = removeDupes(nh);
        //nh = kthLast(nh, 3);
        //delMidNode(nh);
        //System.out.print(nh.data);
//        while(nh != null) {
//            System.out.println(nh.data);
//            nh = nh.next;
//        }

        
    }
    /**
     * removes duplicates from a linkedlist
     * @param head
     * @return head of the linkedList
     */
    public static Node removeDupes(Node head) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        Node previous = null;
        Node curr = head;
        while(curr != null) {
            h.put(curr.data, h.getOrDefault(curr.data, 0)+1);
            if(h.get(curr.data) != 1) {
                previous.next = curr.next;
            }
            previous = curr;
            curr = curr.next;
        }
        
        return head;
    }
            
    /**
     * returns the Node that is kth from the last node in the linkedlist
     * @param head
     * @param k
     * @return kth last node
     */
    public static Node kthLast(Node head, int k) {
        
        int len = 0;
        Node curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        for(int i = 0; i < len-k; i++) {
            head = head.next;
        }
        return head;
    }
    
    /**
     * Deletes the middle node in a linkedlist.
     * @param head
     */
    public static void delMidNode(Node head) {
        int len = 0;
        Node curr = head;
        while(curr != null) {
            len++;
            curr=curr.next;
        }
        curr = head;
        Node previous = null;
        for(int i =0; i< len/2; i++) {
            previous = curr;
            curr = curr.next;
        }
        previous.next = curr.next;
    }
    
    /**
     * Sums the digits of a LinkedList and returns a new Linked List with the sums.
     * @param h1
     * @param h2
     * @param carry
     * @return
     */
    public static Node sumLists(Node h1, Node h2, int carry) {
        if(h1 == null && h2 == null && carry == 0) {
            return null;
        }
        int num = carry;
        Node res = new Node();
        if(h1 != null) {
            num += h1.data;
        }
        if(h2 != null) {
            num += h2.data;
        }
        if(num >= 10) {
            carry = 1;
            num -= 10;
        }
        else {
            carry =0;
        }
        res.data = num;

        Node recurse = sumLists(h1.next, h2.next, carry);
        res.next = recurse;
        return res;
    }
    
    public static Node intersect(Node n1, Node n2) {
        if(n1 == null || n2 == null) {
            return null;
        }
        Node head1 = n1;
        Node head2 = n2;
        int len1 = 0;
        int len2 = 0;
        Node tail1 = new Node();
        Node tail2 = new Node();
        while(head1 != null) {
            len1++;
            tail1 = head1;
            head1 = head1.next;
        }
        while(head2 != null) {
            len2++;
            tail2 = head2;
            head2 = head2.next;
        }
        if(tail1.data != tail2.data) {
            return null;
        }
        while(len1 > len2) {
            n1 = n1.next;
            len1--;
        }
        while(len2 > len1) {
            n2 = n2.next;
            len2--;
            
        }
        while(n1 != n2) {   
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
        
    }
    
}
