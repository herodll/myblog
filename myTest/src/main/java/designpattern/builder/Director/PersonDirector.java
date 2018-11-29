package designpattern.builder.Director;

import designpattern.builder.Builder.PersonBuilder;

/**
 * Created by Administrator on 2018/5/21.
 */
public class PersonDirector {

    public PersonDirector(){}

    public void create(PersonBuilder builder){
        builder.builderHead();
        builder.builderbody();
        builder.builderLeftArm();
        builder.buliderRightArm();
        builder.builderLeftLeg();
        builder.builderRightLeg();
    }
}
