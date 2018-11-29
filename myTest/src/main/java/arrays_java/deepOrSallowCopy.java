package arrays_java;

/*
 * 用来测试讨论clone与new深拷贝or浅拷贝问题
 */
class A implements Cloneable{
	
	public int val;
	public String name;
	
	//构造函数
	A(){}
	A(int val,String name){
		this.val=val;
		this.name=name;	
	}
	
	void setVal(int val){
		 this.val=val;
	}
	void setName(String name){
		this.name=name;
	}
	int getVal(){
		return this.val;
	}
	String getName(){
		return this.name;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + val;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (val != other.val)
			return false;
		return true;
	}*/
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (A)super.clone();
	}
	/*@Override
	public String toString() {
		return "A [val=" + val + ", name=" + name + "]";
	}*/
	
	
}
public class deepOrSallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------new对象引用----------------");
		A a1=new A(23,"lili");
		A a2=a1;
		//此句返回值为true,表明对于new出来的对象，直接进行赋值之后的对象实质上为源对象的引用，即指向同一对象
		System.out.println((a1.getClass().hashCode())==(a2.getClass().hashCode()));
		/*
		 * 对于类对象地址的获取方式有三种：
		 */
		//方式1：调用对象.hascode()方法，此方法输出为十进制
		System.out.println((a1.hashCode()));
		//方式2：调用对象.toString()方法，此方法针对自定义类类型，当然前提是类中没有重写该方法，输出为十六进制
		System.out.println(a1.toString());
		//方式3：直接输出类对象,此方法针对自定义类类型，输出为十六进制
		System.out.println(a1);
		
		//对于类中的String类型的name属性
		//查看a1对象的name属性地址
		System.out.println(a1.name.hashCode());
		//对于内置类型，toString方法与直接输出的方式会直接输出数据
		System.out.println(a1.name.toString());
		System.out.println(a1.name);
		
		//三种方式的结果均为true
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		
		System.out.println("------------new 类中基本数据类型数据改变---------------");	
		//改变a2对象的基本数据属性的值，看其与a1对象地址是否会一致
		a2.setVal(34);
		//方式1：调用对象.hascode()方法，此方法输出为十进制
		System.out.println(a1.hashCode()==a2.hashCode());//true
		System.out.println("a1.hashCode()"+a1.hashCode());
		System.out.println("a2.hashCode()"+a2.hashCode());
		
		//方式2：调用对象.toString()方法，当然前提是类中没有重写该方法，输出为十六进制
		/*
		 * 奇怪的是下面四句的执行结果为：
		 * false
		 * true
		 * a1.toString:arrays_java.A@6234b69
		 * a2.toString:arrays_java.A@6234b69
		 * 明明地址相同，但为什么返回结果仍然为false呢？我们深入剖析以下toString这个函数：
		 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 * 这时toString函数的源码，只有这一句，我们要看的是其地址是否相同来判断其是否引用的是同一
		 * 内存空间，实质上它返回的是一个字符串，而对于字符串来说，要比较其内容是否相等，应该用equel()
		 * 方法，==是用来比较字符串的地址是否相等的
		 * 
		 * 
		 */
		
		System.out.println(a1.toString()==a2.toString());//false
		System.out.println(a1.toString().equals(a2.toString()));//true
		System.out.println("a1.toString:"+a1.toString());
		System.out.println("a2.toString:"+a2.toString());
		//方式3：直接输出类对象，输出为十六进制
		System.out.println(a1==a2);
		System.out.println("a1:"+a1);
		System.out.println("a2:"+a2);
		//当a2对象的基本数据类型的属性值改变，a1对象的对应属性也改变了，验证了这两个对象共用一份内存，指向同一地址空间
		System.out.println("a1.val="+a1.getVal());
		
		//返回值为true,表示两个对象还是指向同一份String数据
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		//以下两句，返回值为true
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		
		System.out.println("------------new 类中String数据类型数据改变---------------");
		
		//结果为true,表明是同一内存空间
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		//以下两句，返回值为true
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		System.out.println("a1.name:"+a1.name);
		System.out.println("a2.name:"+a2.name);
		//改变a2对象的name数据属性的值，看其与a1对象地址是否会一致
		a2.setName("doudou");
		//返回值为true,表示两个对象还是指向同一份String数据
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		//以下两句，返回值为true
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		System.out.println("a1.name:"+a1.name);
		System.out.println("a2.name:"+a2.name);
		/*
		 * 通过验证，对于new出来的对象直接进行赋值给另一个对象，表明无论改变哪一个属性，a1和a2对
		 * 象都是指向同一地址空间，无论哪一个改变，另一个也就改变了
		 */
		
		System.out.println("------------判断字符串相等---------------");
		//判断字符串相等
		String s1="hello";
		String s2=new String("hello");
		System.out.println(s1==s2);//结果为false
		
		String s3="hell"+"o";
		System.out.println(s1==s3);//结果为true
		String s4="hell";
		String s5="o";
		String s6=s4+s5;
		System.out.println(s6==s1);//结果为false
		/*
		 * 为什么new之后返回结果为false,而直接赋值给另一字符串常量却返回为true呢？
		 *   在Java中，String是字符串常量,由相同序列的字符组成的两个字符串属于同一对象，对于内存中的
		 * 同一位置，即使这个字符串出现在一个程序的不同位置甚至是一个程序的不同程序包中，也是一样的，
		 * 两个常量字符串直接相加之后，创建了一个新的字符串常量，当然这个工作是在编译期完成的，是能够
		 * 在编译期就确定的；用一个常量表达式将两个字符串常量连接在一起的结果在编译期完成，然而在
		 * String s4="hell";
		 * String s5="o";
		 * String s6=s4+s5;
		 * 这段代码中，s6只能在运行时期才能确定，这三条语句所创建的“hello”字符串作为String对象存
		 * 储在内存中的一个独立位置
		 *   Java提供了一个机制，通过String类定义的intern()方法把一个运行时创建的字符串加到字
		 * 符串常量池，如将上述代码改为String s6=(s4+s5).intern();Java将把s4+s5所返回的
		 * 字符串对象常量池中的字符串进行比较，如果找到一个匹配的，intern()就返回这个字符串的引用。
		 * 如果没有找到匹配的，s4+s5所返回的字符串将被加入到字符串常量池中，并返回这个字符串常量的引用。
		 *
		 */
		System.out.println("------------数组.clone()---------------");
		int myarr1[]={8,9,0,3,4};
		int myarr2[]=myarr1.clone();
		System.out.println("myarr1:clone "+myarr1);
		System.out.println("myarr2:clone "+myarr2);
		System.out.println("myarr:clone "+(myarr1==myarr2));//结果为false
		/*
		 * 由上述结果可得，数组的clone函数为深拷贝，由其源码也可得，因为其函数内部会产生一个临时数组，
		 * 拷贝之后并返回这个临时数组
		 */
		System.out.println("------------类对象.clone()---------------");
		/*
		 * 对于自定义的类对象中，是不能调用clone()函数的，但是类可以实现Cloneable接口，实现之后
		 * 就可以使用clone函数了
		 */
		A a3=null;
		try {
			a3=(A) a1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("a3="+a3.getVal()+" "+a3.getName());
			
			//方式1：调用对象.hascode()方法，此方法输出为十进制
			System.out.println(a1.hashCode()==a3.hashCode());//结果为false
			System.out.println("a1.hashCode()"+a1.hashCode());//a1.hashCode()11549664
			System.out.println("a3.hashCode()"+a3.hashCode());//a3.hashCode()12929374
			//方式2：调用对象.toString()方法，当然前提是类中没有重写该方法，输出为十六进制
			System.out.println(a1.toString()==a3.toString());//结果为false
			System.out.println(a1.toString().equals(a3.toString()));//结果为false
			System.out.println("a1.toString:"+a1.toString());//a1.toString:arrays_java.A@b03be0
			System.out.println("a3.toString:"+a3.toString());//a3.toString:arrays_java.A@c5495e
			//方式3：直接输出类对象，输出为十六进制
			System.out.println("a3:"+a3);//a3:arrays_java.A@c5495e
			System.out.println("a1:"+a1);//a1:arrays_java.A@b03be0
			System.out.println("a3==a1:"+(a3==a1));//结果为false
			/*
			 * 由此可以得出clone函数对于类对象属于深拷贝,既然类对象为深拷贝，那么普通数据类型的属
			 * 性显然也在不同的内存空间，但是对于name属性，其类型比较特殊，我们需要再次验证以下是
			 * 否为深拷贝
			 * 
			 */
			
			System.out.println("-------------类对象.clone()的String类型的属性----------------");
			//返回值为true,表示两个对象还是指向同一份String数据
			System.out.println((a1.name.hashCode())==a3.name.hashCode());
			System.out.println(a1.name.hashCode());
			//以下两句，返回值为true,比较的是值
			System.out.println(a1.name.toString()==a3.name.toString());
			System.out.println(a1.name.toString());
			System.out.println(a1.name==a3.name);
			System.out.println("a1.name:"+a1.name);
			System.out.println("a3.name:"+a3.name);
			
            a3.setName("linana");
			
			//返回值为false,表示两个对象并不是指向同一份String数据，相当于写时拷贝
			System.out.println((a1.name.hashCode())==a3.name.hashCode());
			//以下两句，返回值为true
			System.out.println(a1.name.toString()==a3.name.toString());
			System.out.println(a1.name==a3.name);
			System.out.println("a1.name:"+a1.name);
			System.out.println("a3.name:"+a3.name);
			/*
			 * 通过验证，对于clone出来的对象，两对象指向不同的内存空间，但是如果类中具有像String
			 * 类型的属性时，两个对象的该属性指向同一空间，一旦某一个发生改变，则进行写时拷贝
			 */
		}
		
	}		
}
