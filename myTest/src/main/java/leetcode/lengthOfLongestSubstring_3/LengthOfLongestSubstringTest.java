package leetcode.lengthOfLongestSubstring_3;

public class LengthOfLongestSubstringTest {
    public static void main(String[] args) {
        String s = "abcabcabcda";
        int ret = new LengthOfLongestSubstringImpl().lengthOfLongestSubstring(s);
        System.out.println(ret);
    }
}
