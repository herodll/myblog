package designpattern.composit;

/**
 * Created by Administrator on 2018/5/28.
 */
public class ClientTest {
    public static void main(String[] args) {
        Dictionary root = new Dictionary("root");
        File myfile1 = new File("file1");
        root.insert(myfile1);
        File myfile2 = new File("file2");
        root.insert(myfile2);
        File myfile3 = new File("file3");
        root.insert(myfile3);
        File myfile4 = new File("file4");
        root.insert(myfile4);
        Dictionary dict1 = new Dictionary("dict1");
        root.insert(dict1);
        root.show();
        /*
        the run result:

        this is file1
        this is file2
        this is file3
        this is file4
        this is dict1
         */
    }

}
