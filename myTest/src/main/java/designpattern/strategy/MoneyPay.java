package designpattern.strategy;

/**
 * Created by Administrator on 2018/5/31.
 */
public class MoneyPay {
    private Strategy strategy;
    public MoneyPay(){}
    public MoneyPay(int type){
        switch(type){
            case 1:
                CashNomal cashNomal = new CashNomal();
                this.strategy = cashNomal;
                break;
            case 2:
                CashRebate cashRebate = new CashRebate(0.8);
                this.strategy = cashRebate;
                break;
            case 3:
                CashReturn cashReturn = new CashReturn(300,100);
                this.strategy = cashReturn;
                break;
        }

    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double acceptCash(double money){
        return this.strategy.acceptCash(money);
    }
}
