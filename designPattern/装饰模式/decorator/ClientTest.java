package designpattern.decorator;

import designpattern.decorator.ConcreteComponent.Person;
import designpattern.decorator.ConcreteDecorator.Shoes;
import designpattern.decorator.ConcreteDecorator.Trousers;
import designpattern.decorator.ConcreteDecorator.Tshirts;

/**
 * Created by Administrator on 2018/5/22.
 */
public class ClientTest {
    public static void main(String[] args) {
        Person person = new Person("����");
        Tshirts tshirts = new Tshirts();
        Shoes shoes = new Shoes();
        Trousers trousers = new Trousers();

        trousers.decorate(person);
        shoes.decorate(trousers);
        tshirts.decorate(shoes);
        tshirts.show();
        /*
        ���н����
        decorate ���� :  Trousers  shoes  Tshirts 
         */
    }




}
