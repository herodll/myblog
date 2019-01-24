package Algorithm.DynamicProgram.LongestComSubstr;

import java.util.List;
import java.util.Stack;

/**
 * 最长公共子序列：采用动态规划思想，当序列x和序列y的索引值i和j均大于等于0，并且x[i]==y[j]时，问题变成了x的前i-1个元素与y的j-1个
 * 元素的解再加上1；如果不等，那么就是max(LCS[i-1][j],LCS[i][j-1]),问题规模逐渐缩小
 */
public class LongestComSubstr {
    public static void main(String[] argv){
        Character[] x = new Character[]{' ','A','B','C','B','D','A','B'};
        Character[] y = new Character[]{' ','B','D','C','A','B','A'};

        //保存每个子规模下的长度
        int[][] c = new int[x.length][y.length];
        //保存每个资规模获得的路径
        Character[][] b = new Character[x.length][y.length];

        int res = LongestComSubstr(x,y,x.length-1,y.length-1);
        System.out.println("length:"+res);

        LongestComSubstr2(x,y,c,b);
        //打印b数组
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        printResult(x,b,x.length-1,y.length-1);
        System.out.println("length:"+c[x.length-1][y.length-1]);

    }

    /**
     * 方法1：此方法只能计算出长度，而最优解的路径无法获得
     * @param x
     * @param y
     * @param i
     * @param j
     *
     * @return
     */

    public static int LongestComSubstr(Character[] x,Character[] y,int i,int j){
        if(i<=0 || j<=0){
            return 0;
        }
        if(x[i] == y[j]){
            return LongestComSubstr(x,y,i-1,j-1)+1;
        }
        else{

            int res1 = LongestComSubstr(x,y,i-1,j);
            int res2 = LongestComSubstr(x,y,i,j-1);
            return res1>res2?res1:res2;
        }
    }

    /**
     * 方法2:
     * @param x
     * @param y
     * @param c
     * @param b
     */
    public static void LongestComSubstr2(Character[] x,Character[] y,int[][] c,Character[][] b){
        int m = x.length-1;
        int n = y.length-1;
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n; j++){
                if(x[i]==y[j]){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]='x';//表示左斜上方

                }
                else{
                    if(c[i-1][j]>=c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j] = 's';//表示正上方
                    }else{
                        c[i][j] = c[i][j-1];
                        b[i][j] = 'z';//表示左方
                    }
                }
            }
        }
    }

    public static void printResult(Character[] x,Character[][] b,int i,int j){
        if(i<=0 || j<=0){
            return;
        }
        if(b[i][j] == 'x'){
            printResult(x,b,i-1,j-1);
            System.out.println(x[i]);
        }
        else if(b[i][j] == 's'){
            printResult(x,b,i-1,j);
        }
        else{
            printResult(x,b,i,j-1);
        }
    }


}
