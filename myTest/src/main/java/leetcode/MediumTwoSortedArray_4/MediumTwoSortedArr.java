package leetcode.MediumTwoSortedArray_4;

import java.util.*;

public class MediumTwoSortedArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 方法1：先将所有数字存入treeSet中，插入之后应该是排好序的，但是由于该数据结构保存的是不重复的键，因此在遍历存放的过程中键来
         * 表示数字，值来表示该数字有几个，如：s1 = {1,2,4,5};s2 = {1,2,3,4}因此map中为[1=2, 2=2, 3=1, 4=2, 5=1]，那么我们要找
         * 中间的数，也就是第8/2=4，但是由于一共偶数个数，因此中位数需要在第4大和第5大之间平均，如果奇数，就是第sum/2大。
         * 1.用s计算目标第index大的数之前有几个数，遍历map,当s<index时，继续遍历，直到s>=index
         * 2.此时，判断如果是总数量是奇数，那么不用平均，只有最中间那个数，也就是第index大对应的数，那么就找到map中对应的数，也就是s加了
         * 当前map中的值只有>=index的数。
         * 3.如果是偶数，那么需要平均，也就是第index大和第index+1大对应的数，old表示当前遍历的map的键，也就是第index+1大对应的数，因为
         * 当s>=index时，上一个值已经加过了，本次遍历值开始，因此需要记录上一次遍历的值作为第index大，用first保存。此时值已经找到，跳出
         * 循环
         * 4.考虑当循环结束之后，也就是遍历完整个map,如{1}，{1}，[1=2],这样遍历一次，s=2,大于2/2=1，且为偶数，需要平均，但无法进入old赋值
         * 语句块，因此需要一个flag标志，如果未进入old语句块就表示前面的值的数量已经超过了目标大，所以是同一个数，只要将first赋值给old即可。
         */
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.replace(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for(int i = 0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                map.replace(nums2[i],map.get(nums2[i])+1);
            }else{
                map.put(nums2[i],1);
            }
        }
        System.out.println(map.entrySet().toString());
        int sum = nums1.length+nums2.length;
        int index = sum/2;//目标第几个数
        int s = 0;//用于计算index之前有几个数
        int first = 0;//用于标记最接近目标index的不重复前一个值
        int old = 0;//用于记录当前index对应的键值
        boolean flag = false;
        for (Integer key:map.keySet()) {
            if (s < index) {
                s += map.get(key);
                first = key;
            } else {
                if(index==s) {
                    old = key;
                }
                else{
                    old = first;
                }
                flag = true;
                break;
            }
        }
        if(flag == false){
            old = map.lastKey();
        }
        if(sum%2!=0){
            return old;
        }else{
                return (double)(old+first)/2;
        }


       /* if(sum%2!=0){
            for (Integer key:map.keySet()
                 ) {
                if(s<index) {
                    s += map.get(key);
                }else{
                    return key;
                }
            }
        }else{
            for (Integer key:map.keySet()) {
                if(s<index) {
                    s += map.get(key);
                    first = key;
                }else{
                    //if(s==index){
                        first = first+key;
                        return ((double)first/2);

                    }
                    *//*if(s>index){
                        System.out.println(key);
                        break;
                    }*//*
                }
            }*/

    }
}
