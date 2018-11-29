package leetcode.reverseNumber;

import java.util.Scanner;

public class ReverseTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int res = new ReverseNumber().reverse(num);
        System.out.println(num+" µÄÄæĞòÎª£º"+res);
    }
}
