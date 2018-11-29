package leetcode.aLaBoCovertNum;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static leetcode.aLaBoCovertNum.ALaBoConstant.MAP_CONSTANT;

class ALaBoConstant {
    public static final Character ONE = 'I';
    public static final Character FIVE = 'V';
    public static final Character TEN = 'X';
    public static final Character FIFTY = 'L';
    public static final Character HUNDRAND = 'C';
    public static final Character FIVE_HUNDRAND = 'D';
    public static final Character THOUSAND  = 'M';

    public static final Map<Character,Integer> MAP_CONSTANT = ImmutableMap.<Character,Integer>builder()
            .put(ONE,1)
            .put(FIVE,5)
            .put(TEN,10)
            .put(FIFTY,50)
            .put(HUNDRAND,100)
            .put(FIVE_HUNDRAND,500)
            .put(THOUSAND,1000)
            .build();

}
public class ALaBoCoverNum2 {
    public int romanToInt(String s) {
        int sum = 0;

         for(int i = 0;i<s.length();){
             Character ch = s.charAt(i);
             if(MAP_CONSTANT.keySet().contains(s.charAt(i))){
                 //判断如果是IV或者IX，则表示的数字为后者减去前者的值，而不是加的值，此为特殊情况，需单独处理
                 if(ch == 'I' && i<s.length()-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                     //System.out.println(map.get(s.charAt(i+1))-map.get(ch));
                     sum += MAP_CONSTANT.get(s.charAt(i+1))-MAP_CONSTANT.get(ch);
                     i += 2;
                     continue;
                 }
                 //判断如果是XL或者XC，则表示的数字为后者减去前者的值，而不是加的值，此为特殊情况，需单独处理
                 if(ch == 'X' && i<s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                     sum += MAP_CONSTANT.get(s.charAt(i+1))-MAP_CONSTANT.get(ch);
                     i += 2;
                     continue;
                 }
                 //判断如果是CD或者CM，则表示的数字为后者减去前者的值，而不是加的值，此为特殊情况，需单独处理
                 if(ch == 'C' && i<s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                     // System.out.println(map.get(s.charAt(i+1))-map.get(ch));
                     sum += MAP_CONSTANT.get(s.charAt(i+1))-MAP_CONSTANT.get(ch);
                     i += 2;
                     continue;
                 }
                 else {
                     sum += MAP_CONSTANT.get(s.charAt(i));
                     i++;
                 }
             }
         }
         return sum;
    }
}
