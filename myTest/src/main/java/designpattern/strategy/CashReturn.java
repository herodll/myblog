package designpattern.strategy;

/**
 * Created by Administrator on 2018/5/31.
 */
public class CashReturn extends  Strategy {
    private double moneyCondition ;
    private double moneyReturn ;
    public CashReturn(){
        this.moneyCondition = 0;
        this.moneyReturn = 0;
    }

    public CashReturn(double moneyCondition, double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    public double getMoneyCondition() {
        return moneyCondition;
    }

    public void setMoneyCondition(double moneyCondition) {
        this.moneyCondition = moneyCondition;
    }

    public double getMoneyReturn() {
        return moneyReturn;
    }

    public void setMoneyReturn(double moneyReturn) {
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money >= moneyCondition){
            result = money - (money/moneyCondition) * moneyReturn;
        }
        return result;
    }
}
