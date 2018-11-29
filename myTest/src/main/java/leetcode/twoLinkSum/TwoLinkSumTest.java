package leetcode.twoLinkSum;

public class TwoLinkSumTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
       // l1.next = null;
        ListNode p1 = new ListNode(4);
        l1.next = p1;
        ListNode p2 = new ListNode(3);
        p1.next = p2;
        p2.next = null;
        ListNode l2 = new ListNode(5);
        //l2.next = null;
        ListNode q1 = new ListNode(6);
        l2.next = q1;
        ListNode q2 = new ListNode(4);
        q1.next = q2;
        q2.next = null;

        ListNode res = new TwoLinkSum().addTwoNumbers(l1,l2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
