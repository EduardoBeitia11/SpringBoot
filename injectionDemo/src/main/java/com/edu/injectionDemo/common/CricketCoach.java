package com.edu.injectionDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {System.out.println("In constructor: " + getClass().getSimpleName());}

    //
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("In doMyCleanStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Fast bowling for 15 minutes";
    }


}
