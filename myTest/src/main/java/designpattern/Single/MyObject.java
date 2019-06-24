package designpattern.Single;

/**
 *
 */
public class MyObject {
    /**
     * 饿汉模式：线程安全
     */
   /* private static MyObject myObject = new MyObject();
    private MyObject(){}
    public static MyObject getInstance(){
        return myObject;
    }*/

    /**
     * 懒汉模式：非安全
     */
    /*private static MyObject myObject = null;
    private MyObject(){}
    public MyObject getInstance(){
        if(myObject==null){
            myObject = new MyObject();
        }
        return myObject;
    }*/

    /**
     * DCL双检查锁机制:修改的懒汉模式,线程安全
     */
    /*private static MyObject myObject = null;
    private MyObject(){}
    public MyObject getInstance(){
        if(myObject==null){
            synchronized (MyObject.class) {
                if(myObject==null) {
                    myObject = new MyObject();
                }
            }
        }
        return myObject;
    }*/

    /**
     * 使用静态内置类实现单例模式
     */
    /*private static class MyObjectHandler{
        private static MyObject myObject = new MyObject();
    }

    private MyObject(){}
    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    } */

    /**
     * 使用static代码块实现单例模式
     */
    private static MyObject myObject = null;
    private MyObject(){}
    static{
        myObject = new MyObject();
    }
    public MyObject getInstance(){
        return myObject;
    }

}
