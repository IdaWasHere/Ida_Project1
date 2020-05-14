package com.Ida.www.po;

public class Apply {
    private int id;
    private String stuName;
    private String stuCollege;
    private String teaName;
    private String time;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuname() {
        return stuName;
    }

    public void setStuname(String stuname) {
        this.stuName = stuname;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuCollege='" + stuCollege + '\'' +
                ", teaName='" + teaName + '\'' +
                ", time='" + time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
