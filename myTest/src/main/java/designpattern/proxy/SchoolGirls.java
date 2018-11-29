package designpattern.proxy;

/**
 * Created by Administrator on 2018/5/24.
 */
public class SchoolGirls {
   private  String name;

    SchoolGirls(){}
    SchoolGirls(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
