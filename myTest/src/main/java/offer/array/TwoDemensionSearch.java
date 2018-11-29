package offer.array;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/27.
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，请完成一个函数，
 * 输入这样一个数组，和一个整数，判断数组中是否含有该整数
 */
public class TwoDemensionSearch {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int objNum = in.nextInt();
        //in.nextLine();
        int[][]arr = new int[size][size];
        for (int i=0;i<size;++i){
            for(int j=0;j<size;++j){
                arr[i][j] = in.nextInt();
            }
        }

        //查找思路：从最右上角的数字开始，如果比目标数字大，则查找arr[i][j-1],如果比目标数字小，则向下找arr[i+1][j]
        int a=size-1;
        int b=size-1;
        while(a<size&&b>=0){
            if(arr[a][b]==objNum){
                 System.out.println("a="+a+",b="+b);
                break;
            }
            if(arr[a][b]>objNum){
                b=b-1;
            }else{
                a=a+1;
            }
        }

    }
}
