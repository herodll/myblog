package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public abstract class Subject {
    public abstract void attach(Observer observer);
    public abstract void detach(Observer observer);
    public abstract void notifys();
    public abstract String getSubState();
    public abstract void setSubState(String state);


}
