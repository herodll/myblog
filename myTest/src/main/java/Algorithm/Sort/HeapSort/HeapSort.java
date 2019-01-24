package Algorithm.Sort.HeapSort;

public class HeapSort {
    public static void main(String[] args){
        int[] arr = new int[]{4,1,3,2,16,9,10,14,8,7};
        //输出堆排序之前的序列
        System.out.println("before heap sort:");
        ArrayUtils.printArray(arr);

        //获得最大值
        System.out.println(maximum(arr));

        //调用堆排序
        heapSort(arr);

        //输出排序后的序列
        System.out.println("after heap sort:");
        ArrayUtils.printArray(arr);
    }

    public static void heapSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        //变得大致有序，下标0为最大值
        buildMaxHeap(array);
        for(int i = array.length-1;i>0;i--) {
            /**
             * 从后向前，将每次的0下标的最大值与当前还未完全确定位置的元素的最后一个
             * 位置交换。也就是说i表示的是当前未确定位置的数组元素的末尾，而每次0下标
             * 为最大值，该位置也就相应确定下来，应将其放置到后面，也就是大数后沉。交换
             * i和0的位置，将最大值放入对应的确定位置。
             */
            ArrayUtils.swapElements(array, i, 0);
            /**
             * 每次交换完成之后，就确定了一个最大值的位置，之后要对根起始为0的节点，待排堆
             *  的元素个数为i的数组进行排序，每次排完之后，最大值在0处
             */
            maxHeap(array,i,0);
        }

    }

    /**
     * 该函数负责从后面开始，慢慢向根靠拢，慢慢将整个数组变得相对有序，也就是对于根来说，
     * 根比它的左右孩子都大就可以了，这样一次该函数的运行，得到的0下标的位置应是最大值。
     * @param array
     */
    public static void buildMaxHeap(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        for(int i=array.length/2;i>=0;i--){
            maxHeap(array,array.length,i);
        }
    }

    /**
     * 该函数是对heapSize大小的数组，并且以0到heapSize区间之间进行堆排
     * @param array
     * @param heapSize:待排堆的大小
     * @param index:开始下标，这个参数也就代表着，一次执行完成之后，最大值所在位置
     */
    public static void maxHeap(int[] array, int heapSize, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if(left < heapSize && array[left] > array[index]){
            largest = left;
        }
        if(right < heapSize && array[right] > array[largest]){
            largest = right;
        }
        if(index != largest){
            ArrayUtils.swapElements(array,index,largest);
            /**
             * 由于一次调整之后，可能造成largest所在子树的最大堆被破坏，因此需要再重新调整
             * 为最大堆
             */
            maxHeap(array,heapSize,largest);
        }

    }

    /**
     * 获取最大值
     * @param array
     * @return
     */
    public static int maximum(int[] array){
        if(array != null){
            /**
             * 注意，这里不能使用maxHeap函数，因为该函数只能调整局部，保证在局部元素中，
             * 0下标最大，必须在保证局部有序，也就是当能保证每个非叶子节点都是遵守大顶堆
             * 的规则的前提下才可以使用maxHeap函数。
             */
            buildMaxHeap(array);
            return array[0];
        }
        return -1;
    }
}
