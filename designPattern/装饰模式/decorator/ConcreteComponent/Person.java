package designpattern.decorator.ConcreteComponent;

/**
 * Created by Administrator on 2018/5/22.
 */
public class Person {
    private String name;

    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public void show(){
        System.out.print("decorate "+this.name+" : ");
    }

}
