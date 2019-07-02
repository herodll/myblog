package offer.adjustArrayOrderByJIOU_21;

/**
 * Created by Administrator on 2019/5/30.
 */
public class AdjustArrayOrder {
    int arr[];
    Functions functions = new FunctionImpl();

    public void init(int [] arr){
        this.arr = arr;
    }

    public void reOrder(){
        if(arr==null || arr.length<=1){
            return;
        }
        int begin = 0;
        int end = arr.length-1;

        while(begin<end){
            //找到偶数的开始位置
            while(begin < end && !functions.isEven(arr[begin])){
                begin++;

            }
            //找到末尾奇数的位置
            while(begin < end && functions.isEven(arr[end])){
                end--;
            }
            //此时，begin找到了偶数的位置，end找到了奇数的位置，那么交换
            if(begin<end){
                int tmp =arr[begin];
                arr[begin] = arr[end];
                arr[end] = tmp;
            }
        }
    }

    public void print(){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] argv){
       int [] arr = new int[]{1,2,3,4,5,6,7,8};
        AdjustArrayOrder obj = new AdjustArrayOrder();
        obj.init(arr);
        obj.reOrder();
        obj.print();
    }

}
