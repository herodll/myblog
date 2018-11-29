package leetcode.longestCommonPrefix;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：找出给定参数的多个字符串的公共前缀

 */

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {


        StringBuilder str = new StringBuilder();

        //排除参数为空的情况
        if(strs == null || strs.length <= 0){
            return "";
        }

        //得到所有字符串中长度最短的字符串长度
        int len = strs[0].length();
        for(int i = 0;i<strs.length-1;i++){
            if(len > strs[i+1].length()){
                len  = strs[i+1].length();
            }

        }
        //按照下标遍历所有的字符串
        for(int i = 0;i<len;i++){
            for(int j = 0;j<strs.length-1;j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    return str.toString();
                }
            }
            str.append(strs[0].charAt(i));
        }
        return str.toString();
    }

}
