package designpattern.factoryMethod;

/**
 * Created by Administrator on 2018/5/20.
 */
public class ClientTest {
    public static void main(String[] args) {
        LeiFengFactory factory = new LeiFengStudentFactory();
        LeiFeng me = factory.createLeiFeng();
        me.sweep();
		//运行结果为：LeifengStudent  is sweeping
    }
}
