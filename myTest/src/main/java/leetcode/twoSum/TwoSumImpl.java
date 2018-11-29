package leetcode.twoSum;

/**
 * 问题描述：给定一个数组，一个目标值，求得数组中两个数加起来之和等于目标值的数字下标
 */

public class TwoSumImpl {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];//结果集
        for(int i=0;i<nums.length-1;i++){
            int sum = nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum += nums[j];
                if(sum != target){
                    sum = nums[i];
                    continue;
                }
                else{
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }

            }
        }
        return ret;
    }
}
