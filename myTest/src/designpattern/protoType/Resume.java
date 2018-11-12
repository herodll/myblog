package designpattern.protoType;

/**
 * Created by Administrator on 2018/5/21.
 */
public class Resume implements Cloneable{
    private String name;
    private String sex;
    private int age;
    private String application;
    //组合关系中，WorkExperience类是Resume的一部分，所以将工作经历类对象作为简历类的一个属性
    private WorkExperience work;

    Resume(String name){
        this.work = new WorkExperience();
        this.name = name;
    }
    Resume (WorkExperience work){
        this.work =(WorkExperience)work.clone();
    }

    //设置个人信息
    public void setPersonalInfo(String sex, int age, String application){
        this.age = age;
        this.sex = sex;
        this.application = application;
    }

    //设置工作经历
    public void setWorkExperience(String workDate,String company){
        this.work.setWorkDate(workDate);
        this.work.setCompany(company);
    }

    //展示简历
    public void diaplay(){
        System.out.println("name:"+this.name);
        System.out.println("age:"+this.age);
        System.out.println("sex:"+this.sex);
        System.out.println("application:"+this.application);
        System.out.println("workDate:"+this.work.getWorkDate());
        System.out.println("company:"+this.work.getCompany());
    }

    public Object clone(){
        //此处为深拷贝
        Resume obj = new Resume(this.work);
        obj.name = this.name;
        obj.age = this.age;
        obj.sex = this.sex;
        obj.application = this.application;
        return obj;
    }

}
