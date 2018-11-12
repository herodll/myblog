package designpattern.factoryMethod;

/**
 * Created by Administrator on 2018/5/20.
 */
public class LeiFengStudentFactory extends LeiFengFactory{
    @Override
    public LeiFeng createLeiFeng() {
        return new LeiFengStudent();
    }
}
