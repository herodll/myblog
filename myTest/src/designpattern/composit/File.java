package designpattern.composit;

/**
 * Created by Administrator on 2018/5/28.
 */
//透明方式
public class File extends FileImpl{

    public File(String name){
        super(name);
    }

    @Override
    public void insert(FileImpl file) {
        System.out.println("file insert");
    }

    @Override
    public void delete(FileImpl file) {
        System.out.println("file delete");
    }

    @Override
    public void show() {
        System.out.println("this file name is "+ filename);
    }



}
