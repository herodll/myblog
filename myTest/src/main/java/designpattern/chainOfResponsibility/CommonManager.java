package designpattern.chainOfResponsibility;

/**
 * Created by Administrator on 2018/5/28.
 */
public class CommonManager extends Manager {

    public CommonManager(String name){
        super(name);

    }

    @Override
    public void request(Request request) {
        if(request.requestType.equals("rest")){
            System.out.println("the type:"+request.requestType+" the count: "+request.count+
                    " the content : "+request.requestContent+" request is allowed");
        }else{
            if(this.superior != null){
                this.superior.request(request);
            }
        }
    }
}
