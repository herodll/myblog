package leetcode.lengthOfLongestSubstring_3;

public class LengthOfLongestSubstringTest {
    public static void main(String[] args) {
        String s1 = "abcabcabcda";
        String s = "pwwkew";
        int ret = new LengthOfLongestSubstringImpl().lengthOfLongestSubstring(s);
        System.out.println(ret);
    }
}
