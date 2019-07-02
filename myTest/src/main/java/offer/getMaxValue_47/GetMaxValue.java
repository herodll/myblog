package offer.getMaxValue_47;

/**
 * Created by Administrator on 2019/6/13.
 * 问题描述：从一个二维数组的最左上角出发，数组表示该位置的价值，
 * 每次可以向左或者向下走，求走到最右下角时，得到的礼物的最大价值
 */
public class GetMaxValue {
    public int getMaxValue(int[][] values,int row,int col){
        if(values==null || row<=0 || col <=0){
            return 0;
        }
        int[][] maxValue = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                int up = 0;
                int left  = 0;
                if(i>0){
                    up = maxValue[i-1][j];
                }
                if(j>0){
                    left = maxValue[i][j-1];
                }
                int max  = up>left?up:left;
                maxValue[i][j] = max+values[i][j];
            }
        }
        return maxValue[row-1][col-1];
    }

    public static void main(String[] argv){
        int[][] value = new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        GetMaxValue obj = new GetMaxValue();
        int maxValue = obj.getMaxValue(value,4,4);
        System.out.print(maxValue);
    }

}
