package map_java;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/25.
 * ----------------------------------------------------
 * 1.LinkedHashMap的去重机制
 *   a. 先找到区域
 *        首先传入的key值用hash函数转化为int型的hash值，并且通过该方法让hash值变的更均匀一些，以便公平利用存储空间，
 *    提高查询速度；
 *        其次，之后的indexFor（）方法将根据其hash值和table的大小得到区域的“位置下标”。具体其方法的实现同样是为了
 *    让各区域均匀分配（不是取模，而是return h&(length-1)）
 *   b. 找到区域之后，遍历这个区域来找到对应元素
 *       通过比较hash值以及key的值来判断是否找到了相同的key,找到相同的key值就将其对应的value值替换
 *  --------------------------------------------------------
 *  2.LinkedHashMap的数据结构是数组加上双向链表，在每个entry中，有键值对和一个before和after指针，从而保证了顺序
 *  3.每次插入为尾插
 *
 */
public class LinkedHashMapTest {
    public static void main(String[] args){
        Map<String,Integer> myLinkedHashMap=new LinkedHashMap<String, Integer>(2);
        myLinkedHashMap.put("a",1);
        myLinkedHashMap.put("b",2);
        myLinkedHashMap.put("c",3);
        System.out.println("size="+myLinkedHashMap.size());
        /*
          关于LinkedHashMap的遍历
          1.Set<Map.Entry<K,V>> entrySet()     返回此映射所包含的映射关系的 Set 视图。
          2.Set<K> keySet()              返回此映射中所包含的键的 Set 视图。
         */
         //方式1:第一种for循环
        for ( Map.Entry<String,Integer> it: myLinkedHashMap.entrySet()) {
            System.out.println("key-value:"+it.toString());
        }
        //方式2：第二种for循环
        for (String it:myLinkedHashMap.keySet()
             ) {
             int val=myLinkedHashMap.get(it);
            System.out.println("key-value:"+it+" "+val);
        }
        //也可以使用迭代器方式
        //第一种迭代器方式
        Iterator<Map.Entry<String,Integer>> it=myLinkedHashMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> entry=it.next();
            String key=entry.getKey();
            Integer val=entry.getValue();
            System.out.println("key-value:"+key+" "+val);
        }
        //第二种迭代器方式
        Iterator<String> it1=myLinkedHashMap.keySet().iterator();
        while(it1.hasNext()){
            String key=it1.next();
            int val=myLinkedHashMap.get(key);
            System.out.println("key-value:"+key+" "+val);
        }
    }



}
