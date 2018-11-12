package offer.array.stringOp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/5/2.
 * question describe:
 *       实现一个函数，把字符串中的每个空格替换成“%20”
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        /*
        方法1：从前完后扫描字符串，遇到一个空格，空格后的字符串就后移两位，之后再将‘%’，‘2’，‘0’复制到相应位置，
        这样，如果有n个空格，每一个空格需要移动O（n）个位置，所以时间复杂度为O（n^2）
         */
        char[] str = new char[]{'i',' ','a','m',' ','a',' '};
        //char[] s = {'%','2','0'};
        /*System.out.println("please input a string:");
        Scanner in = new Scanner(System.in);
        String string  = in.nextLine();
        for(int i=0;i<string.length();++i) {
            System.out.print(string.charAt(i));
            str[i] = string.charAt(i);
        }*/
        //String des = null;
        //char[] des = new char[str.length];
        /*for(int i=0;i<str.length;++i){
            if(str[i] == ' '){
                System.arraycopy(str,i+1,des,0,str.length-i-1);
               str = Arrays.copyOf(str,str.length+2);
                int len = str.length;
                System.out.println(des);
                System.out.println(len-i-3);

                System.arraycopy(des,0,str,i+3,len-i-3);
                System.out.println(str);
                System.arraycopy(s,0,str,i,3);
                System.out.println(str);
            }
        }
        System.out.println(str);*/
        /*
        方法2：遍历一遍，找出一共有多少个空格，之后从后往前遍历将需要移动的字母一次移动到合理位置,该方法时间复杂度为O（n）
         */
        int count = 0;
        int i=0;
        for(i=0;i<str.length;++i){
            if(str[i] == ' '){
                count++;
            }
        }
        str = Arrays.copyOf(str,str.length+2*count);
        int ptrIndex = str.length-1;
        i=i-1;
        while(i>=0&&i>ptrIndex){
            if(str[i] != ' '){
                str[ptrIndex] = str[i];
                ptrIndex--;
            }
            else{
                str[ptrIndex--] = '0';
                str[ptrIndex--] = '2';
                str[ptrIndex--] = '%';
            }
            i--;
        }
        System.out.println(str);
    }
}
