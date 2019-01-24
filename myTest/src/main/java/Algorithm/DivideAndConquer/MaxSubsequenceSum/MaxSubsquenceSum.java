package Algorithm.DivideAndConquer.MaxSubsequenceSum;

import static javafx.application.Platform.exit;

/**
 * Created by Administrator on 2018/5/13.
 * 最大子序列和
 * 前提是序列中至少有一个正整数
 */
public class MaxSubsquenceSum {

    //穷举法:时间复杂度为O(n^3)
    public static int maxSubsquenceSum(int src[],int N){
        int thisSum;
        int maxSum = 0;
        //表示串开始位置
        for(int i=0;i<N;++i){
            //表示串结束位置
            for(int j = i;j<N;++j ){
                thisSum = 0;
                //统计开始位置到结束位置的和
                for(int k =i;k<=j;++k ){
                    thisSum+=src[k];
                }
                //更新最大值
                if(thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /*
    方法2：对于方法1中的穷举法，实际上我们没必要进行k循环那一层，因为在两遍循环中，我们已经遍历了每一个数，
    所以我们可以在时间复杂度为O(n^2)的条件下得到最大子数组和
     */
    public static int maxSubsquenceSum2(int src[],int N){
        if(src!=null){
            int maxSum = 0;
            for(int i=0;i<N;i++){
                int max = 0;
                for(int j=i;j<N;j++){
                    max += src[j];
                    if(max>maxSum){
                        maxSum = max;
                    }
                }
            }
            return maxSum;
        }
        return -1;
    }

    /*
    方法3：
    分治策略：采用递归思想，控制分治左右边界，时间复杂度为O（nlgn）
       1.如果左边等于右边：那么判断如果该数值大于0的话，就返回该数值作为当前左边最大值；分否则，就返回0
       2.分治思想，取中间位置分割，左边最大值为递归左边，右边最大值为递归右边
       3.经过前面两步，左边区域最大和右边区域最大已经得到，但是最重要还要计算一下横跨中间分界处相连的两边部分的最大值，
       最后结果在这三个中取最大值作为最后结果。所以对于跨界最大值：
          1.从中间位置向左遍历，加和，每加一次，就比较这个结果和跨界最大值的大小，如果和大，则更新当前跨界值
          2.从中间位置向右遍历，加和，每加一次，就比较这个结果和跨界最大值的大小，如果和大，则更新当前跨界值
       4.从第3步，就得到了跨界最大值，之后比较得出三者中的最大值
     */
    public static int maxSubsquenceSum3(int src[],int left,int right){
        int maxLeftSum;
        int maxRightSum;
        int maxLeftBorderSum;
        int maxRightBorderSum;
        //左边边界加法和
        int leftBorderSum;
        //右边边界加法和
        int rightBorderSum;
        //第一步：递归返回条件
        if(left == right){
            if(src[left]>0){
                return src[left];
            }
            else{
                return 0;
            }
        }

        //第二步，递归左右
        int center = (left + right)/2;
        maxLeftSum = maxSubsquenceSum3(src,left,center);
        maxRightSum = maxSubsquenceSum3(src,center+1,right);

        //第三步：得到边界最大值
        maxLeftBorderSum = 0;
        leftBorderSum = 0;
        for(int i=center;i>=left;--i){
            leftBorderSum += src[i];
            if(leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }
        maxRightBorderSum = 0;
        rightBorderSum = 0;
        for(int j = center+1;j<=right;++j){
            rightBorderSum += src[j];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        //比较左边，右边和边界的和的最大值
        int max = maxLeftSum> maxRightSum?maxLeftSum:maxRightSum;
        return max>(maxLeftBorderSum+maxRightBorderSum)?max:(maxLeftBorderSum+maxRightBorderSum);

    }

    /*
    方法4：正如方法2中所示，其实我们只需要遍历一遍就可以了，因为已经遍历过一遍数组中所有的数组了，这种类似具有“记忆功能”
    的，将数据读一遍之后就不需要再重复去从外界读的这种情况称为联机算法,时间复杂度为O（n）：
     */
    public static int maxSubsquenceSum4(int src[],int N){
        if(src == null){
            exit();
        }
        int max = 0;
        int maxSum = 0;
        for(int i=0;i<N;i++){
            max += src[i];
            if(max>maxSum) {
                maxSum = max;
            }
            //如果和出现负数，就表示这个子串不合适，应该放弃，所以需要让和归0
            else if(max<0){
                max = 0;
            }
        }
        return maxSum;
    }

    /**
     * 方法5：采用动态规划的思想，第一个数作为最大和的初始值，只有一个元素的结果集b[0]的和就是该对应元素。遍历数组，如果前n-1个结果集
     * b[n-1]>0的话，那么n个元素的结果集就是b[n-1]+当前元素，如果小于等于0，那么还不如不加，那么n个元素的结果集就是该元素的值，这样就
     * 该问题规模逐渐缩小，计算完n个元素的结果之后，需要更新当前最大和
     * @param src
     * @param b
     * @param n
     * @return
     */

    public static int maxSubsquenceSum5(int[] src,int[] b,int n){
        int sum = src[0];
        b[0] = src[0];
        for(int i= 1;i<n;i++){
            if(b[i-1]>0){
                b[i] = b[i-1]+src[i];
            }else{
                b[i] = src[i];
            }
            if(b[i]>sum){
                sum = b[i];
            }
        }
        return sum;
    }

}
