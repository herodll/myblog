package Algorithm.SortAndSearch;

/**
 * Created by Administrator on 2018/5/18.
 */
public class SortAndSearchOp {
    int[] arr;
    int curSize;
    int maxSize;

    SortAndSearchOp(){
        this.arr = new int[10];
        this.curSize = 0;
        this.maxSize = 10;

    }
    SortAndSearchOp(int initCapacity){
        this.arr = new int[initCapacity];
        this.curSize = 0;
        this.maxSize = initCapacity;
    }

    int getCurSize(){
        return this.curSize;
    }
    int getMaxSize(){
        return this.maxSize;
    }

    void insert(int value){
        if(curSize>=maxSize){
            resize();
        }
        this.arr[curSize] = value;
        this.curSize += 1;
    }

    void resize(){
        if(this.curSize>= this.maxSize){
            SortAndSearchOp newObj = new SortAndSearchOp(this.maxSize*2);
            newObj.maxSize = this.maxSize*2;
            for(int i=0;i<this.curSize; i++){
                newObj.insert(this.arr[i]);
            }
            newObj.curSize = this.curSize;
           // this = newObj;
            this.arr = newObj.arr;
            this.curSize = newObj.curSize;
            this.maxSize = newObj.maxSize;

        }
    }

    //二分查找，时间复杂度为O（lgn）,注意使用二分查找的前提是数值有序排列
    int binarySearch(int value){
        int low = 0;
        int high = this.curSize-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(value>this.arr[mid]){
                low = mid + 1;
            }
            else if(value<this.arr[mid]){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    /*
    冒泡排序:大数后沉，也就是说一遍排序完成之后，最大的数就在最后一位，所以每一次都是相邻的两个数比较，
     跑完长度-1趟之后就可以了，时间复杂度为O（n^2）
     */
    void bubbleSort(){
        for(int i=0; i<this.curSize-1;i++){
            for(int j = 0;j<this.curSize-i-1;j++){
                if(this.arr[j] > this.arr[j+1]){
                    int temp = this.arr[j];
                    this.arr[j] = this.arr[j+1];
                    this.arr[j+1] = temp;
                }
            }
        }
    }

    /*
    冒泡排序优化：为了避免待排序列表本来就是有序的情况或者在经过几遍排序之后，已经有序的情况
     */
    void bubbleSortOptimize(){
        boolean flag = false;
        for(int i = 0;i<this.curSize-1;i++){
            for(int j = 0;j<this.curSize-i-1;j++){
                if(this.arr[j]>this.arr[j+1]){
                    flag = true;
                    int temp = this.arr[j];
                    this.arr[j] = this.arr[j+1];
                    this.arr[j+1] = temp;
                }
            }
            if(flag == false){
                //System.out.println("will return  , i:"+i);
                return;
            }
        }

    }


    /*
    选择排序：小数前移，也就是说每一遍排序完成之后，区间最小的数在首位。每一次都是比较首位和后面的数的大小,
    时间复杂度为O(N^2)
     */
    void selectSort(){
        for(int i = 0; i<this.curSize-1;i++){
            for(int j = i+1;j<this.curSize;j++){
                if(this.arr[i] > this.arr[j]){
                    int temp = this.arr[i];
                    this.arr[i] = this.arr[j];
                    this.arr[j] = temp;
                }
            }
        }
    }
    /*
    选择排序优化：先不急交换，每一趟循环，先找出最小值的下标，再交换
     */
    void selectSortOptimize(){
        for(int i = 0;i<this.curSize-1;i++){
            int min = i;
            for(int j = i+1; j<this.curSize;j++){
                if(this.arr[min]>this.arr[j]){
                    //记录最小值的下标，最后再交换
                    min = j;
                }
            }
            if(min != i){
                int temp = this.arr[i];
                this.arr[i] = this.arr[min];
                this.arr[min] = temp;
            }
        }
    }

    /*
    计数排序：计数排序是稳定排序，但不是原地排序，它是将源待排序数组映射为另一个数组的下标，该另一个数组中则
    存储实际的下标的值的个数，之后再将这些计数加起来存放在的数组中，这样就可以知道原来的值应该在第三个数组的
    一个确定的位置上，之后再将数组再次对应到另一个新的数组中，即为排好序的数组数据
     */
    void countSort(){
        //先得到源待排序数的最大值，以便知道新数组c的大小
        int max = this.arr[0];
        for(int i= 0;i<this.curSize;++i){
            if(this.arr[i]>max){
                max = this.arr[i];
            }
        }
        //在统计完最大值后，由于保持下标与数值一致，我们申请c数组时，申请一个max+1大小的数组
        int[] c = new int[max+1];
        //由于c数组中目前数据全部为0，所以不需要清0，直接将源数组与c数组进行映射，c数组存的是c数组下标的值对应出现的次数
        for(int i=0;i<this.curSize;++i){
            c[arr[i]] +=1;
        }
        //计数，现在c数组存放的是下标的值应该在哪个正确的位置上
        for(int i =0;i<c.length-1;++i){
            c[i+1] += c[i];
        }
        int[] b = new int[this.curSize];
        //将源数组数据排列,从后向前放入正确位置
        for(int i = this.curSize-1;i>=0;i--){
            b[c[this.arr[i]]-1] = this.arr[i];
            c[this.arr[i]] -= 1;

        }

    }



    void show(){
        for(int i=0; i<this.curSize; i++){

           System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }


}
