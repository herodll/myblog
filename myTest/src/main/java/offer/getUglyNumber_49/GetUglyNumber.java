package offer.getUglyNumber_49;

/**
 * Created by Administrator on 2019/6/13.
 * 问题描述：丑数是指只包含因子2,3,5的数，求第Index个丑数
 *
 */
public class GetUglyNumber {
    /**
     * 方法1：将所有的数从小到大判断是不是丑数，并记录丑数的个数，直到找到
     * 第index个丑数
     * @param number
     * @return
     */
    public boolean isUgly(int number){
        while(number%2==0){
            number/=2;
        }
        while(number%3==0){
            number/=3;
        }
        while(number%5==0){
            number/=5;
        }
        return (number==1)?true:false;
    }

    public int getUglyNumber(int index){
        if(index<=0){
            return 0;
        }
        //数字，将被用来判断该数是不是丑数
        int number = 0;
        //用来记录是丑数的计数器
        int uglyCount = 0;
        while(uglyCount<index){
            ++number;
            if(isUgly(number)){
                uglyCount++;
            }
        }
        return number;
    }
    /**
     * 方法2：针对方法1中的对于所有的数都需要判断的问题，我们可以只
     * 记录丑数，由于丑数都是之前的丑数的2,3,5倍，因此我们可以使用
     * 一个数组来记录所有丑数，这样很容易找到第Index个丑数
     *
     */
    public int getUglyNumber_2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextIndex = 1;
        int cur2Index = 0;
        int cur3Index = 0;
        int cur5Index = 0;
        while (nextIndex < index) {
            int cur2Number = uglyNumbers[cur2Index] * 2;
            int cur3Number = uglyNumbers[cur3Index] * 3;
            int cur5Number = uglyNumbers[cur5Index] * 5;
            int min2And3 = Math.min(cur2Number, cur3Number);
            int min = Math.min(cur5Number, min2And3);
            uglyNumbers[nextIndex] = min;
            while (uglyNumbers[cur2Index] * 2 <= uglyNumbers[nextIndex]) {
                cur2Index++;
            }
            while (uglyNumbers[cur3Index] * 3 <= uglyNumbers[nextIndex]) {
                cur3Index++;
            }
            while (uglyNumbers[cur5Index] * 5 <= uglyNumbers[nextIndex]) {
                cur5Index++;
            }
            nextIndex++;
        }
        return uglyNumbers[nextIndex-1];
    }

    public static void main(String[] argv){
        GetUglyNumber obj = new GetUglyNumber();
        int ret = obj.getUglyNumber(15);
        System.out.println(ret);
        int ret2 = obj.getUglyNumber(15);
        System.out.println(ret2);
    }
}
