package com.rainrm.linkList;

public class ListPartition {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    // 给定一个值，把单向链表变成小于，等于，大于，这个值得原始顺序不变的单向链表
    public static Node listPartition(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sH.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eH.next = head;
                    eT = head;
                }
            }else {
                if (mH == null){
                    mH = head;
                    mT = head;
                }else {
                    mH.next = head;
                    mT = head;
                }
            }
            head = next;
        }

        //小的区域和等于的区域相连
        if (sT != null){
            sT.next = eH;
            eT = eT == null?sT:eT;
        }

        //如果小于区域和等于区域不是都没有
        if (eT != null){
            eT.next = mH;
        }
        return sH != null ? sH :(eH != null ? eH:mH);



    }
}
