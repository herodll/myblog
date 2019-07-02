package offer.reverseStringByWord_58;

/**
 * Created by Administrator on 2019/6/16.
 * 问题描述：左旋转字符串，比如字符串为abcdefg,数字为2，那么左旋转后为：
 * defgabc
 * 思路：这个题的解法和翻转字符串类似，我们可以将数字0~2间的字符串作为一部分
 * 进行翻转，将剩余的字符串作为另一部分翻转，之后，再将整个数组翻转就可以得到
 * 左旋转字符串
 */
public class LeftRotateString {
    public void reverse(char[] s,int begin,int end){
        if(s==null || s.length<=0){
            return;
        }
        while(begin<end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }
    public void leftRotateString(char[] s,int index){
        if(s==null || s.length<=0){
            return;
        }
        reverse(s,0,index);
        reverse(s,index+1,s.length-1);
        reverse(s,0,s.length-1);
    }

    public static void main(String[] argv){
        String str = new String("abcdefgh");
        LeftRotateString obj = new LeftRotateString();
        char[] s = str.toCharArray();
        obj.leftRotateString(s,2);
        for(int i= 0;i<s.length;i++){
            System.out.print(s[i]);
        }
    }

}
