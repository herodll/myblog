package designpattern.abstractFatory.AbstarctFactory;

import designpattern.abstractFatory.AbstactProductImpl.IDepartment;
import designpattern.abstractFatory.AbstactProductImpl.IUser;
import designpattern.abstractFatory.AbstractFactoryImpl.AbstarctFactory;
import designpattern.abstractFatory.Products.AccessDepartment;
import designpattern.abstractFatory.Products.AccessUser;

/**
 * Created by Administrator on 2018/5/20.
 */
public class AccessFactory implements  AbstarctFactory{
    @Override
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDepartment createIDepartment() {
        return new AccessDepartment();
    }
}
