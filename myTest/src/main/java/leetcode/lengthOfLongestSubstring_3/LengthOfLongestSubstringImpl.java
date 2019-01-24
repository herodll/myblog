package leetcode.lengthOfLongestSubstring_3;

import java.util.HashMap;
import java.util.Map;

/**
 * author:herodou
 * date:2018/12/02 21:37
 *
 * 问题描述：最长不重复子串，返回最长不重复子串的长度
 */

public class LengthOfLongestSubstringImpl {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
       /* int[] len = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            len[i] = 1;
        }*/
        /*int i = 0;
        int j = 1;*/
        //没有考虑区间之内，后面的是否相等，比如caba,应当是3，而非4
        /*while(j<s.length()){
            if(s.charAt(i) != s.charAt(j)){
                len[i] += 1;
                j++;
            }else{
                i++;
                j = i+1;
            }
        }
        for(int k = 0;k<s.length();k++){
            System.out.println(len[k]);
        }
        return 1;*/
        /**
          方法1：用maxLen来记录当前最长不重复子串，用start来记录最长不重复子串的开始位置，
                用map的键来保存字符串中的字符，值保存的是当前字符对应的下标位置。从头开始
                遍历字符串，如果当前字符在map中包含，并且当前的最长不重复子串的开始位置小于
                等于map中该字符的下标位置（值），那就说明当前不重复子串的起始位置位于在上次
                出现的当前字符的左边，那么应该将开始位置置于上次出现的当前字符的后面一个位置，
                以供后续判断是否比之前的最长不重复子串更长，这是一个标志重新判断一个子串的开
                始位置，之后需要将map中的对应字符的值更新为i;如果当前字符不在map中包含，那
                么就说明从start位置到当前位置没有重复，那就比较取得当前最长不重复子串长度和
                从start到当前位置的子串长度的最大值作为新的当前最长不重复子串,之后将该字符添加
                到map中。
         */
        /*方法1代码
        int maxLen = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))){
                start = map.get(s.charAt(i))+1;
            }else{
                maxLen = Math.max(maxLen,i-start+1);
            }
            map.put(s.charAt(i),i);
        }
        //System.out.println(s.substring(start,start+maxLen));
        return maxLen;
        */
        /**
         * 方法2：用i和j来分别表示当前不重复子串的头和尾，当子串的头和尾之间没有重复字符的时候，j++,也就是尾指针后移，
         *       当子串的头和尾之间有重复字符时，i++,也就是头指针后移。
         */
        return 0;
    }
}
