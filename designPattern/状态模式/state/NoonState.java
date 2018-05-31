package designpattern.state;

/**
 * Created by Administrator on 2018/5/31.
 */
public class NoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour() >= 14) {
            work.setState(new AfternoonState());
            //System.out.println("curreent state is: " + work.getState() + ",and will to state: AfernoonState");
            work.writeProgram();
        }
        else{
            System.out.println("noonState, i am tired");
        }
    }


}
