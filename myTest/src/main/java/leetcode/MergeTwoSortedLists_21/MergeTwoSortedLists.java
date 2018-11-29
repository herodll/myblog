package leetcode.MergeTwoSortedLists_21;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

 public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          ListNode list1 = l1;
          ListNode list2 = l2;
          //先将0号节点作为结果集头结点
          ListNode newList = new ListNode(0);
          //用于移动添加结果集
          ListNode newp = newList;
          //当两个链表有一个不为空，就根据条件添加结果集
          while(list1 != null || list2 != null){
              //临时节点，用于复制即将要存储到结果集中的结点
              ListNode tmp = null;
              //需要先判断是不是当前有一个链表已经到尾部，不然如果已经到尾部，在取值时会出错，因此需要将判空条件放入取值判断之前
              if((list2!=null && list1 == null) || (list1 != null && list2 != null && list1.val > list2.val)){
                  tmp = new ListNode(list2.val);
                  tmp.next = null;
                  list2 = list2.next;
              }
              //一定要添加else关键字，否则当前几句代码执行后，可能会满足下面条件进入下面执行语句体内
              else if((list1 != null && list2 == null) || (list1 != null && list2 != null && list1.val <= list2.val)){
                  tmp = new ListNode(list1.val);
                  tmp.next = null;
                  list1 = list1.next;
              }
              newp.next = tmp;
              newp = newp.next;
          }
         return newList.next;
    }
}
