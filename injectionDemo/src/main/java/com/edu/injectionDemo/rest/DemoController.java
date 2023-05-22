package com.edu.injectionDemo.rest;


import com.edu.injectionDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public Coach myCoach;

    //!Setter Injection
    /*@Autowired
    public void setMyCoach(@Qualifier("baseballCoach") Coach theCoach){
        myCoach = theCoach;
    }*/

    //!Constructor Injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        System.out.println("hola");
        return myCoach.getDailyWorkout();
    }
}
