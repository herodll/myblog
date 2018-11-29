package designpattern.abstractFatory.Products;
import designpattern.abstractFatory.AbstactProductImpl.*;
import designpattern.abstractFatory.Dao.User;

/**
 * Created by Administrator on 2018/5/20.
 */
public class SqlServerUser  implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("SqlServerUser insert");
    }

    @Override
    public User getUser(int id) {
        System.out.println("SqlServerUser getUser");
        return null;
    }
}
