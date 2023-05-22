package com.lov2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    public String coachName;

    @Value("${team.name}")
    public String teamName;

    //expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){ return "Run a hard 5k!"; }

    //expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){ return "Today is your lucky day!"; }

    @GetMapping("/teamInfo")
    public String getTeamInfo(){ return "Coach: " + coachName + "Team: " + teamName; }

}
