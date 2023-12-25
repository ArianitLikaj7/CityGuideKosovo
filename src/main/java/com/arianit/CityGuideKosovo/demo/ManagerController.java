package com.arianit.CityGuideKosovo.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager")
public class    ManagerController {

    @GetMapping
    public String get(){
        return "GET: manager controller";
    }
    @PostMapping
    public String post(){
        return "POST: manager controller";
    }

}
