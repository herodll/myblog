package scanner_java;

import java.util.Scanner;
/*
 * ����in.next():���ӵ�һ���Ƿָ��ַ���ʼɨ�裬���Էָ��������ͣ���ڱ���
 * ����in.nextLine():���Իس�����Ϊ�ָ��
 * ���µ����⣺
 * �����������in.next()������in.nextLine()�ͻᵼ�µڶ����޷����룬����Ϊ�������˵�һ��֮��
 * ����ڵ�һ�лس���������nextLine()�ٶ�ʱ�������س���ֱ�Ӷ��룬��˵ڶ����޷�����
 * �����������in.next()������in.nextLine()�����ջس�����
 */
public class my_JavaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s1,s2;
      Scanner in=new Scanner(System.in);
      System.out.print("please input s1:");
      s1=in.next();
      //in.nextLine();
      System.out.print("please input s2:");
      s2=in.next();
      System.out.print("input string is:"+s1+" "+s2);
      
      
	}

}
