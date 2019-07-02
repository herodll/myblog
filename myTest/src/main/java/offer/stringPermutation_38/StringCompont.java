package offer.stringPermutation_38;

/**
 * Created by Administrator on 2019/6/6.
 *  问题描述：求字符串中所有字符的长度为m的组合
 *
 *  不对，待解决
 */
public class StringCompont {
    public void stringCompont(char[] str,int m){
        if(str==null || m<=0){
            return;
        }
        char[] des = new char[m];
        stringCompont(str,des,0,0,m);

    }

    public void stringCompont(char[] str,char[] des,int start,int cur,int m){

        for(int i = start;i<str.length+cur-m;i++) {
            if(cur<=m) {
                des[cur] = str[i];
                stringCompont(str, des, i+1, cur + 1, m);
                    //stringCompont(str,des,i,cur,m);
                if(cur==m){
                    print(des);
                }
            }
            else{
                return;
            }
        }




    }
    public void print(char[] des){
        for(int i= 0;i<des.length;i++){
            System.out.print(des[i]);
        }
        System.out.println();
    }

    public static void main(String[] argv){
        String string = new String("abc");
        char[] str = new char[string.length()];
        str = string.toCharArray();
        StringCompont obj = new StringCompont();
        obj.stringCompont(str,2);
    }


}
