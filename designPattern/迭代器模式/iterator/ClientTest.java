package designpattern.iterator;

/**
 * Created by Administrator on 2018/5/28.
 */
public class ClientTest {
    public static void main(String[] args) {
        ConcreteAggregate aggregate1 = new ConcreteAggregate();
        aggregate1.setItem(0,"xiao bai");
        aggregate1.setItem(1,"dou dou");
        aggregate1.setItem(2,"xiao er");
        aggregate1.setItem(3,"yuan yuan");

        Iterator it = new ConcreteIterator(aggregate1);
        Object item = it.first();
        while( it.isDone()== false){
            System.out.println(it.currentItem()+", please buy ticket");
            it.next();
        }
    }
    /*
    the run result:
    
    xiao bai, please buy ticket
    dou dou, please buy ticket
    xiao er, please buy ticket
    yuan yuan, please buy ticket
     */
}
