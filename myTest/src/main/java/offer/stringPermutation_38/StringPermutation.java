package offer.stringPermutation_38;

/**
 * Created by Administrator on 2019/6/6.
 * 题目描述：对输入的字符串进行全排列
 */
public class StringPermutation {
    /**
     * 在该方法中，采用递归思想，将问题分解为更小得子问题，比如，
     * 我们将字符串看成两部分，第一部分是它的第一个字符，第二部分
     * 是其后所有的字符，将第一个字符和第二部分的字符交换，固定
     * 第一个字符，对其后的所有字符进行群排列（又进行一次群排列，
     * 可用递归）
     */
    public void permutation(char[] str){
        if(str==null){
            return;
        }
        int startIndex = 0;
        permutation(str,startIndex);
    }
    public void permutation(char[] str,int startIndex){
        if(startIndex == str.length-1){
            print(str);
        }
        else{
            for(int pCh = startIndex;pCh<str.length;pCh++){
                //交换第一个元素和其后第二部分的元素
                Character tmp = str[pCh];
                str[pCh] = str[startIndex];
                str[startIndex] = tmp;
                //递归群排列第二部分的所有字符
                permutation(str,startIndex+1);
                //递归结束之后，将顺序还原
                tmp = str[pCh];
                str[pCh] = str[startIndex];
                str[startIndex] = tmp;
            }
        }
    }

    public void print(char[] str){
        for(int i = 0;i<str.length;i++){
            System.out.print(str[i]);
        }
        System.out.println();
    }
    public static void main(String[] argv){
        String string = new String("abc");
        char[] str = new char[string.length()];
        str = string.toCharArray();
        StringPermutation obj = new StringPermutation();
        obj.permutation(str);
    }

}
