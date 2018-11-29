package designpattern.abstractFatory.AbstractFactoryImpl;

import designpattern.abstractFatory.AbstactProductImpl.IDepartment;
import designpattern.abstractFatory.AbstactProductImpl.IUser;

/**
 * Created by Administrator on 2018/5/20.
 */
public interface AbstarctFactory {
    IUser createUser();
    IDepartment createIDepartment();
}
