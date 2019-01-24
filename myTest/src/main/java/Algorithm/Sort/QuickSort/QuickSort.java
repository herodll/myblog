package Algorithm.Sort.QuickSort;

import Algorithm.Sort.HeapSort.ArrayUtils;

/**
 * author:herodou
 * date:2019/01/05
 */

/**
 * 快排的思想：快排是通过一个划分函数来找到目标元素（比如当前待排序的序列的最后一个元素）所在位置。并根据该元素已经确定的位置来将原待
 * 排序数组划分为两部分，再分别对这两个部分进行快排。那么重点就在于如何找到这个目标元素所在的正确位置，也就是划分函数的功能。在划分函
 * 数的思想是通过一个下标来记录比目标元素小的元素的最右边下标，比如用i表示，而用j表示当前正在与目标元素对比的元素，i+1和j之间的元素均
 * 已经比目标元素大。而j和待排序序列的最右边下标endIndex之间的元素表示还未进行比较。因此，划分函数这里最主要的逻辑就是，目标元素为
 * array[endIndex],而i的初值为待排序序列左下标startIndex-1,遍历待排序数组，对比当前元素与目标元素的大小，如果当前元素小于目标元素，
 * 那么将i后移一位，该对应位置即将放入一个比目标元素小的元素，也就是刚才对比之后发现小于目标元素的array[j],而i后移后的这位上本来的元
 * 素比目标元素大（因为本来i+1~j的左闭右开区间表示的是比目标元素大的），也就是刚好将i+1位置上的元素和j位置上的元素交换就可以了。如果
 * 当前元素大于目标元素，那么j后移，进入下一次循环，对比下一个元素。循环结束后，j必然到了最后位置，也就是与目标元素下标重合，这个时候，
 * i+1所在位置就应该是存放该目标元素的正确位置，只需要将i+1所在位置元素和目标元素互换。这样就找到了目标元素的正确位置，并且将目标元素放
 * 入了正确位置，返回该目标元素所在下标就完成了一次划分。
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,8,7,1,3,5,6,4};

        System.out.println("before quick sort:");
        ArrayUtils.printArray(arr);

        System.out.println("after quick sort:");

        //调用快排
        quickSort(arr,0,arr.length-1);
        ArrayUtils.printArray(arr);
    }

    public static void quickSort(int[] array, int startIndex, int endIndex){
        if(array == null || endIndex >= array.length || startIndex < 0){
            return;
        }
        if(startIndex < endIndex){
            int part = partition(array,startIndex,endIndex);
            quickSort(array,startIndex,part-1);
            quickSort(array,part+1,endIndex);
        }
    }

    public static int partition(int[] array, int startIndex, int endIndex){
        //表示比目标元素小的序列的最右边下标
        int minRightIndex = startIndex-1;
        //表示目标元素
        int element = array[endIndex];
        //循环遍历，array[j]表示当前对比元素，minRightIndex+1~j之间表示比目标元素大的元素序列
        for(int j = startIndex;j< endIndex;j++){
            if(array[j] < element){
                //如果当前元素小于目标元素，就需要将该元素纳入小于目标元素的序列中
                minRightIndex++;
                ArrayUtils.swapElements(array,minRightIndex,j);
            }
        }
        //循环结束之后，就找到了目标元素的正确位置，交换，放入正确位置
        ArrayUtils.swapElements(array,minRightIndex+1,endIndex);
        //返回目标元素所在的正确下标位置
        return minRightIndex+1;
    }

}

