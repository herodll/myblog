package designpattern.chainOfResponsibility;

/**
 * Created by Administrator on 2018/5/28.
 */
public abstract class Manager {
    String name;
    Manager superior;
    public Manager(){}

    public Manager(String name){
        this.name = name;
    }
    public void setSuperior(Manager superior){
        this.superior = superior;
    }
    public abstract void request(Request request);

}
