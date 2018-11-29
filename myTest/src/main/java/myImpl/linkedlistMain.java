package myImpl;

/**
 * Created by Administrator on 2018/3/24.
 */
public class linkedlistMain {
    public static void main(String[] args){
        myLinkedList link1=new myLinkedList();
        link1.add(23);
        link1.add(12);
        link1.add(34);
        link1.show();
        link1.removeLast();
        link1.show();
        link1.getSize();
        link1.getFirst();
        link1.getLast();
        link1.removeFirst();
        link1.show();
        System.out.println(link1.contains(12));
    }

}
