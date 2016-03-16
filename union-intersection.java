import java.io.*;
import java.util.*;

class Node {
  int val;
  Node next;
  
  Node(int val) {
    this.val = val;
  }
}

class Solution {
  public static Node intersection(Node h1, Node h2) {
    if (h1 == null || h2 == null) {
      return null;
    }
    
    TreeSet<Integer> t1 = new TreeSet<Integer>();
    TreeSet<Integer> t2 = new TreeSet<Integer>();
    
    Node c = h1;
    while(c != null) {
      t1.add(c.val);
      c = c.next;
    }
    
    c = h2;
    while(c != null) {
      t2.add(c.val);
      c = c.next;
    }
    
    Node nh = null;
    Node nf = null;
    for (Integer v : t1) {
      if (t2.contains(v)) {
        Node n = new Node(v);
        if (nh != null) {
          nh.next = n;
        }
        nh = n;
        
        if (nf == null) {
          nf = nh;
        }
      }
    }
    
    return nf;
  }
  
  public static Node union(Node h1, Node h2) {
    if (h1 == null) {
      return h2;
    }
    if (h2 == null) {
      return h1;
    }
    
    TreeSet<Integer> t = new TreeSet<Integer>();
    
    Node c = h1;
    while(c != null) {
      t.add(c.val);
      c = c.next;
    }
    
    c = h2;
    while(c != null) {
      t.add(c.val);
      c = c.next;
    }
    
    Node f = null;
    Node n = null;
    for (Integer v : t) {
      c = new Node(v);
      if (n != null) {
        n.next = c;
      }
      n = c;
      
      if (f == null) {
        f = c;
      }
    }
    return f;
  }
 
  public static void print(Node h) {
    while(h != null) {
      System.out.print(h.val + " ");
      h = h.next;
    }
    System.out.println();
  }
 
  // List1: 10-> 15 -> 4 -> 20
  // lsit2:  8->  4 -> 2 -> 10 -> 15 -> 15
  
  public static void main(String[] args) {
    Node n1_10 = new Node(10);
    Node n1_15 = new Node(15);
    Node n1_4 = new Node(4);
    Node n1_20 = new Node(20);
    
    Node n2_8 = new Node(8);
    Node n2_4 = new Node(4);
    Node n2_2 = new Node(2);
    Node n2_10 = new Node(10);
    Node n2_15_1 = new Node(15);
    Node n2_15_2 = new Node(15);

    n1_10.next = n1_15;
    n1_15.next = n1_4;
    n1_4.next = n1_20;

    n2_8.next = n2_4;
    n2_4.next = n2_2;
    n2_2.next = n2_10;
    n2_10.next = n2_15_1;
    n2_15_1.next = n2_15_2;
    
    // Node u = intersection(n1_10, n2_8);
    // System.out.print("Intersection: ");
    // print(u);
    
    Node u = union(n1_10, n2_8);
    System.out.print("Union: ");
    print(u);
  }
}
