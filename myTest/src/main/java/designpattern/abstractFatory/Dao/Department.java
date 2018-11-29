package designpattern.abstractFatory.Dao;

/**
 * Created by Administrator on 2018/5/20.
 */
public class Department {
    private String depName;
    private int depid;

    public Department(){}
    public Department(String depName,int depid){
        this.depName = depName;
        this.depid = depid;
    }

    public void setDepName(String depName){
        this.depName = depName;
    }

    public void setDepid(int depid){
        this.depid = depid;
    }

    public String getDepName(){
        return this.depName;
    }

    public int getDepid(){
        return this.depid;
    }



}
