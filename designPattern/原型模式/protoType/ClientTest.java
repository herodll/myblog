package designpattern.protoType;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ClientTest {
    public static void main(String[] args) {

        Resume myResume = new Resume("张三");
        myResume.setPersonalInfo("男",20,"软件研发");
        myResume.setWorkExperience("2016-2018","阿里巴巴");

        Resume b = (Resume) myResume.clone();
        b.setWorkExperience("2015-2018","百度");

        Resume c = (Resume) myResume.clone();
        c.setPersonalInfo("女",22,"王静");
        c.setWorkExperience("2018-至今","腾讯");

        System.out.println("***********************************");
        myResume.diaplay();
        System.out.println("***********************************");
        b.diaplay();
        System.out.println("***********************************");
        c.diaplay();

        /*
        ***********************************
        name:张三
        age:20
        sex:男
        application:软件研发
        workDate:2016-2018
        company:阿里巴巴
        ***********************************
        name:张三
        age:20
        sex:男
        application:软件研发
        workDate:2015-2018
        company:百度
        ***********************************
        name:张三
        age:22
        sex:女
        application:王静
        workDate:2018-至今
        company:腾讯

         */
    }
}
