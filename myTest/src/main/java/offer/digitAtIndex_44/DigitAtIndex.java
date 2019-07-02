package offer.digitAtIndex_44;

/**
 * Created by Administrator on 2019/6/13.
 * 问题描述：对一个字符串数组01234567891011121314...的格式的序列化
 * 到一个字符序列中，这个字符序列中，第5位是5，第13位是1，第19位是4，
 * 那么，写一个函数，求任意第N位对应的数字
 * 思路：比如，要找第19位对应的数字：
 *   1.判断19是不是比0~9这10个数所占位数10大，大的话说明肯定不在这10
 *   个数字里面，那么19-10=9；
 *   2.在10~99这90个数字所占的180位中，9<180，因此肯定在10~99中，
 *   判断9/2=4,9%2=1,因此应该是10~19中第4个数的第1个位置的数，那么
 *   就是14的第1位4，最终第19位是4就得到了
 *
 */
public class DigitAtIndex {
    public int digitAtIndex(int index){
        if(index<0){
            return -1;
        }
        int digit = 1;//表示数字段位数
        while(true){
            int number = countOfIntegers(digit);
            if(index<number*digit){
                return digitAtIndex(index,digit);
            }
            index-=number*digit;
            digit++;
        }
    }

    /**
     * 计算digit位数的段有多少个数字，比如3位数100~999一共有900个数
     * @param digit
     * @return
     */
    int countOfIntegers(int digit){
        if(digit==1){
            return 10;
        }
        int count =  (int)Math.pow((double)10,(double)(digit-1));
        return 9*count;
    }

    /**
     * index一定在digit数字段，那么寻找index对应的该段的哪个数字的第几位
     * @param index
     * @param digit
     * @return
     */
    int digitAtIndex(int index,int digit){
        //哪个数字
        int number = beginNumber(digit)+index/digit;
        //数字的右数第几位，从右是因为要求余数得到该位置上的数字
        int indexFromRight = digit-index%digit;
        for(int i = 1;i<indexFromRight;i++){
            number/=10;
        }
        return number%10;
    }

    /**
     * 找出digit位数的开始数字是多少，比如3位数的开始数字是100
     * @param digit
     * @return
     */

    int beginNumber(int digit){
        if(digit == 1){
            return 0;
        }
        return (int)Math.pow((double)10,(double)(digit-1));
    }

    public static void main(String[] argv){
        DigitAtIndex obj = new DigitAtIndex();
        int index = 1001;
        int ret = obj.digitAtIndex(index);
        System.out.print("the index "+index+" is :"+ret);
    }


}
