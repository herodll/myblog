package designpattern.composit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/5/28.
 */
public class Dictionary extends FileImpl {

    List<FileImpl> files = new ArrayList<>(10);
    public Dictionary(String name){
        super(name);
    }


    @Override
    public void insert(FileImpl file) {
        files.add(file);
    }

    @Override
    public void delete(FileImpl file) {
        files.remove(file);
    }

    @Override
    public void show() {
        for(int i = 0;i<files.size();++i){
            System.out.println("this is "+files.get(i).getFilename());

        }
    }


}
