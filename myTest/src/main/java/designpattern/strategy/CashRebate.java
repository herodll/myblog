package designpattern.strategy;

/**
 * Created by Administrator on 2018/5/31.
 */
public class CashRebate extends Strategy {
    private double moneyRate = 1;
    public CashRebate(){}
    public CashRebate(double rate){
        this.moneyRate = rate;
    }
    @Override
    public double acceptCash(double money) {
        return money*this.moneyRate;
    }
}
