package leetcode.twoLinkSum;
/**
 * 问题描述：给定两个非空链表，如：输入为：4->3->2,6->7->8 那么输出就是：0->1->1->1
 * 因为：234+876=1110
 * 注意：
 *     不能用遍历将其转化为整数数字，相加再将结果放入结果集链表中的方式，
 *     因为，如果一旦转化为数字，可能会产生溢出。看清题目规则，实际上还是
 *     按照从前往后遍历的顺序去相加的，进位向后进，而不是倒序。
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
     }
}

public class TwoLinkSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> sRes = new ArrayList<>();//保存结果
        int tmps = 0;//用来保存进位
        //先从左到右遍历，将对应位置数字相加
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+tmps;
            l1 = l1.next;
            l2 = l2.next;
            sRes.add(sum%10);
            tmps = sum/10;
        }
        //如果l1中剩余，那么将l1中的数字和之前的进位做加法
        while(l1 != null){
            sRes.add((l1.val+tmps)%10);
            tmps = ((l1.val+tmps)/10);
            l1 = l1.next;
        }
        //如果l2剩余，那么将l2中的数字和之前的进位做加法
        while(l2 != null){
            sRes.add((l2.val+tmps)%10);
            tmps = ((l2.val+tmps)/10);
            l2 = l2.next;
        }
        //最后考虑，如果还剩进位不为0，那么还应将进位保存
        if(tmps == 1){
            sRes.add(tmps);
        }
        //遍历结果集，构造对应返回值类型的数据结构
        ListNode p = new ListNode(sRes.get(0));
        ListNode ps = p;
        for(int i=1;i<sRes.size();i++) {
            ListNode s = new ListNode(sRes.get(i));
            s.next = null;
            ps.next = s;
            ps = s;
        }
        return p;
    }
}
