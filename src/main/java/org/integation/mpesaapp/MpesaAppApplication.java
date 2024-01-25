package org.integation.mpesaapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.integation.mpesaapp.DTOs.AcknowledgeResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MpesaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpesaAppApplication.class, args);
        System.out.println("App Running Success!");
    }

    @Bean
    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public AcknowledgeResponse getAcknowledgeResponse() {
        AcknowledgeResponse acknowledgeResponse = new AcknowledgeResponse();
        acknowledgeResponse.setMessage("Success");
        return acknowledgeResponse;
    }


}
