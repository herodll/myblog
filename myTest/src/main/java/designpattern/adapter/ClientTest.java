package designpattern.adapter;

import designpattern.adapter.Adapter.Translate;
import designpattern.adapter.Target.Player;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ClientTest {
    public static void main(String[] args) {
        Player player = new Translate("姚明");
        player.attak();
        player.defense();

        /*
        运行结果：
        姚明 special attack
        姚明 special defense
         */
    }
}
