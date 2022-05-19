package com.rainrm.linkList;

import java.util.Stack;

public class Is_palindromeList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }


    //需要n个额外的空间
    public static boolean isPalindrome1(Node head){
        // 创建一个栈
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur.next != null){
            stack.push(cur.next);
            cur = cur.next;
        }

        while (head != null) {
            Node pop = stack.pop();
            if (head.value != pop.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }



    //需要n/2个额外空间,快慢指针
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node right = head.next;
        Node cur = head;
        //cur是快指针，对cur进行判断
        if (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }

        // 把right指针及以后的节点压入队列
        Stack<Node> stack = new Stack<Node>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }

        //把栈中的node节点弹出来和head的节点进行对比
        //结束条件就是栈中没有节点了
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            if (head.value != pop.value){
                return false;
            }
            head = head.next;
        };
        return true;
    }


    //需要O（1）的额外空间
    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        //寻找中间节点
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        //中间节点逆序
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        //两边从头对比是否相等
        while (n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        //右边节点把逆序改成顺序
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }


    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        Node c = new Node(1);
        b.next = c;
//        Node d = new Node(2);
//        c.next = d;
//        Node e = new Node(1);
//        d.next = e;
        boolean palindrome3 = isPalindrome3(a);
        System.out.println(palindrome3);


    }
}
