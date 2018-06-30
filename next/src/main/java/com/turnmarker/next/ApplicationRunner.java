package com.turnmarker.next;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.turnmarker.next"})
public class ApplicationRunner
{

    public static void main(String[] args) {
    	
        SpringApplication.run(ApplicationRunner.class, args);
    
    }

}
