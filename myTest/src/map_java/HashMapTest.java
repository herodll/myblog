package map_java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/25.
 * -------------------------------------------------
 * 1.Map不是collection的子接口或是实现类，它是一个接口；
 * 2.Map里可以拥有多个null的值，但最多只能有一个null键
 * 3.Map的每一个Entry都持有两个对象，也就是键值对，Map可能持有相同的值，但键对象必须是唯一的
 * 4.Entry中包含键值对，key-value之外，还包含hash值和next域
 * 5.modCount字段主要用来记录HashMap内部结构发生变化的次数，主要用于迭代的快速失败
 * 6.在JDK1.8版本中，对数据结构做了进一步的优化，引入了红黑树。而当链表长度太长（默认超过8）时，
 *   链表就转换为红黑树，利用红黑树快速增删改查的特点提高HashMap的性能，其中会用到红黑树的插入、删除、查找等算法。
 * ----------------------------------------------------
 * 1.HashMap的默认容量为16，加载因子为0.75，最大容量为2的30次方
 * 2.扩容一次变为原来的2倍
 * 3.其数据结构为数组加单链表
 * 4.遍历方式与LinkedHashMap相同
 * -----------------------------------------------------
 *
 */
public class HashMapTest {
    public static void main(String[] args){
        Map<String,Integer> mymap1=new HashMap(2);


    }
}
