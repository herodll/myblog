package Algorithm.DivideAndConquer.GetNumberMin;


import Algorithm.Sort.HeapSort.ArrayUtils;

/**
 * 本问题是利用分治思想解决第几小问题。此问题可以利用快排中的思想，通过划分函数找到某个随机元素的正确位置，该位置上的数字所对应的位置下
 * 标就是第几小（如果下标从1开始的话）
 */

public class GetNumberMin {
    public static void main(String[] argv){
        int findIndex = 3;
        int[] arr = new int[]{6,10,13,5,8,3,2,11};
        int digit = randomizeSelect(arr,0,arr.length-1,findIndex);
        ArrayUtils.printArray(arr);
        System.out.println("the array the "+findIndex+" smallest number is "+ digit);
    }

    public static int randomizeSelect(int[] array,int startIndex,int endIndex,int findIndex){
        if(array == null || startIndex<0 || endIndex >= array.length ){
            return -1;
        }

        if(startIndex==endIndex){
            return array[startIndex];
        }
        int q = partition(array,startIndex,endIndex);
        //当前划分元素是第几小
        int cur = q-startIndex+1;
        //划分的元素若与要找的相同，那么就找到了
        if(cur == findIndex){
            return array[q];
        }
        //如果当前划分元素所在第几小比目的第几小小的话，就在划分元素位置后面的元素中寻找
        else if(cur < findIndex){
            return randomizeSelect(array,q+1,endIndex,findIndex-cur);
        }
        //如果当前划分元素所在第几小比目的第几小大的话，就在划分元素位置前面的元素中寻找
        else{
            return randomizeSelect(array,startIndex,q-1,findIndex);
        }
    }

    public static int partition(int[] array,int startIndex,int endIndex){
        int i = startIndex-1;
        int element = array[startIndex];
        for(int j = startIndex;j<=endIndex;j++){
            if(array[j]<element){
                i++;
                ArrayUtils.swapElements(array,i,j);
            }
        }
        array[i+1] = element;
        return i+1;
    }


}
