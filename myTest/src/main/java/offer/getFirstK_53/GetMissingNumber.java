package offer.getFirstK_53;

/**
 * Created by Administrator on 2019/6/14.
 * 题目2:0~n-1中缺失的数字
 *  问题描述：长度为n-1的递增排序数组中所有数字都是唯一的，并且每个数字的范围都在0~n-1
 *  之内，这个范围内有且只有一个数字不在该数组，找出该数字
 *  解决思路：采用二分查找法，如果找到mid的值与mid相等，那么要找的缺失值一定在
 *  mid的后面一段，否则在左边段
 */
public class GetMissingNumber {
    public int getMissingNumber(int[] arr){
        if(arr==null|| arr.length<=0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)>>1;
            int midNumber = arr[mid];
            if(mid==midNumber){
                start = mid+1;
            }else{
                //不相等，判断是不是刚好是mid
                if(mid==0 || arr[mid-1]==mid-1){
                    return mid;
                }
                end = mid-1;

            }
        }
        if(start==arr.length){
            return arr.length;
        }
        return -1;
    }
}
