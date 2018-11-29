package list_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
 * һ��ArrayList������
 *   ArrayList��һ�������ܹ���̬���������飬���̳���AbstractList,ʵ����List�Ƚӿڣ�������ArrayList,
 *   �����������Ԫ��ʱЧ�ʱȽϸߣ�������List�в����ɾ��Ԫ��ʱ�Ƚ�����ͬʱ��ArrayList�Ƿ��̰߳�ȫ�ģ�
 *   һ���ڵ��߳���ʹ��ArrayList,���ڶ��߳���ʹ��Vector����CopyOnWriteArrayList
 *   ArrayList���Զ����ݣ�
 *   �������Զ����ݣ�DEFAULT_CAPACITY=10������������ʱ��ͨ��grow()����������ʵ�����ݣ�
 *     int oldCapacity = elementData.length;
 *     int newCapacity = oldCapacity + (oldCapacity >> 1);
 * �������Կ��������ݺ������Ϊԭ����1.5����Ϊʲô��1.5���أ�
 *     Ч������
 * �����Զ����ݵ����̣�
 *   1.���Ԫ�أ�����������10ʱ���������Զ����ݣ�
 *     add�е���ensureCapacityInternal(size + 1); ��������ΪminCapacity;
 *   2.�õ���ǰArrayList������(oldCapacity)��
 *     a. �� ensureCapacityInternal�����н�DEFAULT_CAPACITY��minCapacity���Ƚϣ�ȡ�ϴ�ֵ��Ϊ�µ�minCapacity��
 *        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
 *        ֮�����ensureExplicitCapacity(minCapacity);
 *     b. ��ensureExplicitCapacity��������:�ж�ȷʵ��Ҫ���ݣ���ô����grow(minCapacity);
 *   3.�������ݺ����������
 *      ��grow�������У�int oldCapacity = elementData.length;
 *                 int newCapacity = oldCapacity + (oldCapacity >> 1);
 *      ������1.5��������
 *   4.��newCapacity����С���������С����������С�����������Ƹ�newCapacity��
 *   5.��newCapacity����ArrayList����������������,�����쳣�ȴ���(������grow������)��
 *      if (newCapacity - MAX_ARRAY_SIZE > 0)
 *         newCapacity = hugeCapacity(minCapacity);          
 *   6.�������ݵĸ��ƣ������ArrayListʵ�����Ԫ�ز���������Arrays.copyOf()������
 *      elementData = Arrays.copyOf(elementData, newCapacity);   
 * �ģ����ڶ���.clone()����
 *     �ײ㻹�ǵ�����Arrays.copyOf()����������һ��ȫ�µĿռ�Ķ��������������
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
        System.out.println("myarr==mybrr?:"+(myarr==mybrr));//���Ϊfalse,˵�����������
      //�������ֱ�����ʽ�У�Ч�ʴӸߵ�������Ϊ����ֵ������forѭ������������������
      //��ʽ1��forѭ������
      for(Integer tmp:myarr){
    	System.out.println("for:myarr="+tmp);
      } 
      //��ʽ:2������ֵ����
      for(int i=0;i<myarr.size();i++){
    	  System.out.println("index:myarr="+myarr.get(i));
      }
      //��ʽ3������������
      Iterator<Integer> it=myarr.iterator();
      while(it.hasNext()){
    	  System.out.println("Iterator:myarr="+it.next());
      }
      /*
       * ������toArray()��ʹ�ã��ǽ�ArrayList�����ݿ����������У����д����������Ϊ������
       * ��ʹ��Object[] toArray()����ʱ��ʵ�ʵ��õ���Arrays.copyof()�������䷵�ص���Object[]����
       * ��Object[]����ת��Ϊ��������ʱ�����׳�����ת���쳣����ΪJava��֧������ת��,�������ǳ���������ʽ�ĺ�����
       * <T> T[]toArray(T[] a)
       * ��ʹ��T����ʱ�����õ���System.arraycopy����
       * ����Arrays.copyof()������System.arraycopy����������������arrays_java������֤����
       * �����ǽ�myarr�е����ݿ���������arr�е����ַ�ʽ��
       */
      //��ʽ1���������
       Integer[] arr1=new Integer[myarr.size()];
       myarr.toArray(arr1);
       for(int j=0;j<arr1.length;++j){
    	   System.out.println("arr1:"+arr1[j]);
       }
       //��ʽ2�����
        Integer[] arrt=new Integer[0];
        Integer[] arr2=myarr.toArray(arrt);
        //ǰ����ȼ���Integer[] arr2=myarr.toArray(new Integer[0]);
        for(int j=0;j<arr2.length;++j){
     	   System.out.println("arr2:"+arr2[j]);
        }
        /*
         * ArrayList�����������÷�
         */
        //��ָ��λ�������Ԫ��
        myarr.add(0, 100);
        System.out.println("myarr[0]:"+myarr.get(0));//100
        //ɾ��ָ��λ���ϵ�Ԫ��,ɾ��֮����ʵ���Ȳ�û�иı䣬ֻ�ǽ�ֵ��ֵΪ0
        myarr.remove(0);
        System.out.println("myarr[0]:"+myarr.get(0));//0
        System.out.println("myarr_size:"+myarr.size());//20

        //���,���֮�����������ɾ������Ԫ�أ�����Ϊ0���ڴ潫�ع�ϵͳ�������޷��ڷ���ԭ�ռ�
        myarr.clear();
        System.out.println("myarr_size:"+myarr.size());//0
        //System.out.println("myarr[0]:"+myarr.get(0));�˾��׳�Խ���쳣      
	}

}
