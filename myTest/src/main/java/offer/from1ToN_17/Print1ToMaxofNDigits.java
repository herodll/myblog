package offer.from1ToN_17;

/**
 * Created by Administrator on 2019/5/29.
 */
public class Print1ToMaxofNDigits {

    /**
     * 可以改为char[],以便更加充分的利用空间
     */
    public int [] destCh;
    /**
     * 方法1：从1打印到n位的最大值，主要需要考虑大数。因此需要用字符串或者数组来保存。
     */
    public void printToMaxofN(int n){
        //判断是否为非法输入
        if (n<0){
            return;
        }
        destCh = new int[n+1];
        while(!increate(destCh)){
            //输出数组
            printNumber(destCh);
        }

    }
    public boolean increate(int[] destCh){
        boolean isOver = false;
        //表示上一次的进位
        int tackOver = 0;
        //每一次循环，就只确定当前位置的值是多少
        for(int i=destCh.length-1;i>=0;i--){
            /*if(i == 0){
                isOver = true;
            }*/
            //i位置上现在目前的数加上低位的进位
            int nSum  = destCh[i] + tackOver;
            //如果是最低位，那么加1，因为一个数加1，总是在最低位
            if(i==destCh.length-1){
                nSum++;
            }
            //如果i位置上的数大于9，说明需要进位
            if(nSum>9){
                //需要进位，但是如果该位置已经为最高位，那么意味着要溢出，n位已经达到最大值，退出
                if(i == 1){
                    isOver = true;
                }
                else
                {
                    //需要进位，那么该位置的值就应该是-10以后的数
                    tackOver = 1;
                    nSum = nSum-10;
                    destCh[i] = nSum;
                }
            }
            //如果还不需要进位，那么就直接让其等于nSum，那么也就不需要后面的循环了
            else{
                destCh[i] = nSum;
                break;
            }
        }
        return isOver;
    }

    public void printNumber(int [] destCh){
        boolean flag = true;
        for(int i = 0;i<destCh.length;i++){
            if( flag && destCh[i]!=0){
                flag = false;
            }
            if(!flag) {
                System.out.print(destCh[i]);
            }
        }
        System.out.println();
    }

    /**
     * 方法2：采用递归思想，实际上，就是每一位从0到9的排列，再打印
     */
    public void printToMaxofN_2(int n){
        //n小于等于0.没有意义
        if(n<=0){
            return;
        }
        destCh = new int[n+1];
        for(int i = 0;i<10;i++){
            destCh[1] = i;
            printIncreateNumber_2(destCh,1);
        }
    }

    public void printIncreateNumber_2(int[] destCh,int index){
        if(index == destCh.length-1){
            printNumber(destCh);
            return;
        }
        for(int i = 0;i<10;i++){
            destCh[index+1] = i;
            printIncreateNumber_2(destCh,index+1);
        }
 }

    /**
     * 测试方法1和方法2
     * @param argv
     */
    public static void main(String [] argv){
        int n = 3;
        Print1ToMaxofNDigits s = new Print1ToMaxofNDigits();
        System.out.println("--------------");
        //方法1测试
        //s.printToMaxofN(n);
        //方法2测试
        s.printToMaxofN_2(1);
    }
}
