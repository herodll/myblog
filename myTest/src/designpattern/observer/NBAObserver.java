package designpattern.observer;

/**
 * Created by Administrator on 2018/5/29.
 */
public class NBAObserver extends Observer {
    public NBAObserver(String name,Subject subject){
        super(name,subject);
    }
    @Override
    public void update() {
        System.out.println(subject.getSubState()+",  "+name+" : close the NBA,begin work ");
    }
}