package Algorithm.SortAndSearch;

/**
 * Created by Administrator on 2018/5/18.
 */
public class SortAndSearchOpTest {
    public static void main(String[] args){
        SortAndSearchOp myArray1 = new SortAndSearchOp(3);
        myArray1.insert(1);
        myArray1.insert(3);
        myArray1.insert(4);
        myArray1.insert(5);
        //myArray1.insert(2);
        myArray1.show();
        int temp = myArray1.getMaxSize();
        System.out.println(temp);
        int index = myArray1.binarySearch(5);
        System.out.println("binarySearch index is : "+ index);
        //myArray1.bubbleSort();
        //myArray1.selectSort();
        myArray1.bubbleSortOptimize();
        //myArray1.selectSortOptimize();
        myArray1.show();
    }
}
