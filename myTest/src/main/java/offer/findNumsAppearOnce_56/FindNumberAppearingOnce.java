package offer.findNumsAppearOnce_56;

/**
 * Created by Administrator on 2019/6/16.
 * 题目描述：一个数组中除了一个数字只出现了一次之外，其余数字均出现了三次，
 * 请找出只出现了一次的那个数
 * 思路：沿用位运算的思路，如果一个数出现了三次，那么将数字的每一位二进制数
 * 对应位加起来都可以被3整除，如果所有数字对应位加起来能被3整除，那么该数字
 * 对应位就应该为0，不能整除则为1，这样对每一位判断，便可以构造出一个只出现
 * 一次的那个数字。
 */
public class FindNumberAppearingOnce {
    public int findNumberAppearingOnce(int[] data){
        if(data==null || data.length<1){
            return -1;
        }
        //用来记录最后结果
        int number = 0;
        for(int bit = 0;bit<=32;bit++) {
            //对所有数的对应位相加，再对下一位累加之前，清零
            int sumBit = 0;
            for (int i = 0; i < data.length; i++) {
                /**
                 * 先将data[i]>>bit位，那么最后1位&1就得到了data[i]的对应bit位，
                 * 依次累加
                 */
                sumBit += ((data[i]>>bit)&1);
            }
            /**
             * sumBit%3的结果就表示只有一个数的数字的当前bit位的结果，将其左移bit位放
             * 到对应位置，依次将之前的bit位结果与其相或，得到最后的数字结果
             */
            number = number | ((sumBit%3)<<bit);
        }
        return number;
    }
    public static void main(String[] argv){
        FindNumberAppearingOnce obj = new FindNumberAppearingOnce();
        int[] data = new int[]{1,2,3,4,3,2,1,1,2,3,4,4,5};
        int number = obj.findNumberAppearingOnce(data);
        System.out.println("the number appearing once is: "+number);

    }

}
