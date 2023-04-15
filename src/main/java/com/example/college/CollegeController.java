package com.example.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
// ************************************ this is my controller class  int this we can add college fee to table Fee,college course details to table College  and get all college details at once ***************************

@Controller
public class CollegeController {
    @Autowired
    Collegerepository collegerepository;
    @Autowired
    Feerepository feerepository;
    // ************************* api to add a college course detail **************************
    @PostMapping("/addcollege")
    public @ResponseBody College addCollege(@RequestParam(name="collegename")String collegename,@RequestParam(name="course")String course,@RequestParam(name="duration")int duration,@RequestParam(name="acctype")String acctype,@RequestParam(name="accfee")int accfee,@RequestParam(name="feeid")int feeid){
       try {


           College college = new College();
           college.setCollegename(collegename);

           college.setCourse(course);


           college.setDuration(duration);


           college.setAcctype(acctype);


           college.setAccfee(accfee);


           Fee fee = new Fee();
           fee=feerepository.findById(feeid).get();

           System.out.println(college.getAccfee());



           college.setFee(fee);


           collegerepository.save(college);
          System.out.println(collegerepository.save(college));

           return college;
       }
       catch(Exception ex){
           return new College();
       }
    }
// ********************************** api to add a fee to table Fee *******************
    @PostMapping("/addfee")
    public @ResponseBody Fee addfee(@RequestParam(name="fee")int fee){
        try{
            Fee fee1=new Fee();
            fee1.setFee(fee);
            feerepository.save(fee1);
            return fee1;
        }
        catch (Exception ex){
            return new Fee();
        }
    }
//       ************************* api to find all course details along with fee details **********************
    @GetMapping("/find")
    public @ResponseBody ArrayList<College> findall(@RequestParam(name="collegename") String collegename, @RequestParam(name = "course")String course){
     try {
         return (ArrayList<College>) collegerepository.findByCollegenameAndCourse(collegename, course);
     }
     catch (Exception ex){
         return new ArrayList<>();
     }
    }
    @GetMapping("/all")
    public @ResponseBody ArrayList<College> all(){
        try{
           return (ArrayList<College>) collegerepository.findAll();
        }
        catch (Exception ex) {
            return new ArrayList<>();
        }
    }
}
