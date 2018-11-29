package designpattern.abstractFatory.Products;
import designpattern.abstractFatory.Dao.User;
import designpattern.abstractFatory.AbstactProductImpl.*;

/**
 * Created by Administrator on 2018/5/20.
 */
public class AccessUser implements IUser {
    @Override
    public void insert(User user) {
       System.out.println("AccessUser insert");
        
    }

    @Override
    public User getUser(int id) {
        System.out.println("AccessUser getUser");
        return null;
    }
}
