package designpattern.abstractFatory;

import designpattern.abstractFatory.AbstactProductImpl.IDepartment;
import designpattern.abstractFatory.AbstactProductImpl.IUser;
import designpattern.abstractFatory.AbstarctFactory.AccessFactory;
import designpattern.abstractFatory.AbstarctFactory.SqlServerFactory;
import designpattern.abstractFatory.AbstractFactoryImpl.AbstarctFactory;
import designpattern.abstractFatory.Dao.Department;
import designpattern.abstractFatory.Dao.User;

/**
 * Created by Administrator on 2018/5/20.
 */
public class AbstarctFactoryTest {
    public static void main(String[] args) {
        User user = new User("zhangsan",001);
        Department department = new Department("sale",002);

        AbstarctFactory factory = new SqlServerFactory();

        IUser sqlUser = factory.createUser();
        sqlUser.insert(user);
        sqlUser.getUser(001);

        IDepartment sqlDepartment = factory.createIDepartment();
        sqlDepartment.insert(department);
        sqlDepartment.getDepartment(002);

        AbstarctFactory factory1 = new AccessFactory();

        IUser accessUser = factory1.createUser();
        accessUser.insert(user);
        accessUser.getUser(001);

        IDepartment accessDepartment = factory1.createIDepartment();
        accessDepartment.insert(department);
        accessDepartment.getDepartment(002);

        /*
        返回结果：
        SqlServerUser insert
        SqlServerUser getUser
        SqlServerDepartment insert
        SqlServerDepartment getDepartment
        AccessUser insert
        AccessUser getUser
        AccessDepartment insert
        AccessDepartment getDpartment
         */

    }
}
