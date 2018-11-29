package leetcode.aLaBoCovertNum;


import com.google.common.collect.ImmutableMap;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

//import static leetcode.aLaBoCovertNum.ALaBoConstant.MAP_CONSTANT;

/*class ALaBoConstant {
    public static final Character ONE = ('I');
    public static final Character FIVE = ('V');
    public static final Character TEN = 'X';
    public static final Character FIFTY = 'L';
    public static final Character HUNDRAND = 'C';
    public static final Character FIVE_HUNDRAND = 'D';
    public static final Character THOUSAND  = 'M';

    public static final Map<Character,Integer>  MAP_CONSTANT = ImmutableMap .<Character,Integer>builder()
            .put(ONE,1)
            .put(FIVE,5)
            .put(TEN,10)
            .put(FIFTY,50)
            .put(HUNDRAND,100)
            .put(FIVE_HUNDRAND,500)
            .put(THOUSAND,1000)
            .build();

}*/
public class ALaBoCovertNum{
    public int romanToInt(String s) {
        //构造一个map来保存阿拉伯数字和正常数字之间的对应关系
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //定义结果，初始化为0  MCMXCIV
        int sum = 0;
        //遍历每一个字符
        for(int i = 0;i<s.length();){
            Character ch = s.charAt(i);
            //判断是否包含对应map中的字符
            if(map.keySet().contains(ch)){
                //判断如果是IV或者IX，则表示的数字为后者减去前者的值，而不是加的值，此为特殊情况，需单独处理
                if(ch == 'I' && i<s.length()-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    //System.out.println(map.get(s.charAt(i+1))-map.get(ch));
                    sum += map.get(s.charAt(i+1))-map.get(ch);
                    i += 2;
                    continue;
                }
                //判断如果是XL或者XC，则表示的数字为后者减去前者的值，而不是加的值，此为特殊情况，需单独处理
                if(ch == 'X' && i<s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    sum += map.get(s.charAt(i+1))-map.get(ch);
                    i += 2;
                    continue;
                }
                //判断如果是CD或者CM，则表示的数字为后者减去前者的值，而不是加的值，此为特殊情况，需单独处理
                if(ch == 'C' && i<s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                   // System.out.println(map.get(s.charAt(i+1))-map.get(ch));
                    sum += map.get(s.charAt(i+1))-map.get(ch);
                    i += 2;
                    continue;
                }
                //其余情况，均按正常相加即可
                else {
                   // System.out.println(map.get(s.charAt(i)));
                    sum += map.get(s.charAt(i));
                    i++;
                }
            }
        }
        return sum;
        /*int sum = 0;
         for(int i = 0;i<s.length();i++){
             if(MAP_CONSTANT.keySet().contains(s.charAt(i))){
                 sum += MAP_CONSTANT.get(s.charAt(i));
             }
         }
         return sum;*/
    }
}
