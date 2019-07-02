package offer.moreThanHalfNumber_39;

/**
 * Created by Administrator on 2019/6/6.
 * 描述：寻找数组中比数组长度的一半还大的数量的值
 */
public class MoreThanHalfNumber {
    /**
     * 思路：如果有一个数的数量超过数组长度的一半，那也就是说
     * 不同的数字的数量加起来都没有超过一半，一次从这点出发，
     * 保存一个当前值和出现的次数，当有一样的数字时，次数
     * 加1，当有不一样的数字时，数字的次数减1，当次数减到0的
     * 时候，将数字变为当前值，并初始化次数为1.知道最后，如果
     * 有超过数组长度一半的数字就是最后一次次数置为1的那个数字
     * @param numbers
     * @return
     */
    public int moreThanHalfNumber(int[] numbers){
        if(numbers==null || numbers.length<=0){
            return -1;
        }
        int result = numbers[0];
        int times = 1;
        for(int i = 1;i<numbers.length;i++){
            if(times == 0){
                result = numbers[i];
                times = 1;
            }else {
                if (result == numbers[i]) {
                    times++;
                }
                else{
                    times--;
                }
            }

      }
        times = 0;
        //循环遍历，查看该result的次数是否超过一半
        for(int i = 0;i<numbers.length;i++){
          if(result == numbers[i]){
              times++;
          }
        }
        if(times*2<numbers.length){
            result  = -1;
        }
        return result;
    }

    public static void main(String[] argv){
        int[] numbers = new int[]{1,2,3,1,1,4,5,1,1};
        MoreThanHalfNumber obj = new MoreThanHalfNumber();
        int result = obj.moreThanHalfNumber(numbers);
        System.out.println(result);
    }


}
