package set_java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/25.
 *
 * -------------------------------------------------
 * 1.HashSet实现了Set接口，由哈希表支持，它不保证set的迭代顺序，特别是它不保证该顺序恒久不变，此类允许使用null元素
 * 2.HashSet是基于HashMap的，迭代顺序的意思是用迭代器遍历set的元素时，返回元素的顺序并不是特定的。底层实际调用底层
 * HashMap的KeySet来返回所有的key，可见HashSet中的元素，只是存在了底层HashMap的key上，value使用一个static final的
 * Object对象标识
 * 3.HashSet的键是不允许重复的，但允许null
 * 4.HashSet的遍历方式与LinkedHashSet的遍历方式相同
 * 5.HashSet的数据结构为数组加上单链表
 */
public class hashSetTest {
    public  static  void main(String[] args){

        HashSet myhashSet=new HashSet();
        myhashSet.add(12);
        HashSet myhashSet1=(HashSet) myhashSet.clone();
        myhashSet1.add(16);
        myhashSet.addAll(myhashSet1);

        System.out.println(myhashSet);
        System.out.println(myhashSet1);


    }
}
