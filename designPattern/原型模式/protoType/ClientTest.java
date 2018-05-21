package designpattern.protoType;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ClientTest {
    public static void main(String[] args) {

        Resume myResume = new Resume("����");
        myResume.setPersonalInfo("��",20,"����з�");
        myResume.setWorkExperience("2016-2018","����Ͱ�");

        Resume b = (Resume) myResume.clone();
        b.setWorkExperience("2015-2018","�ٶ�");

        Resume c = (Resume) myResume.clone();
        c.setPersonalInfo("Ů",22,"����");
        c.setWorkExperience("2018-����","��Ѷ");

        System.out.println("***********************************");
        myResume.diaplay();
        System.out.println("***********************************");
        b.diaplay();
        System.out.println("***********************************");
        c.diaplay();

        /*
        ***********************************
        name:����
        age:20
        sex:��
        application:����з�
        workDate:2016-2018
        company:����Ͱ�
        ***********************************
        name:����
        age:20
        sex:��
        application:����з�
        workDate:2015-2018
        company:�ٶ�
        ***********************************
        name:����
        age:22
        sex:Ů
        application:����
        workDate:2018-����
        company:��Ѷ

         */
    }
}
