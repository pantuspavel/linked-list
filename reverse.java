import java.io.*;
import java.util.*;

// Example:  k = 3
// Input:  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
// Output: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7

class Node {
  int val;
  Node next;
  
  Node(int val) {
    this.val = val;
  }
}

class Solution {
  public static Node reverse(Node h, int k) {
    Node cur = h;
    Node prev = null;
    int count = 0;
    
    while(cur != null && count++ < k) {
      Node tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    
    if (cur != null && cur.next != null) {
      h.next = reverse(cur.next, k);
    }
    
    return prev;
  }
  
  public static void print(Node h) {
    while(h != null) {
      System.out.print(h.val + " ");
      h = h.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;
    
    n1 = reverse(n1, 5);
    print(n1);
  }
}
