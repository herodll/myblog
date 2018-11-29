package Algorithm.MaxSubsequenceSum;

import java.util.Scanner;

import static Algorithm.MaxSubsequenceSum.MaxSubsquenceSum.*;

/**
 * Created by Administrator on 2018/5/16.
 */
public class MaxSubsquenceSumTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int length;
        length = in.nextInt();
        int[] src = new int[length];
        for(int i = 0;i<length;i++){
            src[i] = in.nextInt();
        }

        int max = maxSubsquenceSum(src,length);
        int max1=maxSubsquenceSum2(src,length);
        int max2 = maxSubsquenceSum3(src,0,length-1);
        int max3 = maxSubsquenceSum4(src,length);

        System.out.println(max);
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);


    }

}
