package offer.firstNotRepeat_50;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/13.
 * 问题描述：第一个只出现一次的字符
 * 思路：可以采用哈希表，以字符作为键，以次数作为值，遍历两次字符串便可以解决
 */
public class FirstNotRepeat {
    public Character firstNotRepeat(String s){
        if(s==null || s.length()<=0){
            return null;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        //输出map
        /*for (Character key:map.keySet()) {
            System.out.println(key+" "+map.get(key));
        }*/
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] argv){
        FirstNotRepeat obj = new FirstNotRepeat();
        String s = "google is a big company";
        Character ret = obj.firstNotRepeat(s);
        System.out.println(ret);
    }
}
