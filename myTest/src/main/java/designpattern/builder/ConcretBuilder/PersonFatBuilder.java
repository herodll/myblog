package designpattern.builder.ConcretBuilder;

import designpattern.builder.Builder.PersonBuilder;
import designpattern.builder.Product.PersonProduct;

/**
 * Created by Administrator on 2018/5/21.
 */
public class PersonFatBuilder implements PersonBuilder {

    PersonProduct person = new PersonProduct();

    @Override
    public void builderHead() {
        person.addPart("fathead");
    }

    @Override
    public void builderbody() {
        person.addPart("fatbody");
    }

    @Override
    public void builderLeftArm() {
        person.addPart("fatleftArm");
    }

    @Override
    public void buliderRightArm() {
        person.addPart("fatrightArm");
    }

    @Override
    public void builderLeftLeg() {
        person.addPart("fatleftLeg");
    }

    @Override
    public void builderRightLeg() {
         person.addPart("fatRightLeg");
    }

    @Override
    public PersonProduct getPerson(){
        return person;
    }
}
