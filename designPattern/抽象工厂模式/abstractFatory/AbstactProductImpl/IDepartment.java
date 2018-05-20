package designpattern.abstractFatory.AbstactProductImpl;

import designpattern.abstractFatory.Dao.Department;

/**
 * Created by Administrator on 2018/5/20.
 */
public interface IDepartment {
    void insert(Department department);
    Department getDepartment(int id);
}

