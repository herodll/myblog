package leetcode.validParentheses;

public class ValidParenthesesTest {
    public static void main(String[] args) {
        String s = "((([[[]])))";
        boolean ret = new ValidParentheses_20().isValid(s);
        System.out.println(s+"'s result:"+ret);
    }

            
}
