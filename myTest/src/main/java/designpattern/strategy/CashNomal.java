package designpattern.strategy;

/**
 * Created by Administrator on 2018/5/31.
 */
public class CashNomal extends Strategy {
    @Override
    public double acceptCash(double money) {
        return  money;
    }
}
