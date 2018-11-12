package offer.array;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/17.
 */

//数组中重复的数字

public class RepeatNumber {
    public static void main(String[] args) {
        //输入数组数据
        Scanner in = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = in.nextInt();
        }

        /*
          方法1：将输入的数组排序，从排序的数组中找到重复的数字是一件很容易的事情，只需要从头到尾按顺序扫描一遍就可以了，
         排序一个长度为n的数组需要O（nlogn）的时间，也是此方法的时间复杂度
         */
        //对数组进行排序(这里是冒泡排序，时间复杂度为O（n^2）)


        /*for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }*/

        //遍历已排序的数组，找出重复值


        /*int flag = 0;  //引入标志变量是因为有可能出现的数字重复不止2次，不能重复输出
        for (int i = 0; i < arr.length-1; ++i) {

            if (arr[i] == arr[i + 1] && flag == 0) {
                System.out.println(arr[i]);
                flag = 1;
            } else {
                flag = 0;
            }
        }*/


        /*
          方法2：采用哈希表解决：从头到尾按顺序扫描数组的每个数字，每扫描到一个数字的时候，都可以用O(1)的时间来判断哈希表
          里是否已经包含了该数字，如果哈希表里还没有这个数字，就把它加入哈希表，如果哈希表已经存在该数字，就找到了重复的数
          字，这个算法的时间复杂度为O(n)，但是它的空间复杂度为O(n),是以空间为代价来换时间的
         */
        //这里假设长度为10的数组中，最大的数不超过10
       /*
         ...............
        */

        /*
          方法3：当数组中的数字都在0~n-1的fan范围时，如果这个数组没有重复的数字，那么当数组排序之后数字i将出现在下标为i的
          位置，由于数组中有重复的数字，有些位置可能存在多个数字，同时有些位置可能没有数字。
             从头到尾依次扫描这个数组中的每个数字，当扫描到下标为i的数字时，首先比较这个数字（用m来表示）是不是等于i,如果
          是，那么接着扫描下一个数字；如果不是，再拿它和第m个数字进行比较，如果它和第m个数字相等，就找到了一个重复的数字，
          如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放在属于它的位置。接下来重复这个比较，交换的过程，直到
          发现一个重复的数字。
              其实就是将数字放入自己该放的位置，是在原数组上进行类似桶排序一样

      */
        //方法3代码如下：
        /* System.out.println("............................");
             for(int j=0;j<arr.length;++j){
                 System.out.print(" "+ arr[j]);
             }
             System.out.println();
             System.out.println("............................");*/
          int i=0;
         while(i<arr.length){
             //System.out.println(i);
             if(arr[i] == i){

                 i++;
                 continue;
             }
              if(arr[i] == arr[arr[i]]){
                 System.out.println(arr[i] );
                  i++;
                  continue;
             }
             else{
                 int tmp=arr[i];
                 arr[i] = arr[arr[i]];
                  //坑点：此处由于上一句已经将arr[i]的值改变，所以该句不能简单的写成以前简单交换的那种，
                  //由于tmp之前保存了arr[i]的值，所以可以使用下面语句
                 arr[tmp] = tmp;
             }

         }

    }
}
