package offer.array;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/19.
 * 题目描述：
 *    找出数组中重复的数字，但是不能修改原数组，并且数组长度为n，数组中的数都在1~n范围内
 */
public class FindReaptNotChangeSrc {

    public static void main(String[] args) {

         /*
          方法1：不能改变数组本身，可以以空间换时间，申请一个同样大小的辅助数组
          */
        /*
          方法2：如果不采用辅助存储空间，那么我们可以采用类似二分查找的方式来查找重复的数字
             我们把从1~n的数字从中间的数字m分开成为两部分，前面一半为1~m,后面一半为m+1~n,如果
          1~m的数字的数目超过了m，那么这一半一定包含重复的值，我们可以继续将包含重复的数字区间
          一分为二，直到找到一个重复的数字。
             既然所由数字都在1~n之间，比如n=7，那么中间值为4，那么遍历统计1~4的数字有多少个，
          如果超过了4个，那么1~4之间必然存在一个重复的数字，另一段也是这样，直到找到所有重复的
          数字。
             时间复杂度为O（nlgn）
             当然，此解法的比较适合数组中的数在1~length-1之间,并且只包含一个重复的数字
         */
        //输入数组数据
        Scanner in = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = in.nextInt();
        }
        int end =arr.length-1; //代表最大的数字
        int start = 1;
        while(end>=start){
            int mid = (end+start)/2;
            int count = 0;
            //统计从start到mid之间有多少个数
            for(int i=0;i<arr.length;++i){
                if(arr[i]>=start && arr[i]<=mid){
                    count++;
                }
            }

            if(end == start){
                //如果已经找到了最后一个最小的区间，而区间的数字的数量大于这个区间，那么说明重复数字就是这个包含一个数字的区间
                if(count>1){
                    System.out.println(start);
                    break;
                }else{
                    //已经找到只剩下1个数字的区间，而在这个区间，数字的数量没超过1，说明没有重复数字
                    break;
                }
            }
            //如果该区间的数字的实际数量大于该区间的数字本应该的数量，就说明该区间必有重复数字，查找范围减半，否则，就在右半部分找
            if(count>mid-start+1){
                end = mid;
            }else{
                start = mid+1;
            }
        }
    }
}
