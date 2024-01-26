package org.integation.mpesaapp.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class AccessToken {
    @JsonProperty("acess_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private String expriresIn;

    @SneakyThrows
    @Override
    public String toString() {return new ObjectMapper().writeValueAsString(this);
    }
}
