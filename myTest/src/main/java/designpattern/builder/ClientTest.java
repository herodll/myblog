package designpattern.builder;

import designpattern.builder.Builder.PersonBuilder;
import designpattern.builder.ConcretBuilder.PersonFatBuilder;
import designpattern.builder.ConcretBuilder.PersonThinBuilder;
import designpattern.builder.Director.PersonDirector;
import designpattern.builder.Product.PersonProduct;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ClientTest {
    public static void main(String[] args) {
        PersonDirector director = new PersonDirector();

        PersonBuilder person = new PersonThinBuilder();
        director.create(person);
        PersonProduct thinperson = person.getPerson();
        System.out.println("*************************");
        thinperson.show();
        System.out.println("*************************");

        PersonBuilder person1 = new PersonFatBuilder();
        director.create(person1);
        PersonProduct fatperson = person1.getPerson();
        System.out.println("*************************");
        fatperson.show();
        System.out.println("*************************");

        /*
        运行结果：
        *************************
        thinHead
        thinBody
        thinLeftArm
        thinRightArm
        thinLeftLeg
        thinRightLeg
        *************************
        *************************
        fathead
        fatbody
        fatleftArm
        fatrightArm
        fatleftLeg
        fatRightLeg
        *************************

         */

    }

}
