package offer.stringOp;

import java.util.Arrays;

/**
 * 字符串去重或查重：针对小范围数据，数组长度为n,数字范围从0~n-1,因此肯定有重复值，找出重复值
 */
public class RepeatStringNum {
    public void findRepeatNum(int[] src){
        for(int i=0;i<src.length;i++){
            if(src[i] == i){
                continue;
            }else if(src[i] == src[src[i]]){
                System.out.println(src[i]);
            }else{
                int tmp = src[i];
                src[i] = src[src[i]];
                src[src[i]] = tmp;
                i=i-1;
            }
        }

    }
    public static void main(String[] args){
        /**
         * 方法1：在O(n)的辅助空间下，采用将下标为i的数字m放置到另一辅助数据中下标为m的位置，而下标m对应的数字保存次数，
         * 遍历原数组，这样之后再遍历辅助数组，就可以找出所有重复的数字
         */
        /**
         * 方法2：在O(1)辅助空间下，还是利用方法1的思想，在原数组上改动，遍历原数组，如果下标i对应的数字m与下标i相等，那么
         * 遍历后面的数组，否则，将下标为i的数字与下标为m的数字进行对比，如果相等，那么就找到了一个重复的数字，如果不等，那就
         * 进行交换，也就是将下标为i的数字m放到下标为m的位置，接下来再重复比较交换这个过程，直到发现一个重复的数字。
         */


    }
}
