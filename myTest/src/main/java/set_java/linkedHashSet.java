package set_java;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/25.
 * 1.LinkedHashSet的底层实现其实是调用了LinkedHashMap
 * 2.LinkedHashSet维护者一个运行所有条目的双重链表列表，此链接列表定义了迭代顺序，该迭代顺序可为插入顺序或者是访问顺序
 * 3.只保存键值对的键的值，而值的值用一个对象标识，不允许出现重复键，但可以允许有一个null值
 * -----------------------------------------------------------------------
 * 4.扩容机制
 *   初始容量是指在哈希表在创建时的容量
 *   加载因子是指在哈希表在其容量自动增加之前可以达到多满的一种尺度
 *      当哈希表中的条目数量超出了加载因子与初始容量的乘积时，通过调用rehash方法将容量翻倍（每次增加一倍）,容量增加时，需
 *   要对所有的元素进行
 *      再次散列，并将它们正确的存入正确的散列位中
 * ---------------------------------------------------------------------
 * 5.以下是LinkedHashMap的四个构造函数
 *
 *  /**
 * Constructs a new, empty linked hash set with the specified initial
 * capacity and load factor.
 *
 * @param      initialCapacity the initial capacity of the linked hash set
 * @param      loadFactor      the load factor of the linked hash set
 * @throws     IllegalArgumentException  if the initial capacity is less
 *               than zero, or if the load factor is nonpositive
 * 构造一个带有指定的初始容量和加载因子的新的空链接哈希set
 * 底层会调用父类的构造函数，构造一个指定初始容量和加载因子的LinkedHashMap实例
 * @param      initialCapacity 初始容量
 * @param      loadFactor      加载因子
 *
      public LinkedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
        }
----------------------------------------------------------------------
/**
 * Constructs a new, empty linked hash set with the specified initial
 * capacity and the default load factor (0.75).
 *
 * @param   initialCapacity   the initial capacity of the LinkedHashSet
 * @throws  IllegalArgumentException if the initial capacity is less
 *              than zero
 *
 * 构造一个带有指定的初始容量和加载因子0.75的新的空链接哈希set
 * 底层会调用父类的构造函数，构造一个指定初始容量和加载因子的LinkedHashMap实例
 * @param      initialCapacity 初始容量

public LinkedHashSet(int initialCapacity) {
        super(initialCapacity, .75f, true);
        }

-----------------------------------------------------------------------
 *//**
 * Constructs a new, empty linked hash set with the default initial
 * capacity (16) and load factor (0.75).
 *
 * 构造一个带有默认的初始容量16和加载因子0.75的新的空链接哈希set
 * 底层会调用父类的构造函数，构造一个默认的初始容量16和加载因子的LinkedHashMap实例

public LinkedHashSet() {
        super(16, .75f, true);
        }
-----------------------------------------------------------------------
        *//**
 * Constructs a new linked hash set with the same elements as the
 * specified collection.  The linked hash set is created with an initial
 * capacity sufficient to hold the elements in the specified collection
 * and the default load factor (0.75).
 *
 * @param c  the collection whose elements are to be placed into
 *           this set
 * @throws NullPointerException if the specified collection is null
 *
 * 构造一个与指定的collection中的元素相同的新的链接哈希set
 * 底层使用父类的构造函数，构造一个足以包含指定collection中所有元素的初始容量和加载因子为0.75的linkedHashMap实例
 *  @param c 其中的元素将存放在此set中的collection

public LinkedHashSet(Collection<? extends E> c) {
        super(Math.max(2*c.size(), 11), .75f, true);
        addAll(c);
        }
 --------------------------------------------------------------------------
 6. LinkedHashSet的去重机制（实际上是HashMap的去重机制）
    a. 先找到区域
             首先传入的key值用hash函数转化为int型的hash值，并且通过该方法让hash值变的更均匀一些，以便公平利用存储空间，
       提高查询速度；
             其次，之后的indexFor（）方法将根据其hash值和table的大小得到区域的“位置下标”。具体其方法的实现同样是为了
       让各区域均匀分配（不是取模，而是return h&(length-1)）
    b. 找到区域之后，遍历这个区域来找到对应元素
             通过比较hash值以及key的值来判断是否找到了相同的key,找到相同的key值就将其对应的value值替换
 ----------------------------------------------------------------------------
 7. 快速失败机制
        快速失败机制是说在多线程中，一个线程利用迭代器在遍历（只读）所有元素的时候，另一个线程修改了原来集合中的元素，
    修改后第一个线程在调用checkForComodification()时比较“expectedModCount”和“modCount”的大小；而“expectedModCount=N”，
   “modCount=N+1”,这样，便抛出ConcurrentModificationException异常，产生fail-fast事件。
 */
public class linkedHashSet {
    public  static  void main(String[] args){
        LinkedHashSet<Integer> mylinkHashSet =new LinkedHashSet(2);

        mylinkHashSet.add(67);
        mylinkHashSet.add(34);
        mylinkHashSet.add(56);
        //遍历方式1：for循环
        for (Integer entry:
             mylinkHashSet) {
            System.out.println("val="+entry);
        }
        //遍历方式2：迭代器方式
        Iterator it=mylinkHashSet.iterator();
        while(it.hasNext()){
            System.out.println("val="+it.next());
        }
        System.out.println(mylinkHashSet+"   size= "+mylinkHashSet.size());
    }
}
