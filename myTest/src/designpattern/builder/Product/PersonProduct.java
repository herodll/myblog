package designpattern.builder.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */
public class PersonProduct {
    List<String> parts = new ArrayList<String>();

    public void addPart(String part){
         parts.add(part);
    }

    public void show(){
        for (String part:parts) {
            System.out.println(part);
        }
    }


}
