package offer.PrintMatrixByOrder_29;

/**
 * Created by Administrator on 2019/6/4.
 */
public class PrintMatrixByOrder {
    public void printMatrixClockwisely(int[][] numbers, int rows, int cols) {
        if (numbers == null || cols < 0 || rows < 0) {
            return;
        }
        int start = 0;
        //一遍循环，意味着打印了一圈
        while (cols > start * 2 && rows > start * 2) {
            printMatrixInCircle(numbers, rows, cols, start);
            start++;
        }
    }
    public void printMatrixInCircle(int[][] numbers, int rows, int cols, int start) {
        int endX = rows - 1 - start;
        int endY = cols - 1 - start;
        //在一圈内，从左向右打印
        for (int i = start; i <= endY; i++) {
            System.out.print(numbers[start][i] + " ");
        }
        //在一圈内，从上到下打印
        for (int i = start + 1; i <= endX; i++) {
            System.out.print(numbers[i][endY] + " ");
        }
        //在一圈内，从右到左打印
        for (int i = endY - 1; i >= start; i--) {
            System.out.print(numbers[endX][i] + " ");
        }
        //在一圈内，从下到上打印
        for (int i = endX - 1; i > start; i--) {
             System.out.print(numbers[i][start]+" ");

        }

    }

    public static void main(String [] argv){
        PrintMatrixByOrder obj = new PrintMatrixByOrder();
        int rows = 4;
        int cols = 4;
        int [][] numbers = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        obj.printMatrixClockwisely(numbers,rows,cols);
    }
}
