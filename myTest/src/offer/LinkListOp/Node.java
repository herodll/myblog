package offer.array.LinkListOp;

import java.util.Stack;

/**
 * Created by Administrator on 2018/5/3.
 */
 public class Node {
    int value;
    Node next;

    Node(){}
    Node(int value){
        this.value = value;
        this.next = null;
    }

}
class LinkedList {
    Node node;

    LinkedList() {
        this.node = new Node();

    }

    Node create() {
        return new Node();
    }

    Node create(int value) {
        return new Node(value);
    }

    void addToTail(int value) {
        if (this != null) {
            Node newNode = this.create(value);
            Node ptr = this.node;
            if (ptr != null) {
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = newNode;
            } else {
                ptr = newNode;
            }
        }
    }

    void addToHead(int value) {
        if (this != null) {
            Node newNode = this.create(value);
            if (this.node != null && this.node.next != null) {
                newNode.next = this.node.next;
                this.node.next = newNode;
            } else {
                if (this.node.next == null) {
                    this.node.next = newNode;
                }
            }
        }
    }

    int getSize() {
        int size = -1;
        if (this != null) {
            Node p = this.node;

            while (p != null) {
                size++;
                p = p.next;
            }

            // return size;
        }
        return size;
    }

    int getValueByOrderK(int k) {
        //序号从1开始
        if (this != null && this.node != null && k <= getSize()) {
            Node p = this.node;
            while (k > 0 && p != null) {
                p = p.next;
                k--;
            }
            return p.value;
        }
        return -1;
    }

    void showInorder() {
        if (this != null && this.node != null) {
            Node p = this.node.next;
            while (p != null) {
                System.out.print(p.value + " ");
                p = p.next;
            }
        }
    }


    int findFirstDataAndRemove(int value) {
        if (this == null || this.node == null) {
            return -1;
        }
        int index = 0;
        Node ptr = this.node;
        Node cur = ptr.next;
        while (cur != null) {
            if (cur.value != value) {
                ptr = cur;
                cur = cur.next;
                index++;
            } else {
                ptr.next = cur.next;
                cur.value = 0;
                cur = null;
                return index;
            }
        }
        return -1;
    }

    //从后向前打印链表，如果要求不能改变链表的话，我们可以采用栈来完成从后往前的打印；在Java中有栈这个结构，
    // 是已经有的，可以直接调用的
    void showFromTailToHeadByStack() {
        if (this == null || this.node == null) {
            return;
        }
        Stack<Integer> sta = new Stack<>();
        Node p = this.node;
        while (p.next != null) {
            p = p.next;
            //System.out.println(Integer.valueOf(p.value));
            sta.push(Integer.valueOf(p.value));
        }
        // sta.push(Integer.valueOf(p.value));
        while (!sta.isEmpty()) {
            int i = sta.pop();
            //打印时，所有原样输出的字符串用双引号
            System.out.print(i + " ");
        }

    }

    //既然可以用栈，自然也可以用递归
    void showFromTailToHead(Node node) {
        if (node == null) {
            return;
        }
        /*
         令该对象指向下一个节点,对于递归，我们可以传入一个参数为Node类型，以保证递归的进行
          */
        showFromTailToHead(node.next);
        System.out.println(node.value);

    }

    //剑指offer面试题18：删除链表中的结点:给一个单链表和一个节点指针，删除这个指针所指的节点
    //方法1：常规思路，从头开始遍历，找到该节点的前一个节点，再删除,此方法需要O（n）的时间复杂度
    void deleteNode(Node ptr) {
        Node p = this.node;
        if (this != null && this.node != null && ptr != null) {
            while (p.next != ptr) {
                p = p.next;
            }
            //删除ptr节点
            p.next = ptr.next;
            ptr.value = 0;
            ptr.next = null;
        }
    }

    //方法2：其实我们并不需要一定要知道ptr节点的前一个节点，只需要将其后一个节点的值赋值给ptr,
    // 之后删除ptr的下一个节点就可以了，时间复杂度为O(1)
    void deleteNode_Less(Node ptr) {
        if (this != null && this.node != null && ptr != null) {
            if (ptr.next != null) {
                ptr.value = ptr.next.value;
                ptr.next.value = 0;
                ptr.next = ptr.next.next;
            }
            //如果ptr是最后一个节点
            else {
                deleteNode(ptr);
            }
        }
    }

    /*
        链表中的倒数第k个节点：假设从1开始编号

     */
    //方法1：先得到链表长度n，那么倒数第k个，也就是正数第n-k+1个
    int getValueByReverseK(int k) {
        if (this != null && this.node != null) {
            int size = getSize();
            if (k <= size) {
                return getValueByOrderK(size - k + 1);
            }
        }
        return -1;
    }

    //方法2：可以采用快慢指针，先让快指针走k-1步，而慢指针在起点，这样从第k步开始，两个指针一起走，
    // 每次走一步，当快指针走到结尾时，慢指针就指向倒数第k个，因为快慢指针之间相差k-1步
    int getValueByReverseK2(int k) {
        if (this != null && this.node != null) {
            Node quik = this.node;
            Node slow = this.node;
            int count = 0;
            while (quik.next != null) {
                if (count != k - 1) {
                    count++;
                } else {
                    slow = slow.next;
                }
                quik = quik.next;
            }
            return slow.value;
        }
        return -1;
    }

