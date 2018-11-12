package arrays_java;

/*
 * ������������clone��new���orǳ��������
 */
class A implements Cloneable{
	
	public int val;
	public String name;
	
	//���캯��
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
		System.out.println("-----------new��������----------------");
		A a1=new A(23,"lili");
		A a2=a1;
		//�˾䷵��ֵΪtrue,��������new�����Ķ���ֱ�ӽ��и�ֵ֮��Ķ���ʵ����ΪԴ��������ã���ָ��ͬһ����
		System.out.println((a1.getClass().hashCode())==(a2.getClass().hashCode()));
		/*
		 * ����������ַ�Ļ�ȡ��ʽ�����֣�
		 */
		//��ʽ1�����ö���.hascode()�������˷������Ϊʮ����
		System.out.println((a1.hashCode()));
		//��ʽ2�����ö���.toString()�������˷�������Զ��������ͣ���Ȼǰ��������û����д�÷��������Ϊʮ������
		System.out.println(a1.toString());
		//��ʽ3��ֱ����������,�˷�������Զ��������ͣ����Ϊʮ������
		System.out.println(a1);
		
		//�������е�String���͵�name����
		//�鿴a1�����name���Ե�ַ
		System.out.println(a1.name.hashCode());
		//�����������ͣ�toString������ֱ������ķ�ʽ��ֱ���������
		System.out.println(a1.name.toString());
		System.out.println(a1.name);
		
		//���ַ�ʽ�Ľ����Ϊtrue
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		
		System.out.println("------------new ���л��������������ݸı�---------------");	
		//�ı�a2����Ļ����������Ե�ֵ��������a1�����ַ�Ƿ��һ��
		a2.setVal(34);
		//��ʽ1�����ö���.hascode()�������˷������Ϊʮ����
		System.out.println(a1.hashCode()==a2.hashCode());//true
		System.out.println("a1.hashCode()"+a1.hashCode());
		System.out.println("a2.hashCode()"+a2.hashCode());
		
		//��ʽ2�����ö���.toString()��������Ȼǰ��������û����д�÷��������Ϊʮ������
		/*
		 * ��ֵ��������ľ��ִ�н��Ϊ��
		 * false
		 * true
		 * a1.toString:arrays_java.A@6234b69
		 * a2.toString:arrays_java.A@6234b69
		 * ������ַ��ͬ����Ϊʲô���ؽ����ȻΪfalse�أ�����������������toString���������
		 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 * ��ʱtoString������Դ�룬ֻ����һ�䣬����Ҫ���������ַ�Ƿ���ͬ���ж����Ƿ����õ���ͬһ
		 * �ڴ�ռ䣬ʵ���������ص���һ���ַ������������ַ�����˵��Ҫ�Ƚ��������Ƿ���ȣ�Ӧ����equel()
		 * ������==�������Ƚ��ַ����ĵ�ַ�Ƿ���ȵ�
		 * 
		 * 
		 */
		
		System.out.println(a1.toString()==a2.toString());//false
		System.out.println(a1.toString().equals(a2.toString()));//true
		System.out.println("a1.toString:"+a1.toString());
		System.out.println("a2.toString:"+a2.toString());
		//��ʽ3��ֱ�������������Ϊʮ������
		System.out.println(a1==a2);
		System.out.println("a1:"+a1);
		System.out.println("a2:"+a2);
		//��a2����Ļ����������͵�����ֵ�ı䣬a1����Ķ�Ӧ����Ҳ�ı��ˣ���֤��������������һ���ڴ棬ָ��ͬһ��ַ�ռ�
		System.out.println("a1.val="+a1.getVal());
		
		//����ֵΪtrue,��ʾ����������ָ��ͬһ��String����
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		//�������䣬����ֵΪtrue
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		
		System.out.println("------------new ����String�����������ݸı�---------------");
		
		//���Ϊtrue,������ͬһ�ڴ�ռ�
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		//�������䣬����ֵΪtrue
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		System.out.println("a1.name:"+a1.name);
		System.out.println("a2.name:"+a2.name);
		//�ı�a2�����name�������Ե�ֵ��������a1�����ַ�Ƿ��һ��
		a2.setName("doudou");
		//����ֵΪtrue,��ʾ����������ָ��ͬһ��String����
		System.out.println((a1.name.hashCode())==a2.name.hashCode());
		//�������䣬����ֵΪtrue
		System.out.println(a1.name.toString()==a2.name.toString());
		System.out.println(a1.name==a2.name);
		System.out.println("a1.name:"+a1.name);
		System.out.println("a2.name:"+a2.name);
		/*
		 * ͨ����֤������new�����Ķ���ֱ�ӽ��и�ֵ����һ�����󣬱������۸ı���һ�����ԣ�a1��a2��
		 * ����ָ��ͬһ��ַ�ռ䣬������һ���ı䣬��һ��Ҳ�͸ı���
		 */
		
		System.out.println("------------�ж��ַ������---------------");
		//�ж��ַ������
		String s1="hello";
		String s2=new String("hello");
		System.out.println(s1==s2);//���Ϊfalse
		
