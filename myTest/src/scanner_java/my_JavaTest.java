package scanner_java;

import java.util.Scanner;
/*
 * 对于in.next():它从第一个非分割字符开始扫描，忽略分隔符，光标停留在本行
 * 对于in.nextLine():它以回车符作为分割符
 * 导致的问题：
 * 所以如果先用in.next()，再用in.nextLine()就会导致第二行无法输入，是因为在输入了第一行之后，
 * 光标在第一行回车处，导致nextLine()再读时，遇到回车，直接读入，因此第二行无法读入
 * 解决方案：在in.next()，再用in.nextLine()来接收回车符。
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
