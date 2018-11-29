package leetcode.symmetricNumber;

/**
 * 问题描述：给一个数字，判断这个数字是否对称
 */

public class symmetricNumberImpl {
    public boolean isPalindrome(int x) {
        //方法1：逆序,为防止整数越界，故采用字符串进行比较
        /*if(x<0){
            return false;
         }
        String x1 = String.valueOf(x);
        String y = new StringBuilder(x1).reverse().toString();
        if(y.equals(x1)){
            return true;
        }
        return false;
        */
        //方法2：前后遍历
        if(x<0){
            return false;
        }
        char[] list = String.valueOf(x).toCharArray();
        int i = 0;
        int j = list.length-1;
        for(;i < j;i++,j--){
            if(list[i] != list[j]){
                return false;
            }
        }
        return true;

    }
}
