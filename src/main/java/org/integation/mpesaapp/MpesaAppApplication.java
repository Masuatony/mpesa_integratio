package org.integation.mpesaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MpesaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpesaAppApplication.class, args);
        System.out.println("App Running Success!");
    }

}
