package designpattern.state;

/**
 * Created by Administrator on 2018/5/31.
 */
public class MorningState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour() >= 12 ) {
            work.setState(new NoonState());
           // System.out.println("curreent state is: " + work.getState() + ",and will to state: NoonState");
            work.writeProgram();
        }
        else{
            System.out.println("MorningState, i am energetic");
        }
    }


}
