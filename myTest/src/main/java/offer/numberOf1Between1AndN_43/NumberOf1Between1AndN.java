package offer.numberOf1Between1AndN_43;

/**
 * Created by Administrator on 2019/6/7.
 * 描述：统计1~n之间所有数所含1的总个数
 */
public class NumberOf1Between1AndN {
    /**
     * 方法1：传统方法，循环遍历1到n，统计每一个数中含1的个数，最后累加
     * @param n
     * @return
     */
    public int numberOf1Between1AndN(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
            count+=numberOf1(i);
        }
        return count;
    }
    public int numberOf1(int n){
        int count = 0;
        while(n!=0){
            if(n%10==1){
                count++;
            }
            n = n/10;
        }
        return count;
    }


    /**
     * 测试方法
     * @param argv
     */

    public static void main(String[] argv){
        NumberOf1Between1AndN obj = new NumberOf1Between1AndN();
        int ret = obj.numberOf1Between1AndN(20);
        System.out.print("the count of 1 is: "+ret);
    }

}
