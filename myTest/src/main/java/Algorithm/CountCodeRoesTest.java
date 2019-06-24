package Algorithm;

public class CountCodeRoesTest {
    public static void main(String args[])
    {
        getCodeRows cl = new getCodeRows();
        cl.Dir("F:\\cloudtestItem\\cloudtest\\icloudtest\\icloud-web"  );	// 工程代码路径
        cl.countLine();												// 计算.java代码总行数
        System.out.println(cl.getLines());							// 把行数输出到屏幕
    }
}
