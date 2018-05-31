package designpattern.state;

/**
 * Created by Administrator on 2018/5/31.
 */
public class AfternoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour() >= 18) {
            //work.setState(new MorningState());
            //System.out.println("curreent state is: " + work.getState() + ",and will to go home");
            //work.writeProgram();
            System.out.println("it time to go home");
        }
        else{
            System.out.println("afternoon, i am ok");
        }
    }


}