		String s3="hell"+"o";
		System.out.println(s1==s3);//���Ϊtrue
		String s4="hell";
		String s5="o";
		String s6=s4+s5;
		System.out.println(s6==s1);//���Ϊfalse
		/*
		 * Ϊʲônew֮�󷵻ؽ��Ϊfalse,��ֱ�Ӹ�ֵ����һ�ַ�������ȴ����Ϊtrue�أ�
		 *   ��Java�У�String���ַ�������,����ͬ���е��ַ���ɵ������ַ�������ͬһ���󣬶����ڴ��е�
		 * ͬһλ�ã���ʹ����ַ���������һ������Ĳ�ͬλ��������һ������Ĳ�ͬ������У�Ҳ��һ���ģ�
		 * ���������ַ���ֱ�����֮�󣬴�����һ���µ��ַ�����������Ȼ����������ڱ�������ɵģ����ܹ�
		 * �ڱ����ھ�ȷ���ģ���һ���������ʽ�������ַ�������������һ��Ľ���ڱ�������ɣ�Ȼ����
		 * String s4="hell";
		 * String s5="o";
		 * String s6=s4+s5;
		 * ��δ����У�s6ֻ��������ʱ�ڲ���ȷ��������������������ġ�hello���ַ�����ΪString�����
		 * �����ڴ��е�һ������λ��
		 *   Java�ṩ��һ�����ƣ�ͨ��String�ඨ���intern()������һ������ʱ�������ַ����ӵ���
		 * ���������أ��罫���������ΪString s6=(s4+s5).intern();Java����s4+s5�����ص�
		 * �ַ������������е��ַ������бȽϣ�����ҵ�һ��ƥ��ģ�intern()�ͷ�������ַ��������á�
		 * ���û���ҵ�ƥ��ģ�s4+s5�����ص��ַ����������뵽�ַ����������У�����������ַ������������á�
		 *
		 */
		System.out.println("------------����.clone()---------------");
		int myarr1[]={8,9,0,3,4};
		int myarr2[]=myarr1.clone();
		System.out.println("myarr1:clone "+myarr1);
		System.out.println("myarr2:clone "+myarr2);
		System.out.println("myarr:clone "+(myarr1==myarr2));//���Ϊfalse
		/*
		 * ����������ɵã������clone����Ϊ���������Դ��Ҳ�ɵã���Ϊ�亯���ڲ������һ����ʱ���飬
		 * ����֮�󲢷��������ʱ����
		 */
		System.out.println("------------�����.clone()---------------");
		/*
		 * �����Զ����������У��ǲ��ܵ���clone()�����ģ����������ʵ��Cloneable�ӿڣ�ʵ��֮��
		 * �Ϳ���ʹ��clone������
		 */
		A a3=null;
		try {
			a3=(A) a1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("a3="+a3.getVal()+" "+a3.getName());
			
			//��ʽ1�����ö���.hascode()�������˷������Ϊʮ����
			System.out.println(a1.hashCode()==a3.hashCode());//���Ϊfalse
			System.out.println("a1.hashCode()"+a1.hashCode());//a1.hashCode()11549664
			System.out.println("a3.hashCode()"+a3.hashCode());//a3.hashCode()12929374
			//��ʽ2�����ö���.toString()��������Ȼǰ��������û����д�÷��������Ϊʮ������
			System.out.println(a1.toString()==a3.toString());//���Ϊfalse
			System.out.println(a1.toString().equals(a3.toString()));//���Ϊfalse
			System.out.println("a1.toString:"+a1.toString());//a1.toString:arrays_java.A@b03be0
			System.out.println("a3.toString:"+a3.toString());//a3.toString:arrays_java.A@c5495e
			//��ʽ3��ֱ�������������Ϊʮ������
			System.out.println("a3:"+a3);//a3:arrays_java.A@c5495e
			System.out.println("a1:"+a1);//a1:arrays_java.A@b03be0
			System.out.println("a3==a1:"+(a3==a1));//���Ϊfalse
			/*
			 * �ɴ˿��Եó�clone��������������������,��Ȼ�����Ϊ�������ô��ͨ�������͵���
			 * ����ȻҲ�ڲ�ͬ���ڴ�ռ䣬���Ƕ���name���ԣ������ͱȽ����⣬������Ҫ�ٴ���֤������
			 * ��Ϊ���
			 * 
			 */
			
			System.out.println("-------------�����.clone()��String���͵�����----------------");
			//����ֵΪtrue,��ʾ����������ָ��ͬһ��String����
			System.out.println((a1.name.hashCode())==a3.name.hashCode());
			System.out.println(a1.name.hashCode());
			//�������䣬����ֵΪtrue,�Ƚϵ���ֵ
			System.out.println(a1.name.toString()==a3.name.toString());
			System.out.println(a1.name.toString());
			System.out.println(a1.name==a3.name);
			System.out.println("a1.name:"+a1.name);
			System.out.println("a3.name:"+a3.name);
			
            a3.setName("linana");
			
			//����ֵΪfalse,��ʾ�������󲢲���ָ��ͬһ��String���ݣ��൱��дʱ����
			System.out.println((a1.name.hashCode())==a3.name.hashCode());
			//�������䣬����ֵΪtrue
			System.out.println(a1.name.toString()==a3.name.toString());
			System.out.println(a1.name==a3.name);
			System.out.println("a1.name:"+a1.name);
			System.out.println("a3.name:"+a3.name);
			/*
			 * ͨ����֤������clone�����Ķ���������ָ��ͬ���ڴ�ռ䣬����������о�����String
			 * ���͵�����ʱ����������ĸ�����ָ��ͬһ�ռ䣬һ��ĳһ�������ı䣬�����дʱ����
			 */
		}
		
	}		
}
