package arrays_java;

import java.util.Arrays;
import java.util.Iterator;

/*
 * 一：System.arraycopy(src,srcpos,des,despos)
 *   1.System.arraycopy可以实现自己到自己的拷贝，过程是：先创建一个临时数组用于存放despos下标开始
 * 到src.length-1下标的数据，再进行拷贝；
 *   2.无返回值，该方法为static native方法
 *   3.无法进行扩容操作
 * 二：Arrays.copyOf(src,newlength)
 *   1.在复制数组时会返回一个新数组，第二个参数是新数组的大小，达到所谓扩容的效果
 *   2.函数内部是在创建一个新的长度的数组，该数组最终会被返回，再调用System.arraycopy(src,srcpos,des,despos)
 *     函数，其中函数第四个参数是源数组大小与新长度的最小值
 * 三：数组对象.clone()
 *   1.可以用作创建一个对象，在这一点上与new大致相似：
 *     a. new是首先去看new操作符之后的类型，知道了类型才知道要分配多大空间，分配内存之后，再调用构造
 *        函数，填充对象的各个域，亦成为初始化，当构造方法返回时，表明这个对象创建完毕。
 *     b. clone函数在第一步与new相同，都是分配内存，调用clone()函数时，分配的内存和源对象(即就是
 *        调用clone方法的对象)相同(这里也就是所谓的扩容)，然后再使用源对象中对应的各个域，填充新对象
 *        的域，填充完成之后，clone方法返回，一个新的相同的对象被创建，这个新对象的引用就可以被外部其
 *        他地方使用。
 *   2.抛开数组赋值的概念，关于new和clone函数的拷贝问题我们将在该包下的deepOrSallowCopy中讨论
 */
public class arrays_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//数组初始化方式：
	    //方式1：for循环逐一赋值
		int src[]=new int[5];
		int des1[]=new int[20];
		for(int i=0;i<src.length;++i){
			src[i]=i;
		}
		//方式2：直接在new时进行初始化
		int des2[]=new int[]{1,2,3,4,5};
	    //方式3：直接赋值
		int des3[]={10,9,8,7,6,5,4};
       /*
        *  Arrays的静态方法包括：
        *  1.Arrays.binarySearch(arg0, arg1);
        *  2.Arrays.copyOf(arg0, arg1);
        *  3.Arrays.copyOfRange(arg0, arg1, arg2);
        *  4.Arrays.deepEquals(arg0, arg1);
        *  5.Arrays.equals(arg0, arg1);
        *  6.Arrays.fill(arg0, arg1);
        *  7.Arrays.hashCode(arg0);
        *  8.Arrays.sort(arg0);
        *  9.Arrays.toString(arg0);
        */
		
		//关于数组拷贝的四种方式：
		//方式1：for循环逐一复制
		for(int i=0;i<src.length;++i){
			des2[i]=src[i];
		}
		
		//方式2：调用System.arraycopy函数
		System.arraycopy(src,0, des1, 0, src.length);
		//System.arraycopy(src,0, des1, 0, src.length+1);此句会抛出数组越界异常
		for(int i=0;i<des1.length;++i){
			System.out.println("System.arraycopy:des1="+des1[i]);
		}
		
		//方式3：调用Arrays的静态函数copyOf(src,length)
		/*
		 * 此方法中可扩容，因为des3.length=7,但src的数组长度是5，但是还是可以完整的赋值7个数，
		 * 关于它的扩容机制，以及与与其他拷贝函数的区别，我们在上面会详细分析解释
		 */
		src=Arrays.copyOf(des3, des3.length);
		for(int it:src){
			System.out.println("Arrays.copyOf:src="+it);
		}
		//下面语句输出结果为7，表明该拷贝函数可进行扩容
		System.out.println("Arrays.copyOf:src.length="+src.length);
		
	    //方式4：调用Arrays的静态函数copyOfRange(src, from,to)
		des2=Arrays.copyOfRange(src, 0,src.length);
		for(int it:src){
			System.out.println("Arrays.copyOfRange:des2="+it);
		}
		//下面语句输出结果为7，表明该拷贝函数也可进行扩容
		System.out.println("Arrays.copyOfRange:des2.length="+des2.length);
		
		//方式5：调用数组对象本身的clone()函数
		int[] des4=new int[5];
		des4=src.clone();
		for(int it:src){
			System.out.println("src.clone:des4="+it);
		}
		//下面语句输出结果为7，表明该拷贝函数也可进行扩容
		System.out.println("src.clone:des4.length="+des4.length);
		
		/*
		 * 字符串对象转换为数组
		 */
		//字符串对象转换为字符数组用：对象.toCharArray()
		String str1="hello";
		char[] strarr1=str1.toCharArray();
		System.out.print("str1.toCharArray:");
		for(char a:strarr1){
			System.out.print(a+" ");
		}
		Arrays.sort(strarr1);
		System.out.println();
		
		/*
		 * 整型转化为字符串:调用String.valueOf(123456)
		 */
		
		//方式1：调用String.valueOf(int val)
		String myinttostr=String.valueOf(123456);
		System.out.println("String.valueOf:"+myinttostr);
		//方式2：调用Integer.toString(int val)
		int val=12345;
		String myinttostr1=Integer.toString(val);
		System.out.println("Integer.toString:"+myinttostr1);
		
		/*
		 * 字符串转化为整型有两种方式
		 */
		//方式1：用Integer.valueOf("345").intValue();
		//Integer.valueOf("345")返回的是一个Integer对象，需要将其进行拆包操作
		int myint1=Integer.valueOf("345").intValue();
		System.out.println("Integer.valueOf:"+myint1);
		//方式2：用Integer.parseInt("789")
		int myint2=Integer.parseInt("789");
		System.out.println("Integer.parseInt:"+myint2);
		
	}

}
