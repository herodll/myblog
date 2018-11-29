package designpattern.chainOfResponsibility;

/**
 * Created by Administrator on 2018/5/28.
 */
public class ClientTest {
    public static void main(String[] args) {
       CommonManager commonManager1 = new CommonManager("xiao bai");
        GeneralManager generalManager1 = new GeneralManager("fang fang");
        Major major1 = new Major("xiao qiang");
        Request myrequest = new Request("rest","I am ill , i would go to hospital",1);
        commonManager1.setSuperior(major1);
        major1.setSuperior(generalManager1);
        commonManager1.request(myrequest);

        Request request1 = new Request("workovertime","boss ,i want to work",3);
        commonManager1.request(request1);

        Request request2 = new Request("resign","i want to resign",1);
        commonManager1.request(request2);

        /*
        the run result:

        the type:rest the count: 1 the content : I am ill , i would go to hospital request is allowed
        the type:workovertime count: 3 the content : boss ,i want to work request is allowed
        the type:resign count: 1 the content : i want to resign request is allowed
         */

    }
}
