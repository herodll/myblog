package designpattern.adapter.Adapter;

import designpattern.adapter.Adaptee.ChinaAthlete;
import designpattern.adapter.Target.Player;

/**
 * Created by Administrator on 2018/5/21.
 */
public class Translate extends Player{

    ChinaAthlete player = new ChinaAthlete();

    //父类必须包含默认的无惨构造函数
    public Translate(String name){
        player.setName(name);
    }

    @Override
    public void attak() {
        //达到适配的效果
        player.specialAttack();
    }

    @Override
    public void defense() {
        //达到适配的效果
        player.specialDefense();
    }
}
