package designpattern.abstractFatory.Products;

import designpattern.abstractFatory.AbstactProductImpl.IDepartment;
import designpattern.abstractFatory.Dao.Department;

/**
 * Created by Administrator on 2018/5/20.
 */
public class SqlServerDepartment implements IDepartment{

    @Override
    public void insert(Department department) {
        System.out.println("SqlServerDepartment insert");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("SqlServerDepartment getDepartment");
        return null;
    }
}
