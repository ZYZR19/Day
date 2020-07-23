package day04;

import java.awt.*;

public class day0401 {
    //排序链表中重复的结点不保留，返回链表头 指针。
    // 链表1->2->3->3->4->4->5 处理后为 1->2->5
    //重复的节点一定是在一起的重复区间是左开右闭
    //定义两个节点 不相等就往后走 相等就让pre不走last往后走
     //快慢指针问题 特殊情况为全相同 全不同 部分相同 为了方便定义头结点
   public class ListNode{
       int val;
       ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleDuplication(ListNode pHead) {
       if (pHead ==null) {
           return pHead;
       }
       ListNode head = new ListNode(0);
        head.next = pHead; //定义结点
        ListNode prev = head;
        ListNode last = prev.next;
        while (last!=null) {//永远在前面prev ,所以last会先走到null
            //先找到重复的开始
            while(last.next!=null&&last.val!=last.next.val) {//没走到最后一个并且目前没有重复
                prev = prev.next;
                last = last.next;
            }
            //找到重复的范围
            while(last.next!=null &&last.val==last.next.val) {//遇到重复的last走 prev停下
                last=last.next;
            }
            if (prev.next!=last) {
                prev.next = last.next;
            }
                last = last.next;
        }
        return head.next;
    }

}
