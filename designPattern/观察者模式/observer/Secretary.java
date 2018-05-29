package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */
public class Secretary extends Subject {
    List<Observer> objList = new ArrayList<Observer>();
    String action;
    @Override
    public void attach(Observer observer) {
        objList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        objList.remove(observer);
    }

    @Override
    public void notifys() {
        for (Observer obj: objList) {
            obj.update();
        }
    }

    @Override
    public String getSubState() {
        return action;
    }

    @Override
    public void setSubState(String state) {
        this.action = state;
    }


}
