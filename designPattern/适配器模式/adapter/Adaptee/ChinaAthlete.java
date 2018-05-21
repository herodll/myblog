package designpattern.adapter.Adaptee;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ChinaAthlete {

    private String name;
    public ChinaAthlete(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void specialAttack(){
        System.out.println(this.getName()+" special attack");
    }

    public void specialDefense(){
        System.out.println(this.getName()+" special defense");
    }
}
