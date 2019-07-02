package offer.getMedian_41;

/**
 * Created by Administrator on 2019/6/7.
 */
public class GetMedian {
    /**
     * 方法1:根据快排的划分�?�想，当数据长度为奇数，那么划分元素下标位置若为len/2，那�?
     * 该划分元素就是中位数，当数据长度为偶数，那么划分元素下标位置若为len/2,那么中位�?
     * 就是该划分元素与划分元素之前的部分中�?大的数的平均值，如果划分元素下标位置为len/2-1,
     * 那么中位数就是该划分元素与其之后的部分中�?小的数的平均值�??
     *
     * @param arr
     */
    public int getMedian(int[] arr){
        if(arr==null || arr.length<=0){
            return 0;
        }
        int start = 0;
        int end = arr.length-1;
        int partIndex = partition(arr,start,end);
        int midIndex = arr.length/2;
        while(partIndex != midIndex){
            if(partIndex>midIndex){
                end = partIndex-1;
                partIndex = partition(arr,start,end);
            }
            else{
                start = partIndex+1;
                partIndex = partition(arr,start,end);
            }
        }
        if(arr.length%2!=0){
            return arr[midIndex];
        }else{
            int maxFront = getMax(arr,0,midIndex-1);
            return (arr[midIndex]+maxFront)/2;
        }

    }

    public int partition(int[] arr,int start,int end){
        int part = arr[start];
        while(start<end){
            while(start<end && part<arr[end]){
                end--;
            }
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] =  tmp;
            while(start<end && part>arr[start]){
                start++;
            }
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] =  tmp;
        }
        return start;
    }

    public int getMax(int[] arr,int start,int end){
        int max = arr[start];
        for(int i = start+1;i<=end;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] argv){
        GetMedian obj = new GetMedian();
        int[] arr = new int[]{1,2,9,11,27,3,4,5,7,8};
        int mid = obj.getMedian(arr);
        System.out.print("the medium is:"+mid);
    }


}
