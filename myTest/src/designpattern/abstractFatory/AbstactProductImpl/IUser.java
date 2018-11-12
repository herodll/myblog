package designpattern.abstractFatory.AbstactProductImpl;
import designpattern.abstractFatory.Dao.User;

/**
 * Created by Administrator on 2018/5/20.
 */
public interface IUser {
    void insert(User user);
    User getUser(int id);
}

