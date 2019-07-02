package offer.LastRemainingCircle_62;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019/6/16.
 * 问题描述：约瑟夫环问题：由N个数字构成的圆圈，从数字0开始，每次从这个圆圈
 * 中删除第m个数字，求这个圈中最后剩下的那个数字
 * 方法1：用环形链表模拟圆圈
 * 构建环形链表
 * (代码有问题)
 */
public class LastRemaining_62 {
    int lastRemaining(int n,int m){
        if(n<1 || m<1){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int removeIndex = 0;
        int cur = 0;
        while(list.size()>1){
            for(int i=1;i<m;i++){
                cur++;
                if(cur==list.size()){
                    cur = 0;
                }
            }
            /*removeIndex = ++cur;
            if(removeIndex == list.size()){
                removeIndex = 0;
            }
            --cur;*/
            list.remove(cur);

        }
        return list.get(0);
    }
    public static void main(String[] argv){
        LastRemaining_62 obj = new LastRemaining_62();
        int ret = obj.lastRemaining(5,3);
        System.out.print(ret);
    }

}
