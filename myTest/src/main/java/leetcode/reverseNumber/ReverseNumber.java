package leetcode.reverseNumber;

/**
 * 问题描述：将数字倒序。需要特别注意，负数，以及倒过来可能会溢出的情况
 */
public class ReverseNumber {
    public int reverse(int x) {
        //取绝对值，转换为正数
        int obj = Math.abs(x);
        try{
            int s = Integer.valueOf(new StringBuilder(String.valueOf(obj)).reverse().toString());
            return x>0?s:-s;
        }catch(Exception e){
            //如果溢出，那么就返回0
            return 0;
        }
    }
}
