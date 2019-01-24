package Algorithm.DynamicProgram.AssemblyLinesScheduling;

/**
 * author:doulinlin
 * date:2019/01/08
 */

import Algorithm.Sort.HeapSort.ArrayUtils;

/**
 * 装配线调度问题：使得找到一条线，能够得到最小装配时间。
 * 该问题的解决方案采用动态规划思想。对于装配线1来说，当只有一个装配点s(1,1)（表示第一条装配线上的第一个装配点）时，那么f(1,n)=e1+s1,1
 * 当有两个或者两个以上的站点时，对于装配线1来说，f(1,n)=min(f(1,n-1)+s(1,n),f(2,n-1)+t(2,n)+s(1,n)),也就是说，从装配线1出来的最
 * 小装配时间取决于：1：前几个站点的从装配线1出来的最小装配时间+本站点装配所需时间；2：前几个站点的从装配线2出来的最小装配时间+从装配线2
 * 转换到装配线1的时间t(2,n)+本站点装配所需时间。这两个中的较小值作为n个站点从装配线1出来的最小装配时间，还要加上最后退出装配线的时间
 * x(1,n)。对于装配线2也是一样，问题规模逐渐减小，先考虑当问题只有一个站点时，对于此条装配线只有一条路，就是f(2,n)=e2+s(2,1),而有两
 * 个或两个以上站点时，只需要考虑从该装配线的最后一个站点出来的情况，那么从最后一个站点进入时就有两种可能，一种是从装配线1出来进入装配线
 * 2最后一个站点，要么就是从装配线2进入装配线2最后一个站点，那么问题就转化成更小规模的问题。
 *
 */
public class AssemblyLines {
    public static void main(String[] argv) {
        //第一条装配线的进入时间
        int e1 = 2;
        //第二条装配线的进入时间
        int e2 = 4;
        //装配线1的各站点的装配时间
        int[] s1 = new int[]{7,9,3,4,8,4};
        //装配线2的各站点的装配时间
        int[] s2 = new int[]{8,5,6,4,5,7};
        //从装配线1对应站点转换到装配线2下一站点所需要的转换时间
        int[] t1 = new int[]{2,3,1,3,4};
        //从装配线2对应站点转换到装配线1下一站点所需要的转换时间
        int[] t2 = new int[]{2,1,2,2,1};
        //从装配线1退出的时间
        int x1 = 3;
        //从装配线2退出的时间
        int x2 = 2;
        //结果集，用于存放站点
        int[] l1 = new int[s1.length];
        int[] l2 = new int[s2.length];

        int minTime = fastestWay(e1,e2,s1,s2,t1,t2,x1,x2,l1,l2);

        System.out.println("the route is:");
        getMinTimeRoute(l1,l2);

        System.out.println("the minTime:"+minTime);

    }

    public static int fastestWay(int e1,int e2,int[] s1,int[] s2,int[] t1,int[] t2,int x1,int x2,int[] l1,int[] l2){
        int[] f1 = new int[s1.length];
        int[] f2 = new int[s2.length];
        //对于只有一个站点的，对于装配线1来说最小装配时间，装配线2同理
        f1[0] = e1+s1[0];
        f2[0] = e2+s2[0];
        //遍历站点
        for(int j = 1;j<s1.length;j++){
            /**
             * 对于装配线1，到当前站点的最小装配时间，无非是当前站点装配时间加上之前站点的最小装配时间（看进入该站点时的路线是1，还是2）
             * 而之前站点的最小装配时间，如果是从装配线1进入装配线1本站点，那么直接相加。如果是从装配线2进入装配线1的话，还需要加上从
             * 装配线2转换到装配线1的时间。同时l1[]记录进入装配线1上对应站点的路线是从装配线1来还是从装配线2来。
             */

            if(f1[j-1]+s1[j]<f2[j-1]+t2[j-1]+s1[j]){
                f1[j] = f1[j-1]+s1[j];
                l1[j] = 1;
            }
            else{
                f1[j] = f2[j-1]+t2[j-1]+s1[j];
                l1[j] = 2;
            }
            //对于装配线2，与装配线1同理
            if(f2[j-1]+s2[j]<f1[j-1]+t1[j-1]+s2[j]){
                f2[j] = f2[j-1]+s2[j];
                l2[j] = 2;
            }
            else{
                f2[j] = f1[j-1]+t1[j-1]+s2[j];
                l2[j] = 1;
            }
        }
        /**
         * 循环结束以后，就得出了从装配线1最后一个站点出来的最小装配时间和从装配线2最后一个站点出来的最小装配时间，那么只需要对于最后从
         * 各自装配线站点出来并退出的总用时，l1[0]和l2[0]用来记录本次装配线调度的最小装配时间是从哪条装配线得到的。
         */
        l1[0] = f1[s1.length-1]+x1<f2[s2.length-1]+x2?1:2;
        l2[0] = l1[0];

        System.out.println("the f1:");
        ArrayUtils.printArray(f1);
        System.out.println("the f2:");
        ArrayUtils.printArray(f2);
        System.out.println("the l1:");
        ArrayUtils.printArray(l1);
        System.out.println("the l2:");
        ArrayUtils.printArray(l2);

        return f1[s1.length-1]+x1<f2[s2.length-1]+x2?f1[s1.length-1]+x1:f2[s2.length-1]+x2;

    }

    public static void getMinTimeRoute(int[] l1,int[] l2){
        /**
         * 获取最小装配时间的路线，可以利用l1和l2，由于数组对应位置记录的是从对应位置出来的装配线，因此从后向前，
         * l1[0]表示最后一个站点出来的装配线，若为1，则在装配线1的该站点上寻找从前一个站点出来的是哪一条装配线，若
         * 为2，就在装配线2上寻找从前一个站点又是从哪一条装配线出来的，直到找到第1个站点之前是从那一个装配线出来的。
         */
        int exit = l1[0];
        for(int i = l1.length-1;i>=0;i--){
            if(exit == 1){
                System.out.println("the line 1, the station "+i);
                exit = l1[i];
            }else{
                System.out.println("the line 2, the station "+i);
                exit = l2[i];
            }

        }
    }


}
