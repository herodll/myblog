package arrays_java;

import java.util.Arrays;
import java.util.Iterator;

/*
 * һ��System.arraycopy(src,srcpos,des,despos)
 *   1.System.arraycopy����ʵ���Լ����Լ��Ŀ����������ǣ��ȴ���һ����ʱ�������ڴ��despos�±꿪ʼ
 * ��src.length-1�±�����ݣ��ٽ��п�����
 *   2.�޷���ֵ���÷���Ϊstatic native����
 *   3.�޷��������ݲ���
 * ����Arrays.copyOf(src,newlength)
 *   1.�ڸ�������ʱ�᷵��һ�������飬�ڶ���������������Ĵ�С���ﵽ��ν���ݵ�Ч��
 *   2.�����ڲ����ڴ���һ���µĳ��ȵ����飬���������ջᱻ���أ��ٵ���System.arraycopy(src,srcpos,des,despos)
 *     ���������к������ĸ�������Դ�����С���³��ȵ���Сֵ
 * �����������.clone()
 *   1.������������һ����������һ������new�������ƣ�
 *     a. new������ȥ��new������֮������ͣ�֪�������Ͳ�֪��Ҫ������ռ䣬�����ڴ�֮���ٵ��ù���
 *        ������������ĸ��������Ϊ��ʼ���������췽������ʱ������������󴴽���ϡ�
 *     b. clone�����ڵ�һ����new��ͬ�����Ƿ����ڴ棬����clone()����ʱ��������ڴ��Դ����(������
 *        ����clone�����Ķ���)��ͬ(����Ҳ������ν������)��Ȼ����ʹ��Դ�����ж�Ӧ�ĸ���������¶���
 *        ����������֮��clone�������أ�һ���µ���ͬ�Ķ��󱻴���������¶�������þͿ��Ա��ⲿ��
 *        ���ط�ʹ�á�
 *   2.�׿����鸳ֵ�ĸ������new��clone�����Ŀ����������ǽ��ڸð��µ�deepOrSallowCopy������
 */
public class arrays_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�����ʼ����ʽ��
	    //��ʽ1��forѭ����һ��ֵ
		int src[]=new int[5];
		int des1[]=new int[20];
		for(int i=0;i<src.length;++i){
			src[i]=i;
		}
		//��ʽ2��ֱ����newʱ���г�ʼ��
		int des2[]=new int[]{1,2,3,4,5};
	    //��ʽ3��ֱ�Ӹ�ֵ
		int des3[]={10,9,8,7,6,5,4};
       /*
        *  Arrays�ľ�̬����������
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
		
		//�������鿽�������ַ�ʽ��
		//��ʽ1��forѭ����һ����
		for(int i=0;i<src.length;++i){
			des2[i]=src[i];
		}
		
		//��ʽ2������System.arraycopy����
		System.arraycopy(src,0, des1, 0, src.length);
		//System.arraycopy(src,0, des1, 0, src.length+1);�˾���׳�����Խ���쳣
		for(int i=0;i<des1.length;++i){
			System.out.println("System.arraycopy:des1="+des1[i]);
		}
		
		//��ʽ3������Arrays�ľ�̬����copyOf(src,length)
		/*
		 * �˷����п����ݣ���Ϊdes3.length=7,��src�����鳤����5�����ǻ��ǿ��������ĸ�ֵ7������
		 * �����������ݻ��ƣ��Լ������������������������������������ϸ��������
		 */
		src=Arrays.copyOf(des3, des3.length);
		for(int it:src){
			System.out.println("Arrays.copyOf:src="+it);
		}
		//�������������Ϊ7�������ÿ��������ɽ�������
		System.out.println("Arrays.copyOf:src.length="+src.length);
		
	    //��ʽ4������Arrays�ľ�̬����copyOfRange(src, from,to)
		des2=Arrays.copyOfRange(src, 0,src.length);
		for(int it:src){
			System.out.println("Arrays.copyOfRange:des2="+it);
		}
		//�������������Ϊ7�������ÿ�������Ҳ�ɽ�������
		System.out.println("Arrays.copyOfRange:des2.length="+des2.length);
		
		//��ʽ5����������������clone()����
		int[] des4=new int[5];
		des4=src.clone();
		for(int it:src){
			System.out.println("src.clone:des4="+it);
		}
		//�������������Ϊ7�������ÿ�������Ҳ�ɽ�������
		System.out.println("src.clone:des4.length="+des4.length);
		
		/*
		 * �ַ�������ת��Ϊ����
		 */
		//�ַ�������ת��Ϊ�ַ������ã�����.toCharArray()
		String str1="hello";
		char[] strarr1=str1.toCharArray();
		System.out.print("str1.toCharArray:");
		for(char a:strarr1){
			System.out.print(a+" ");
		}
		Arrays.sort(strarr1);
		System.out.println();
		
		/*
		 * ����ת��Ϊ�ַ���:����String.valueOf(123456)
		 */
		
		//��ʽ1������String.valueOf(int val)
		String myinttostr=String.valueOf(123456);
		System.out.println("String.valueOf:"+myinttostr);
		//��ʽ2������Integer.toString(int val)
		int val=12345;
		String myinttostr1=Integer.toString(val);
		System.out.println("Integer.toString:"+myinttostr1);
		
		/*
		 * �ַ���ת��Ϊ���������ַ�ʽ
		 */
		//��ʽ1����Integer.valueOf("345").intValue();
		//Integer.valueOf("345")���ص���һ��Integer������Ҫ������в������
		int myint1=Integer.valueOf("345").intValue();
		System.out.println("Integer.valueOf:"+myint1);
		//��ʽ2����Integer.parseInt("789")
		int myint2=Integer.parseInt("789");
		System.out.println("Integer.parseInt:"+myint2);
		
	}

}
