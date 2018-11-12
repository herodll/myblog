package designpattern.builder.ConcretBuilder;

import designpattern.builder.Builder.PersonBuilder;
import designpattern.builder.Product.PersonProduct;

/**
 * Created by Administrator on 2018/5/21.
 */
public class PersonThinBuilder implements PersonBuilder{

    PersonProduct person = new PersonProduct();
    @Override
    public void builderHead() {
        person.addPart("thinHead");
    }

    @Override
    public void builderbody() {
        person.addPart("thinBody");
    }

    @Override
    public void builderLeftArm() {
        person.addPart("thinLeftArm");
    }

    @Override
    public void buliderRightArm() {
        person.addPart("thinRightArm");
    }

    @Override
    public void builderLeftLeg() {
        person.addPart("thinLeftLeg");
    }

    @Override
    public void builderRightLeg() {
        person.addPart("thinRightLeg");
    }

    @Override
    public PersonProduct getPerson(){
        return person;
    }
}
