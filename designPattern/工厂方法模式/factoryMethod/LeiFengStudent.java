package designpattern.factoryMethod;

/**
 * Created by Administrator on 2018/5/20.
 */
public class LeiFengStudent extends LeiFeng{

    @Override
    public void sweep() {
        System.out.print("LeifengStudent  is sweeping");
   }

    @Override
    public void wash() {
        System.out.print("LeifengStudent is washing");
    }
}
