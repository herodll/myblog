package designpattern.observer;

/**
 * Created by Administrator on 2018/5/29.
 */
public class ClientTest {
    public static void main(String[] args) {
        Subject subject = new Secretary();
        Observer obj1 = new NBAObserver("xiao bai",subject);
        Observer obj2 = new MovieObserver("zhang san",subject);
        subject.attach(obj1);
        subject.attach(obj2);
        subject.setSubState("boss come");
        subject.notifys();
        /*
        the run result:

        boss come,  xiao bai : close the NBA,begin work
        boss come,  zhang san : close the movie,begin work
         */

        subject.detach(obj1);
        subject.notifys();
        /*
        the run result:
        boss come,  zhang san : close the movie,begin work
         */
    }
}
