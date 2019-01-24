package Algorithm.Sort.HeapSort;

/**
 * author:herodou
 * date:2019/01/04
 *
 */
//本类主要是提供一些和数组相关的基础功能函数，比如数组输出和元素交换
public class ArrayUtils {
    public static void printArray(int[] array){
        System.out.print("{");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i<array.length-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void swapElements(int[] array,int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }





}
