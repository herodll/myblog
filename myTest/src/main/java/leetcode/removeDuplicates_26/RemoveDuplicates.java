package leetcode.removeDuplicates_26;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：将已经排好序的数组进行去重操作，并将原数组改变为去重后的结果，返回去重后的数组长度
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        if(nums != null && nums.length >0){
            tmp.add(nums[0]);
            int j = 0;
            for(int i = 0;i< nums.length;i++){
                if(nums[i] != tmp.get(j)){
                   tmp.add(nums[i]);
                   j++;
                }
            }
            for(int i=0;i<tmp.size();i++){
                nums[i] = tmp.set(i,tmp.get(i));
            }
        }

        return tmp.size();
    }
}
