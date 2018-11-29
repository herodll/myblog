package leetcode.removeElement_27;

/**
 * 问题描述：对给出的数组中将值为val的元素去掉，并将其他元素紧凑放置在合适位置
 * 要求：要求不能申请额外的空间，空间复杂度维持在O(1)内
 */
public class RemoveElementImpl {
    public int removeElement(int[] nums, int val) {
      //判断如果参数不合法，直接返回0
        if(nums.length <= 0){
            return 0;
        }
        //用j表示数组尾索引，用i表示数组头索引
        int j = nums.length-1;
        int i = 0;
        //一个向后，一个向前，当两者相遇之后就是临界点
        while(i<=j){
            //判断当前节点是否等于要去掉的值，如果是，根据条件让后面的位置值代替当前节点值
            if(nums[i] == val){
                /*当后面要替换的值刚好不为要去掉的值时，直接替换，之后索引向前推一个，否则的话吗，直接索引向前推一个，
                然后进行下一次循环，这里注意，不能改变i的值，因为还未找到替换的值
                 */
                if(nums[j] != val) {
                    nums[i] = nums[j];
                    j--;
                }else{
                    j--;
                    continue;
                }
            }
            //替换完成之后，或者当前节点值不是要去掉的值时，直接当前索引后移
            i++;
        }
        //当循环结束之后，j下标就表示当前有效数组的最后一个元素，因此有效数组长度返回当前索引值加1就好了
        return j+1;
    }
}
