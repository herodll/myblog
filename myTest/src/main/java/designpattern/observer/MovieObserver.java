package designpattern.observer;

/**
 * Created by Administrator on 2018/5/29.
 */
public class MovieObserver extends Observer {
    public MovieObserver(String name,Subject subject){
        super(name,subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getSubState()+",  "+name+" : close the movie,begin work ");
    }
}
