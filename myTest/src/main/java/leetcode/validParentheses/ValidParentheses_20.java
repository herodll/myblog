package leetcode.validParentheses;

import java.util.Stack;

/**
 * 问题描述：匹配括号是否对应匹配
 * 解决此问题的一般方式就是采用栈+if-else语句来完成
 */

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //判断参数的合法性
        if(s == null){
            return false;
        }
        //遍历字符串的每个字符
        for(int i = 0;i<s.length();++i){
            //获取当前字符
            Character ch = s.charAt(i);
            //如果当前字符为左括号，那么就压入栈中
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                //当前字符为右括号，值得注意的是，在该题目中所有输入没有其他特殊字符，因此无需判断，若没有此前提，需要判断是否为右括号；
                //如果当前字符为右括号，但是栈为空，那么说明不匹配，直接返回
                if(stack.empty()){
                    return false;
                }
                //获取栈顶元素
                Character top = stack.peek();
                //判断栈顶元素与当前元素是否匹配，若匹配，那么就将栈顶元素弹出，否则，不匹配，直接返回
                if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        //字符串遍历完成之后，判断栈是否为空，为空表明匹配，否则不匹配
        if(stack.empty()){
            return true;
        }
        return false;
    }
}



