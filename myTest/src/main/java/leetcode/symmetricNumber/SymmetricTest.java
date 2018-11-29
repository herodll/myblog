package leetcode.symmetricNumber;

import java.util.Scanner;

public class SymmetricTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res = new symmetricNumberImpl().isPalindrome(in.nextInt());
        System.out.println("the number's result is "+res);

    }
}
