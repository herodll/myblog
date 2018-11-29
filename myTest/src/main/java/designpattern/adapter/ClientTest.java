package designpattern.adapter;

import designpattern.adapter.Adapter.Translate;
import designpattern.adapter.Target.Player;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ClientTest {
    public static void main(String[] args) {
        Player player = new Translate("Ҧ��");
        player.attak();
        player.defense();

        /*
        ���н����
        Ҧ�� special attack
        Ҧ�� special defense
         */
    }
}
