package leetcode.LongestPalindromicSubstring_5;

public class LongestPalindromicSubstringTest {
    public static void main(String[] args) {
        String s= "bacabcd";
        String sub = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(sub);
    }
}
