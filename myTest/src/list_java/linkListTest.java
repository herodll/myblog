package list_java;

import java.util.LinkedList;
/*
   LinkedList底层数据结构为双向链表，带头结点，并且头结点不放数据，可以被当做堆栈，队列或者双端队列进行操作；
   其中定义了两个属性，一个是Entry<E> 的类似结构体一样的数据结构，里面包含了previous,next以及element三个变量；另一个是size，并初始化为0；

 */

public class linkListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer>  myLinkList =new LinkedList<>();
		myLinkList.add(16);
		myLinkList.add(12);
		myLinkList.add(15);
		System.out.println(myLinkList);
		//经验证，下标是从0开始的
        myLinkList.add(2,20);
		System.out.println(myLinkList);
		//不同于ArrayList的remove函数，该函数是真正删除
		myLinkList.removeFirst();
		System.out.println(myLinkList);
		// myLinkList1=new LinkedList<>();
		//LinkedList对象的clone函数，属于深拷贝
		LinkedList<Integer> myLinkList1=(LinkedList<Integer>) myLinkList.clone();
		System.out.println(myLinkList1);
		System.out.println("myLinkList?myLinkList1:"+(myLinkList==myLinkList1));//结果为false
		System.out.println(myLinkList.contains(20));//true
		myLinkList.addAll(myLinkList1);

	}

}
