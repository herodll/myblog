package designpattern.state;

/**
 * Created by Administrator on 2018/5/31.
 */
public class ClientTest {
    public static void main(String[] args) {
        Work work = new Work();

        work.setHour(9);
        work.writeProgram();

        work.setHour(11);
        work.writeProgram();

        work.setHour(12);
        work.writeProgram();

        work.setHour(13);
        work.writeProgram();

        work.setHour(14);
        work.writeProgram();

        work.setHour(16);
        work.writeProgram();

        work.setHour(18);
        work.writeProgram();

        work.setHour(19);
        work.writeProgram();

        /*
        the run result :

        MorningState, i am energetic
        MorningState, i am energetic
        noonState, i am tired
        noonState, i am tired
        afternoon, i am ok
        afternoon, i am ok
        it time to go home
        it time to go home
         */
    }

}
