package offer.moneyMaxDiff_63;

/**
 * Created by Administrator on 2019/6/17.
 * 问题描述，买卖股票利润最大，也就是找出数组中最大值和最小值，但是最大值
 * 的下标一定在最小值下标的右边
 * 解决思路：一次循环，每次循环的下标作为最大值下标，也即是卖出的下标，那么只需要
 * 对比更新该下标之前的最小值就可以，如果它前面的比最小值还小，那么更新最小值，当前
 * 最大差值变为最大值-最小值，当该差值比最大差值还大，那么更新最大差值
 */
public class MoneyMaxDiff {
    public int moneyMaxDiff(int[] numbers,int[] ret){
        if(numbers==null || numbers.length<=0){
            return -1;
        }
        int minNumber = numbers[0];
        int maxDiff = numbers[1]-minNumber;
        for(int i= 2;i<numbers.length;i++){
            if(numbers[i-1]<minNumber){
                minNumber = numbers[i-1];
            }
            int curDiff = numbers[i]-minNumber;
            if(curDiff>maxDiff){
                maxDiff = curDiff;
                ret[0] = minNumber;
                ret[1] = numbers[i];
            }
        }
        return maxDiff;
    }
    public static void main(String[] argv){
        int[] numbers = new int[]{9,11,8,5,7,12,16,14};
        int[] ret = new int[2];
        MoneyMaxDiff obj = new MoneyMaxDiff();
        int maxDiff = obj.moneyMaxDiff(numbers,ret);
        System.out.println("the min is:"+ret[0]+" and max is:"+ret[1]+" ,the maxDiff is:"+maxDiff);
    }


}
