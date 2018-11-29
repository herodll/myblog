package designpattern.strategy;

/**
 * Created by Administrator on 2018/5/31.
 */
public class ClientTest {
    public static void main(String[] args) {
        MoneyPay moneyPay = new MoneyPay(2);
        double money = moneyPay.acceptCash(200);
        System.out.println("should pay money:"+money);

        MoneyPay moneyPay1 = new MoneyPay(3);
        double money1 = moneyPay1.acceptCash(400);
        System.out.println("should pay money:"+money1);

        MoneyPay moneyPay2 = new MoneyPay(1);
        double money2 = moneyPay2.acceptCash(200);
        System.out.println("should pay money:"+money2);

        /*
        the run result:

        should pay money:160.0
        should pay money:266.6666666666667
        should pay money:200.0
         */


    }
}
