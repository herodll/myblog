package Algorithm.DynamicProgram.MatrixChainMultiply;

/**
 * author:doulinlin
 * date:2019/01/08
 */

/**
 * 矩阵链乘：采用动态规划思想，k表示加括号的位置。当只有一个矩阵，也就是i=j的时候，所乘次数m[i][j]=0;
 * 当有多个矩阵时，所乘次数为m[i][j]=min(m[i][k]+m[k+1][j]+p(i-1)*p(k)*p(j))
 */

public class MatrixChainMultiply {
    public static void main(String[] argv){
        int[] arr = new int[]{30,35,15,5,10,20,25};
        int[][] m = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        String s1 = "hhehhehheh=";


        matrixChainMultply(arr,m,s);
        printResult(0,arr.length-1,s);
    }

    public static void matrixChainMultply(int[] array,int[][] m,int[][] s){
        /**
         * 第一步：m[i][i]表示括号加在单个矩阵左右，将对应的每个单矩阵的乘积赋值为0
         */
        for(int i=1;i<array.length;i++){
             m[i][i] = 0;
         }
        /**
         * 第二步：确定i,j以及k的取值范围，注意边界
         * 1.首先：需要确定一个变量l来表示该规模下有几个矩阵相乘，注意这里的意思是，如果真正有n个矩阵，但是当前我们只看（）* A（l）
         * 这样的是几个矩阵，无论是否第一个括号内的实际矩阵有多少个，那都是子问题的事情，将其看成一个矩阵就可以了，就像上面的例子
         * 可以看成一共只有两个矩阵相乘；
         * 2. 在确定了如1中有几个矩阵相乘的时候，那么作为i表示的是1中例子中的第一个括号中最后一个矩阵下标，如果l为2，表示有两个大
         * 矩阵相乘，那么i可以从1~n-1,如果是3,那么i可以从1~n-2,变成（）*A（i+1）*A（i+2）,依次类推，可得i从1~n-l+1
         * 3. 就像2中一样，j的取值如果l为2，i为1，那么j为2，变成()*A(j),如果l为3，i为1，那么j为3，变成（）*A（i+1）*...A(i+l-1)
         * *(),因此j的值就是i+l-1.
         * 4. k表示加括号的位置，介于i与j之间，可以取i，因为i如果从数组的角度出发，它表示的是矩阵中的行*列中的列的属性，表示在该矩阵
         * 后加括号。但是j不可以，因为j也表示的是列，如果取值相同，那么就意味着变成了一个矩阵（）
         * 5. 采用动态规划思想计算以k为分界线的计算量
         * 6. 判断是否当前计算量比已经存在的计算量小，如果小更新当前矩阵链乘的计算量
         * 7. s矩阵记录当前最小计算量的括号加在哪里了，记录最优解的路径
         */
        for(int l = 2;l<array.length;l++){
             for(int i = 1;i<=array.length-l;i++){
                 int j = i+l-1;
                 m[i][j] = -1;
                 for(int k = i;k<j;k++){
                     int q = m[i][k]+m[k+1][j]+array[i-1]*array[k]*array[j];
                     if(q<m[i][j] || m[i][j] == -1){
                         m[i][j] = q;
                         s[i][j] = k;
                     }
                 }
             }
         }
         //打印m[][]矩阵
         for(int i = 1;i<array.length;i++){
             for(int j = 1;j<array.length;j++){
                 System.out.print(m[i][j]+" ");
             }
             System.out.println();
         }

    }

    /**
     * s[][]中记录了得到最优解的路径，因此可以从矩阵1到矩阵n，寻找第1行第n列的括号在哪里，也就是s[1][n],该值将n个矩阵分为两半，
     * 再分别去找左半段i~s[1][n],右半段s[1][n]+1~j,知道剩下一个矩阵，也就是边界相等时，输出对应矩阵
     * @param i
     * @param j
     * @param s
     */
    public static void printResult(int i,int j,int[][] s){
        if(i==j){
            System.out.print("A"+i);
        }
        else{
            System.out.print("(");
            printResult(i,s[i][j],s);
            printResult(s[i][j]+1,j,s);
            System.out.print(")");
        }
    }


}
