package list_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
 * 一：ArrayList简述：
 *   ArrayList是一个容量能够动态增长的数组，它继承了AbstractList,实现了List等接口，基本的ArrayList,
 *   对于随机访问元素时效率比较高，但是在List中插入和删除元素时比较慢，同时，ArrayList是非线程安全的，
 *   一般在单线程中使用ArrayList,而在多线程中使用Vector或者CopyOnWriteArrayList
 *   ArrayList的自动扩容：
 *   关于其自动扩容，DEFAULT_CAPACITY=10，当容量不够时，通过grow()函数来进行实际扩容：
 *     int oldCapacity = elementData.length;
 *     int newCapacity = oldCapacity + (oldCapacity >> 1);
 * 二：可以看出新扩容后的容量为原来的1.5倍，为什么是1.5倍呢？
 *     效率问题
 * 三：自动扩容的流程：
 *   1.添加元素，当数量超过10时，便会进行自动扩容：
 *     add中调用ensureCapacityInternal(size + 1); 将参数作为minCapacity;
 *   2.得到当前ArrayList的容量(oldCapacity)：
 *     a. 在 ensureCapacityInternal函数中将DEFAULT_CAPACITY与minCapacity做比较，取较大值作为新的minCapacity；
 *        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
 *        之后调用ensureExplicitCapacity(minCapacity);
 *     b. 在ensureExplicitCapacity函数中有:判断确实需要扩容，那么调用grow(minCapacity);
 *   3.计算扩容后的新容量：
 *      在grow函数中有：int oldCapacity = elementData.length;
 *                 int newCapacity = oldCapacity + (oldCapacity >> 1);
 *      来进行1.5倍的扩容
 *   4.当newCapacity容量小于所需的最小容量，将最小所需容量复制给newCapacity；
 *   5.当newCapacity大于ArrayList的所允许的最大容量,进行异常等处理(包含在grow函数中)：
 *      if (newCapacity - MAX_ARRAY_SIZE > 0)
 *         newCapacity = hugeCapacity(minCapacity);          
 *   6.进行数据的复制，完成向ArrayList实例添加元素操作，调用Arrays.copyOf()函数：
 *      elementData = Arrays.copyOf(elementData, newCapacity);   
 * 四：关于对象.clone()函数
 *     底层还是调用了Arrays.copyOf()函数，返回一个全新的空间的对象，所以属于深拷贝
 */
public class arraylistTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ArrayList<Integer> myarr=new ArrayList<Integer>();
        myarr.ensureCapacity(10);
      for(Integer t=0;t<8;t++){
    	  myarr.add(t);
      }

      System.out.println("myarr_size="+myarr.size());
       // System.out.println("myarr_size="+;);
        ArrayList<Integer> mybrr=new ArrayList<>();
                mybrr=(ArrayList<Integer>) myarr.clone();
        System.out.println("myarr==mybrr?:"+(myarr==mybrr));//结果为false,说明拷贝是深拷贝
      //以下三种遍历方式中，效率从高到低依次为索引值遍历，for循环遍历，迭代器遍历
      //方式1：for循环遍历
      for(Integer tmp:myarr){
    	System.out.println("for:myarr="+tmp);
      } 
      //方式:2：索引值遍历
      for(int i=0;i<myarr.size();i++){
    	  System.out.println("index:myarr="+myarr.get(i));
      }
      //方式3：迭代器遍历
      Iterator<Integer> it=myarr.iterator();
      while(it.hasNext()){
    	  System.out.println("Iterator:myarr="+it.next());
      }
      /*
       * 下面是toArray()的使用，是将ArrayList的内容拷贝到数组中，其中待填充数组作为参数。
       * 在使用Object[] toArray()方法时，实际调用的是Arrays.copyof()函数，其返回的是Object[]数组
       * 将Object[]数组转换为其他类型时，会抛出类型转换异常，因为Java不支持向下转型,所以我们常用如下形式的函数来
       * <T> T[]toArray(T[] a)
       * 在使用T方法时，采用的是System.arraycopy方法
       * 关于Arrays.copyof()函数与System.arraycopy方法的区别，我们在arrays_java包下验证讨论
       * 下面是将myarr中的内容拷贝至数组arr中的两种方式：
       */
      //方式1：容易理解
       Integer[] arr1=new Integer[myarr.size()];
       myarr.toArray(arr1);
       for(int j=0;j<arr1.length;++j){
    	   System.out.println("arr1:"+arr1[j]);
       }
       //方式2：最常用
        Integer[] arrt=new Integer[0];
        Integer[] arr2=myarr.toArray(arrt);
        //前两句等价与Integer[] arr2=myarr.toArray(new Integer[0]);
        for(int j=0;j<arr2.length;++j){
     	   System.out.println("arr2:"+arr2[j]);
        }
        /*
         * ArrayList的其他函数用法
         */
        //在指定位置上添加元素
        myarr.add(0, 100);
        System.out.println("myarr[0]:"+myarr.get(0));//100
        //删除指定位置上的元素,删除之后其实长度并没有改变，只是将值赋值为0
        myarr.remove(0);
        System.out.println("myarr[0]:"+myarr.get(0));//0
        System.out.println("myarr_size:"+myarr.size());//20

        //清空,清空之后才是真正的删除所有元素，长度为0，内存将回归系统，所以无法在访问原空间
        myarr.clear();
        System.out.println("myarr_size:"+myarr.size());//0
        //System.out.println("myarr[0]:"+myarr.get(0));此句抛出越界异常      
	}

}
