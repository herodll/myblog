package designpattern.chainOfResponsibility;

/**
 * Created by Administrator on 2018/5/28.
 */
public class Request {
    String requestType;
    String requestContent;
    int count;

    public Request(){
        this.requestType = null;
        this.requestContent = null;
        this.count = 0;
    }
    public Request(String requestType,String requestContent,int count){
        this.requestType = requestType;
        this.requestContent = requestContent;
        this.count = count;

    }
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
