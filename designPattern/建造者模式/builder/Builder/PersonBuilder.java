package designpattern.builder.Builder;

import designpattern.builder.Product.PersonProduct;

/**
 * Created by Administrator on 2018/5/21.
 */
public interface PersonBuilder {
    void builderHead();
    void builderbody();
    void builderLeftArm();
    void buliderRightArm();
    void builderLeftLeg();
    void builderRightLeg();
    PersonProduct getPerson();
}
