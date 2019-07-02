package offer.getMinKCountNumbers_40;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2019/6/7.
 * 问题描述：获取数组中最小的k个数
 */
public class GetMinKCountNumbers {
    /**
     * 方法1.可以先将数组排序，再找出k个最小的数就比较容易
     * 方法2：先通过划分，将某个数放入正确排序位置，且它的左边都小于
     * 它，它的右边都大于它。那么，如果这个数如果刚好在第k个位置，那
     * 就得到了最小的k个数了，但是此方法改变了数组。下面实现第二个方法
     */
    public int partition(int[] arr, int start, int end) {
        //以开始下标作为划分元素
        int part = arr[start];
        //当划分范围为1时，不再进行划分
        while (start < end) {
            //当划分元素比末端元素小时，说明末端位置合适，那么
            // 末端下标前移，直到找到一个末端位置不合适的
            //进行交换，交换后，当前划分元素的位置后面都比
            //它大，但前面的并不一定都比它小，因此需要再找合适位置
            while (part < arr[end]) {
                end--;
            }
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            //当开始位置的元素小于划分元素，说明开始位置合适，需要后移，
            //直到找到开始位置不合适的，那么交换开始和末端
            while (start < end && arr[start] < part) {
                start++;
            }
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
        return start;
    }

    public void getMinKCountNumbers(int[] arr, int k) {
        if (arr == null || arr.length <= 0 || k <= 0) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        //先进行一次划分
        int partIndex = partition(arr, start, end);
        //判断划分位置是否在k-1的位置，如果在，直接输出0~k-1,不在就循环
        while (partIndex != k - 1) {
            //说明不在k-1的位置，那么判断是否该划分元素在
            // k-1的右边，在的话，说明目标应该在划分位置
            // 的左边，因此end=index-1，再进行划分，否则，
            // 改变开始位置，进行另一次划分
            if (partIndex > k - 1) {
                end = partIndex - 1;
                partIndex = partition(arr, start, end);
            } else {
                start = partIndex + 1;
                partIndex = partition(arr, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 方法3：采用辅助存储空间，只需要遍历源数组一遍，在遍历过程中，将数字存放在长度只有k的
     * 辅助空间中，当容器中不包含当前数字时，向容器插入该数，当容器已满时，需要将当前数字与容器中的
     * 最大值作比较，如果大于容器最大值，直接舍弃，如果小于，那么替换最大值，遍历只数组尾时，
     * 容器中的K个值就是我们要找的k个最小的值。
     *
     * ***此方法没有改变源数组，并且比较适合海量数据的获取最小的k个值，尤其是k比较小的时候
     * @param
     */
    public void getMinKCountNumbers2(int[] arr,int k){
        if(arr == null || arr.length<=0 || k<=0){
            return;
        }
        TreeSet<Integer> set = new TreeSet<>();
        //遍历整个数组
        for(int i = 0;i<arr.length;i++){
            //如果容器不包含当前元素
            if(!set.contains(arr[i])){
                //如果容器未满，则直接添加
                if(set.size()<k){
                    set.add(arr[i]);
                }
                //容器已满
                else{
                    //对比当前元素与容器最大值的大小，若小，则删掉最大元素，添加当前元素
                    int max = maxFunc(set);
                    if(arr[i]<max){
                        set.remove(max);
                        set.add(arr[i]);
                    }
                }

            }
        }
        print(set);
    }

    public int maxFunc(Set<Integer> set){
        if(set == null){
            return -1;
        }
        int max = -1;
        for (Integer obj: set) {
            if(max<obj){
                max = obj;
            }

        }
        return max;
    }

    public void print(Set<Integer> set){
        for (Integer obj:set) {
            System.out.print(obj+" ");
        }
    }

    /**
     * 测试函数
     * @param argv
     */
    public static void main(String[] argv){
        GetMinKCountNumbers obj  = new GetMinKCountNumbers();
        int[] arr  = new int[]{1,3,9,10,5,6,7,20,12};
        obj.getMinKCountNumbers(arr,6);
        obj.getMinKCountNumbers2(arr,6);
    }




}
