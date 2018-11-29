package leetcode.removeElement_27;

public class RemoveElementTest {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,2,3,2,4,2};
        int val = 2;
        int ret = new RemoveElementImpl().removeElement(nums,val);
        for(int i= 0;i< ret; i++){
            System.out.println(nums[i]);
        }
    }
}
