package list_java;

import java.util.Vector;

/**
 * Created by Administrator on 2018/3/23.
 * ------------------------------------------------
 * Vector与ArrayList的区别：
 * 1.都采用数组来存储数据，索引数据块插入数据比较慢
 * 2.ArrayList比Vector快，它是非同步的
 * 3.Vector同步更好一些
 * 4.Vector可以实现自定义的增加长度
 * -------------------------------------------------
 * 关于Vector的增容机制：
 * private void grow(int minCapacity) {
 * // overflow-conscious code
 *   int oldCapacity = elementData.length;
 *   int newCapacity = oldCapacity + ((capacityIncrement > 0) ?capacityIncrement : oldCapacity);
 *    if (newCapacity - minCapacity < 0)
 *          newCapacity = minCapacity;
 *    if (newCapacity - MAX_ARRAY_SIZE > 0)
 *           newCapacity = hugeCapacity(minCapacity);
 *      elementData = Arrays.copyOf(elementData, newCapacity);
 *      }
 *     从上面源码可以看出，当不定义capacityIncrement时，默认当溢出时扩容一倍，但是当定义了该变量的值时，溢出后就增加该变量的值大小的空间，
 *     确定了新数组的大小之后，再调用Arrays.copyOf函数来拷贝数组中原来的值，实际上Arrays.copyOf函数底层也是调用了static native的System.arraycopy函数
 *    ------------------------------------------------
 *    对象.ensureCapacity(int val):该函数用来自定义数组容量
 *    -------------------------------------------------
 */

public class vectorTest {
    public static void main(String[] args) {
        Vector<Integer> myVec1=new Vector<>();
        Vector<Integer> myVec2=(Vector<Integer>) myVec1.clone();
        //结果为false,表示clone函数为深拷贝
        System.out.println("myVec1==myVec2?:"+(myVec1==myVec2));//false

        myVec1.add(12);
        myVec1.add(13);
        System.out.println("myVec1.legth="+myVec1.size());
        System.out.println("myVec1.capacity()="+myVec1.capacity());//10
        for(int i=1;i<9;++i){
            myVec1.add(i);
        }
        System.out.println("myVec1.legth="+myVec1.size());//10
        //并不会自动扩容
        System.out.println("myVec1.capacity()="+myVec1.capacity());//10
        //该函数用来自定义数组容量
        myVec1.ensureCapacity(20);
        System.out.println("myVec1.capacity()="+myVec1.capacity());//20
    }
}
