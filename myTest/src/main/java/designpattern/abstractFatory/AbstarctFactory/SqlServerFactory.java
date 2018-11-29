package designpattern.abstractFatory.AbstarctFactory;

import designpattern.abstractFatory.AbstactProductImpl.IDepartment;
import designpattern.abstractFatory.AbstactProductImpl.IUser;
import designpattern.abstractFatory.AbstractFactoryImpl.AbstarctFactory;
import designpattern.abstractFatory.Products.SqlServerDepartment;
import designpattern.abstractFatory.Products.SqlServerUser;

/**
 * Created by Administrator on 2018/5/20.
 */
public class SqlServerFactory implements AbstarctFactory {
    @Override
    public IUser createUser() {
        return new SqlServerUser();
    }

    @Override
    public IDepartment createIDepartment() {
        return new SqlServerDepartment();
    }
}