    /*
       剑指offer 24题：反转链表
     */
    //方法1：自己的思路：可以先遍历一遍链表，依次将节点头插，每头插一个节点之后，再将原来的链表第一个节点之后，也就是与刚插入
    // 的节点值相同的节点删除
    void reverseLink() {
        if (this != null && this.node != null && this.node.next != null) {
            Node p = this.node.next.next;
            Node q = this.node.next;
            while (p != null) {
                //头插法
                Node newNode = create(p.value);
                newNode.next = this.node.next;
                this.node.next = newNode;
                //删除节点p
                q.next = p.next;
                p.value = 0;
                p.next = null;
                p = q.next;
            }
        }
    }

    //利用栈，遍历一遍原链表，将原链表结点压栈，之后弹出栈顶元素，令栈顶元素的next指向已经弹出当前的栈顶节点，
    // 再弹，再赋值，直到栈空
    /*void reserveLinkByStack(){
        if(this!=null && this.node !=null){
            Stack<Node> stack = new Stack();
            Node p = this.node.next;
            while(p!=null){
                stack.push(p);
                p = p.next;
            }
            //p = stack.pop();
            this.node.next = stack.peek();
            while(!stack.isEmpty()) {
                p = stack.pop();
                p.next = stack.peek();
            }
        }
    }*/


     /*方法2：
       从前往后遍历，将第二个节点的next指针指向前一个节点，但这样会使得后面断掉而无法遍历，因此需要记录后一个节点，
     所以需要三个指针，指向前中后三个节点，当中间节点的next指向前一个节点后，前一个节点指针后移，中间节点指针赋
     值为记录的后一个节点，依次循环，直到当前节点为空
     */

    void reserverLink2() {
        if (this != null && this.node != null && this.node.next != null) {
            Node pPrev = this.node.next;
            if (this.node.next.next != null) {
                Node pCur = this.node.next.next;
                Node pNext = pCur;
                while (pCur != null) {
                    //记录即将断开的后面链表的第一个节点
                    pNext = pCur.next;
                    //令当前节点的next指向前一个节点
                    pCur.next = pPrev;
                    //节点后移
                    pPrev = pCur;
                    pCur = pNext;
                }
                //头尾节点的处理
                this.node.next.next = null;
                this.node.next = pPrev;
            }
        }
    }

    /*

    剑指offer 面试题25：合并两个排序的链表
    描述：输入两个增序的链表，合并这两个链表。并使得合并后的链表仍然增序 \

     */
    /*
     自己的思路：
        思路1：如果是按合并后，各节点的物理地址和原来保持一致，而不允许改变的话，那么就考虑对于单个链表所需指针不止
     一个，因为需要记录当前节点的前一个节点，以便插入；
        思路2：就不需要保持合并前后各节点物理地址与原来一致，只需要其数值相等即可的话，那么就可以重新申请一个新节点，
     将要插入的节点的数值拷贝过来，再将新的节点插入就可以了
        思路3：大致和2相同，只是这次直接全部申请新的节点空间，生成一个合并后的新的地址的链表

    方法1：自己的思路1实现
    */
    void merge(LinkedList list2) {
        if (this != null && this.node != null && list2 != null && list2.node != null) {
            Node pPrev = this.node;
            Node pCur = this.node.next;
            Node qCur = list2.node.next;
            while (pCur != null && qCur != null) {
                if (pCur.value < qCur.value) {
                    pPrev = pCur;
                    pCur = pCur.next;
                } else {
                    list2.node.next = qCur.next;
                    pPrev.next = qCur;
                    qCur.next = pCur;
                    pPrev = qCur;
                    qCur = list2.node.next;
                }
            }
            if (pCur == null) {
                pPrev.next = qCur;
            }
        }
    }

    /*
    也可以使用递归思路，比较两个链表头结点的元素，如果小于，令该链表的头结点指向下一个节点，
    否则插入另一链表的头结点所指元素，下面是c代码
     */
     /*LinkedList* merge2(LinkedList* pHead1,LinkedList* pHead2) {
        if (pHead1 ==null) {
          return pHead2;
        }
        else if(pHead2 == null){
           return pHead1;
        }
        LinkedList* pMergedHead = null;
        if (pHead1->value <pHead2->value) {
                 pMergedHead = pHead1;
                 pMergedHead->next = Merge(pHead1->Next,pHead2);

        }
        else{
                 pMergedHead = pHead2;
                 pMergedHead->next = Merge(pHead1,pHead2->Next);

        }
        return pMergeHead;
    }
    */

    /*
    剑指offer 52题：两个链表的第一个公共节点
       题目：输入两个链表，找出它们的第一个公共节点。（两个链表整体呈Y型结构）
     */
    /*
    思路：找出公共节点一个最麻烦的问题就在于两个链表长度不同，所以我们只需要遍历链表，计算出它们的链表长度之差，之后
    让较长的链表先走差值步，使两个链表从起始位置开始，长度相同，就可以同时向后移动，来找到第一个公共节点了。
     */

    Node findFirstCommonNode(LinkedList link2) {
        if (this != null && this.node != null && link2 != null && link2.node != null && this.node.next != null && link2.node.next != null) {
            //计算链表长度
            int sizeMe = this.getSize();
            int sizeLink2 = link2.getSize();
            int steps = sizeMe - sizeLink2;
            //标记长短链表
            LinkedList linkLong = this;
            LinkedList linkShort = link2;
            if (sizeMe < sizeLink2) {
                steps = sizeLink2 - sizeMe;
                linkLong = link2;
                linkShort = this;
            }
            //长的那个链表先走steps步
            Node one = linkLong.node.next;
            Node two = linkShort.node.next;
            while (steps != 0) {
                one = one.next;
                steps--;
            }
            //各走一步，知道走到头或者找到第一个公共节点
            while (one != null && two != null) {
                if (one == two) {
                    return one;
                }
                one = one.next;
                two = two.next;
            }
            return null;
        }
        return null;
    }

}

