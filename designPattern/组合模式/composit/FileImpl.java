package designpattern.composit;

import java.util.Iterator;

/**
 * Created by Administrator on 2018/5/28.
 */
public abstract class FileImpl {
    String filename;

    public FileImpl(){}

    public FileImpl(String name){
        this.filename = name;
    }
    public abstract void insert(FileImpl file);
    public abstract void delete(FileImpl file);
    public abstract  void show();
    public  void setFilename(String name){
        this.filename = name;

    }

    public String getFilename(){
        return this.filename;
    }

}
