package designpattern.observer;

/**
 * Created by Administrator on 2018/5/29.
 */
public abstract class Observer {
    String name;
    Subject subject;
    public Observer(){}
    public Observer(String name,Subject subject){
        this.name = name;
        this.subject = subject;
    }
    public abstract void update();
}
