package offer.getFirstK_53;

/**
 * Created by Administrator on 2019/6/14。
 * 问题描述：数组中数值和下标相等的元素，请编写实现一个函数，找出数组中
 * 任一个数值等于其下标的元素。
 * 思想：采用二分查找算法找，当mid的值等于mid时，返回mid,否则，如果值大
 * 于下标，那么应该相等的在左边，如果值小于下标，应该相等的在右边
 * */
public class GetNumberSameAsIndex {
    public int getNumberSameAsIndex(int[] arr){
        if(arr==null || arr.length<=0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)>>1;
            if(arr[mid]==mid){
                return mid;
            }else{
                if(arr[mid]>mid){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] argv){
        GetNumberSameAsIndex obj = new GetNumberSameAsIndex();
        int[] arr = new int[]{-3,-1,1,3,5};
        int ret = obj.getNumberSameAsIndex(arr);
        System.out.println("the number same as index is: "+ret);
    }


}
