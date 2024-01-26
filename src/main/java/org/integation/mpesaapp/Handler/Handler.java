package org.integation.mpesaapp.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.integation.mpesaapp.Services.DarajaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mpesa")
@Slf4j
public class Handler{
//    @Autowired
    private final DarajaApi darajaApi;
    private  final ObjectMapper objectMapper;

    public Handler(DarajaApi darajaApi, ObjectMapper objectMapper){
        this.darajaApi = darajaApi;
        this.objectMapper = objectMapper;
    }


}
