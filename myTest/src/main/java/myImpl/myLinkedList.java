package myImpl;

/**
 * Created by Administrator on 2018/3/24.
 */

class Node{
    int element;
    Node prev;
    Node next;
    Node(){
        this.prev=null;
        this.next=null;
    }
}
public class myLinkedList {
    private Node node;
    private static int size;
    myLinkedList(){
        this.node=new Node();
        node.prev=node;
        node.next=node;
        this.size=0;
    }

    void add(int val){
        Node newNode=new Node();
        newNode.element=val;
        newNode.prev=this.node.prev;
        newNode.next=this.node;
        newNode.prev.next=newNode;
        this.node.prev=newNode;
        this.size++;
        System.out.println(this.size);
    }
    void removeLast(){
        if(this.node==null||this.node.prev==this.node){
            System.out.println("the linklist is null");
            return;
        }

        Node p=this.node.prev;
        p.prev.next=this.node;
        this.node.prev=p.prev;
        p.element=0;
        p.prev=null;
        p.next=null;
        this.size--;
    }
    void removeFirst(){
         if(this.size==0){
             System.out.println("the linklist is null");
             return;
         }
        Node p=this.node.next;
        this.node.next=p.next;
        p.next.prev=this.node;
        p.prev=null;
        p.next=null;
        p.element=0;
        this.size--;
    }
    int getSize(){
        return this.size;
    }
    int getLast(){
        if(this.size>0){
            return this.node.prev.element;
        }
        return -1;
    }
    int getFirst(){
        if(this.getSize()>0){
            return this.node.next.element;
        }
        return -1;
    }
    int getByIndex(int index){
        if(this.getSize()==0){
            return -1;
        }
        int newIndex=index%this.getSize();
        Node p=this.node;
        while((newIndex--)>0){
            p=p.next;
        }
        return  p.element;
    }
    boolean contains(int element){
        int i=this.getSize();
        while((i--)>=0){
            Node p=this.node.next;
            if(p.element==element){
                return true;
            }
            else{
                p=p.next;
            }
        }
        return false;
    }

    void show(){
        Node p=this.node.next;
        while(p!=this.node){
            System.out.print(p.element+" ");
            p=p.next;
        }
        System.out.println();
    }


}

