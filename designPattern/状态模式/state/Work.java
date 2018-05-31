package designpattern.state;

/**
 * Created by Administrator on 2018/5/31.
 */
public class Work {
    private State state;
    private int hour;

    public Work(){
        this.state = new MorningState();
        this.hour = 8;
    }
    public Work(State state,int hour){
        this.state = state;
        this.hour = hour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void writeProgram(){
        this.state.writeProgram(this);
    }
}
