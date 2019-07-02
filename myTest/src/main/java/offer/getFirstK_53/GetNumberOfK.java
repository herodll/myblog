package offer.getFirstK_53;

/**
 * Created by Administrator on 2019/6/14.
 * 问题描述：在排序数组中查找数字问题的相关题目;
 * 题目1：数字在排序数组中出现的次数
 */
public class GetNumberOfK {
    /**
     * 针对题目1：数字在排序数组中出现的次数，输入一个数，求该数的次数
     * 法1：我们可以采用哈希表，来保存每个数字出现的次数，此方法复杂度O（n）
     * 法2：利用二分查找法，找到该数字出现的第一个位置和最后一个位置
     */
    /**
     * 寻找k的第一个位置
     * @param arr
     * @param k
     * @return
     */
    public int getFirstK(int[] arr,int k,int start,int end){
        if(arr==null || arr.length<=0 || end<start){
            return -1;
        }
        int midIndex = (start+end)>>1;
        int midNumber  = arr[midIndex];
        if(midNumber==k){
            if(midIndex>0 && arr[midIndex-1]!=k || midIndex==0){
                return midIndex;
            }
            else{
                end = midIndex-1;
            }
        }else{
            if(midNumber>k){
                end = midIndex-1;
            }else {
                start = midIndex+1;
            }
        }
        return getFirstK(arr,k,start,end);
    }

    public int getLastK(int[] arr,int k,int start,int end){
        if(arr==null || arr.length<=0 || start>end){
            return -1;
        }
        int midIndex = (start+end)>>1;
        int midNumber  = arr[midIndex];
        if(midNumber==k){
            if(midIndex<arr.length-1 && arr[midIndex+1]!=k || midIndex==arr.length-1){
                return midIndex;
            }else{
                start = midIndex+1;
            }
        }
        else {
            if(midNumber>k){
                end = midIndex-1;
            }else{
                start = midIndex+1;
            }
        }
        return getLastK(arr,k,start,end);
    }

    public int getNumberOfK(int[] arr,int k) {
        int number = 0;
        int first  = getFirstK(arr,k,0,arr.length-1);
        int last = getLastK(arr,k,0,arr.length-1);
        if(first>-1&&last>-1){
            number = last-first+1;
        }
        return number;

    }

    public static void main(String[] argv){
        GetNumberOfK obj = new GetNumberOfK();
        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        int k=  3;
        int count = obj.getNumberOfK(arr,k);
        System.out.println("the k "+k+" counts are: "+count);
    }


}
