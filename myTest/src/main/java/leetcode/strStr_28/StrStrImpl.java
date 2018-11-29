package leetcode.strStr_28;
//需要在pom文件中添加common-lang的maven依赖包
import org.apache.commons.lang.StringUtils;

/**
 *author:herodou
 * date:2018/11/29 17:30
 *
 * 问题描述：在所给参数haystack中查找子串needle，当没有找到时返回-1.否则返回下标
 * 在LeetCode的题目中，要求当参数传递的是空字符串时，返回0，而非-1.因此我们不能用StringUtils这个类来判断字符串是否为空，
 * 而应该采用传统的方式来判null
 */
public class StrStrImpl {
    public int strStr(String haystack, String needle) {
        if(StringUtils.isEmpty(haystack) || StringUtils.isEmpty(needle)){
            return -1;
        }
        //用i来表示源字符串的索引，j来表示子串的索引
        int i = 0;
        int j = 0;
        //注意条件为且，主要考虑当子串在源串非末尾位置的情况
        while(i < haystack.length() && j < needle.length()){
            //如果两个字符不相同，那么将子串索引调整至开头，将源串索引调整至i-j+1的位置处
            if(haystack.charAt(i) != needle.charAt(j)){
                i = i-j+1;
                j = 0;
            }else{
                //当两个字符相同时，那么两个索引都向后移
                i++;
                j++;
            }
        }
        //循环结束，当子串当前已走完，说明存在子串，计算返回在源串中的位置，否则返回-1
        if(j == needle.length()){
            return i-j;
        }else{
            return -1;
        }
    }
}
