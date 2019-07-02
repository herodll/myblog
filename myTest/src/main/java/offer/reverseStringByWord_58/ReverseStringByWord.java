package offer.reverseStringByWord_58;

/**
 * Created by Administrator on 2019/6/16.
 * 问题描述：翻转字符串，但是每个单词顺序正常 如I am a student.
 * 翻转后：student. a am I
 * 思路，可以先将整个字符翻转，再将单词翻转
 */
public class ReverseStringByWord {
    public void reverse(char[]s,int begin,int end){
        if(s==null || s.length<=0){
            return;
        }
        while(begin<end){
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }
    public void reverseStringByWord(char[] s){
        if(s==null || s.length<=0){
            return;
        }
        reverse(s,0,s.length-1);
        int begin = 0;
        int end = 0;
        while(begin<s.length) {
            if(s[begin]==' '){
                begin++;
                end++;
            }else if(end==s.length  || s[end]==' '){
                reverse(s, begin, --end);
                begin = ++end;
            }else{
                end++;
            }
        }
    }
    public static void main(String[] argv){
        ReverseStringByWord obj = new ReverseStringByWord();
        String str = "I am a student.";
        char[] s = str.toCharArray();
        obj.reverseStringByWord(s);
        for(int i= 0;i<s.length;i++){
            System.out.print(s[i]);
        }
    }


}
