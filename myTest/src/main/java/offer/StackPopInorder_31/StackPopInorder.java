package offer.StackPopInorder_31;

import java.util.Stack;

/**
 * Created by Administrator on 2019/6/4.
 */
public class StackPopInorder {
    public boolean isPopInorder(int [] pPop,int [] pPush){
        int length = pPop.length;
        //用来记录当前pPop中的位置
        int popIndex = 0;
        //用来记录当前pPush中的位置
        int pushIndex = 0;
        //结果
        boolean isPossible = false;
        //辅助栈
        Stack<Integer> s = new Stack<>();
        if(pPop!=null && pPush != null && length >0){
            //当pPop中的位置还没有遍历到最后，就需要进行判断弹出工作
            while(popIndex<length){
                //如果栈空或者当前栈顶元素与当前位置的要pop的元素不相等，就需要进行push工作
                while(s.isEmpty() || s.peek()!=pPop[popIndex]){
                    //进行push工作之前，需要先判断是否还有元素可以入栈，如果已经到尾，那么跳出本层循环
                    if(pushIndex==length){
                        break;
                    }
                    //说明需要进行正常push，直到将pop的元素push进栈，等下一次循环条件不符，跳出
                    s.push(pPush[pushIndex]);
                    pushIndex++;
                }
                //判断栈顶元素是否与当前位置的要pop的元素相同
                if(s.peek()!=pPop[popIndex]){
                    break;
                }
                //栈顶元素与要pop的元素匹配上，出栈，之后，pop元素进入下一个
                s.pop();
                popIndex++;
            }
            //循环结束之后，如果栈空并且要pop的元素已经全部遍历弹出，那么入栈和出栈顺利匹配
            if(s.isEmpty()&&popIndex==length){
                isPossible  = true;
            }
        }
        return isPossible;
    }

    public static void main(String[] argv){
        int[] pPop = {4,3,5,1,2};
        int[] pPush  = {1,2,3,4,5};
        StackPopInorder obj = new StackPopInorder();
        boolean res = obj.isPopInorder(pPop,pPush);
        System.out.println(res);
    }


}
