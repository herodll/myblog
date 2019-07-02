package offer.LastRemainingCircle_62;

/**
 * Created by Administrator on 2019/6/17.
 * 问题描述：还是圆圈淘汰的约瑟夫环问题，根据题意，找出删除数字的规律
 * 当n=1时，f(n,m) = 0;
 * 当n>1时，f(n,m) = (f(n-1,m)+m)%n
 *
 */
public class LastRemainning {
    public int lastRemainningByCircle(int n,int m){
        if(n<1 || m<1){
            return -1;
        }
        int last = 0;
        for(int i = 2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }
    public static void main(String[] argv){
        LastRemainning obj  = new LastRemainning();
        int ret = obj.lastRemainningByCircle(5,3);
        System.out.println(ret);
    }


}
