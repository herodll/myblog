package designpattern.adapter.Target;

/**
 * Created by Administrator on 2018/5/21.
 */
public abstract class Player {

    private String name;

    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public abstract void attak();
    public abstract void defense();
}
