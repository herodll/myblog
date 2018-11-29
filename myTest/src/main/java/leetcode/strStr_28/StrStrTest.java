package leetcode.strStr_28;

public class StrStrTest {
    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        int ret  = new StrStrImpl().strStr(haystack,needle);
        System.out.println(needle+" in "+haystack+" index is "+ret);
    }
}
