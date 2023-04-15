package com.example.college;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class College {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column
 int collegeid;
 @Column
   private String collegename;
 @Column
    private String course;
 @Column
    private int duration;
 @Column
    private String acctype;
 @Column
    private int accfee;
@OneToOne
    @JoinColumn(name="feeid")
    @JsonBackReference
    private Fee fee;

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public int getAccfee() {
        return accfee;
    }

    public void setAccfee(int accfee) {
        this.accfee = accfee;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }
}
