package map_java;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/25.
 *-----------------------------------------------------
 * 1.HashTable与HashMap比较：
 *     HashTable是线程安全的，而HashMap是非安全的
 *     Hashtable的容量可以为任意整数，最小值为1，扩容是2倍加1，而HashMap的容量始终为2的n次方，扩容为2倍。
 *     数据结构为数组加单链表，以键值对存储，但键值都不允许为null，且键也是不允许重复的，如重复，则进行值覆盖；
 *     对于加载因子，阈值（容量X加载因子），以及modCount（快速失败机制）与HashMap是相同的，但默认容量是11
 *     Hashtable的编码相比较HashMap不是很规范，构造器中出现了硬编码，而HashMap中定义了常量。
 *     HashMap计算索引的方式是h&(length-1),而Hashtable用的是模运算(hash & 0x7FFFFFFF) % tab.length，效率上是低于HashMap的。
 *   Hashtable计算索引时将hash值先与上0x7FFFFFFF,这是为了保证hash值始终为正数。
 *     不保证迭代顺序
 *
 *
 */
public class HashTableTest {
    public static void main(String[] args){
        Hashtable<String,Integer> myHashTable =new Hashtable<>(2);
        myHashTable.put("a",12);
        myHashTable.put("b",13);
        myHashTable.put("c",15);
        //遍历方式1：for循环的entrySet
        for (Map.Entry<String,Integer> it:myHashTable.entrySet()
             ) {
            String key=it.getKey();
            Integer val=it.getValue();
            System.out.println("key_value="+key+" "+val);
        }
        myHashTable.put("c",9);
        myHashTable.put("d",3);
        myHashTable.put("e",14);
        //遍历方式2：for循环的keySet
        for (String key:myHashTable.keySet()
             ) {
            Integer val=myHashTable.get(key);
            System.out.println("key_value="+key+" "+val);
        }
        //遍历方式3：迭代器的entrySet
        Iterator<Map.Entry<String,Integer>> it=myHashTable.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=it.next();
            String key=(String) entry.getKey();
            Integer val=(Integer)entry.getValue();
            System.out.println("key_value="+key+" "+val);
        }
        //遍历方式4：迭代器的keySet
        Iterator<String> it1=myHashTable.keySet().iterator();

        while(it1.hasNext()){
            String key= it1.next();
            Integer val=myHashTable.get(key);
            System.out.println("key_value   ="+key+" "+val);
        }
    }
}
