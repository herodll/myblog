package offer.findNumsAppearOnce_56;

/**
 * Created by Administrator on 2019/6/16.
 * 题目描述：有一个数组，数组中除了两个数出现了一次之外，其余数字都
 * 出现了两次，要求在时间复杂度为o（n）,空间复杂度为O(1)内完成
 * 思想：如果该题不限制空间复杂度，那么就容易多了，跟之前类似，也可以
 * 采用hashmap的方式来保存次数，空间复杂度为o（n），但是此题要求空间复
 * 杂度为o（1）,因此需要重新找思路：
 *
 *
 * 思路如下：
 *    已知数组中有且仅有两个数只出现了一次，而其他数出现了两次，假设数组中
 *    只有一个数出现了一次，那么很简单，将所有数进行异或，得到的最后结果就是
 *    只出现了一次的数字。但是该题有两个数出现了一次，同样我们可以采用异或的
 *    思路，但是最终的仅出现一次的两个数异或的结果肯定非0，并且，最后结果所在的
 *    哪一位为1，就表示这两个数的二进制在该位肯定不一样，因此按照该位不一样，可
 *    以将数组中所有元素分成两组，且每一组有且只有一个出现了一次的数，之后分别将
 *    两组数字按照异或方式运算，便可以得到整个数组中仅出现一次的两个数了。
 *
 */
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int[] data,int[] ret){
         if(data == null || data.length<=2){
             return;
         }
        int numsXor = 0;
        int numof1Xor = 0;
        int numOf0Xor = 0;
        //数组所有元素异或
        for(int i = 0;i<data.length;i++){
            numsXor ^= data[i];
        }
        //找到所有元素异或后结果的1的位置
        int bitIndex = findBitIndexOf1(numsXor);
        //每一元素判断对应位是不是1
        for(int i = 0;i<data.length;i++){
            if(isBitOf1(data[i],bitIndex)){
                numof1Xor ^= data[i];
            }
            else{
                numOf0Xor ^= data[i];
            }
        }
        //结果集
        ret[0] = numof1Xor;
        ret[1] = numOf0Xor;
    }

    public int findBitIndexOf1(int numsXor){
        int indexBit = 0;
        while((numsXor & 1) == 0 && (indexBit<32)){
            indexBit++;
            numsXor = numsXor>>1;
        }
        return indexBit;
    }
    public boolean isBitOf1(int num,int bitIndex){
            num=num>>bitIndex;
            return (num&1)==1?true:false;
    }

    public static void main(String[] argv){
        int data[] = new int[]{1,2,3,4,5,6,5,4,2,1};
        int ret[] = new int[2];
        FindNumsAppearOnce obj = new FindNumsAppearOnce();
        obj.findNumsAppearOnce(data,ret);
        System.out.println("the nums appear once are:"+ret[0]+"  "+ret[1]);
    }

}
