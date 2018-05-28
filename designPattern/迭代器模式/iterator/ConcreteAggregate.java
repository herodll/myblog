package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2018/5/28.
 */
public class ConcreteAggregate extends Aggregate {

    private List<Object> items = new ArrayList<Object>();
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public List<Object> getItems() {
        return items;
    }
    public int getCount(){
        return items.size();
    }
    public Object getItem(int index){
        return items.get(index);
    }
    public void setItem(int index,Object value){
        items.add(index,value);
    }
}
