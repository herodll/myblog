package leetcode.MergeTwoSortedLists_21;

public class MergeTwoSortedListTest {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        /*ListNode tmp1 = new ListNode(3);
        list1.next = tmp1;
        ListNode tmp2 = new ListNode(5);
        tmp1.next = tmp2;
        tmp2.next = null;*/

        ListNode list2 = new ListNode(1);
        ListNode tmp3 = new ListNode(4);
        list2.next = tmp3;
        ListNode tmp4 = new ListNode(6);
        tmp3.next = tmp4;
        tmp4.next = null;

       /* System.out.println(list1.val);
        System.out.println(list2.val);*/

        ListNode ret = new MergeTwoSortedLists().mergeTwoLists(list1,null);

        while(ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }


    }



}
