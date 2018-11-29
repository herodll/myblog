package designpattern.abstractFatory.Products;
import designpattern.abstractFatory.Dao.Department;
import designpattern.abstractFatory.AbstactProductImpl.*;

/**
 * Created by Administrator on 2018/5/20.
 */
public class AccessDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("AccessDepartment insert");

    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("AccessDepartment getDpartment");
        return null;
    }
}
