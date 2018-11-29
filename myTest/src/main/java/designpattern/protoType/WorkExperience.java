package designpattern.protoType;

/**
 * Created by Administrator on 2018/5/21.
 */
public class WorkExperience implements Cloneable{
    private String workDate;
    private String company;

    public WorkExperience(){}

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Object clone(){
        return (Object)new WorkExperience();
    }

}
