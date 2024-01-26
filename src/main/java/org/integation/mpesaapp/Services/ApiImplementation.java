package org.integation.mpesaapp.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.integation.mpesaapp.Configurations.MpesaConfigs;
import org.integation.mpesaapp.DTOs.AccessToken;
import org.integation.mpesaapp.Utils.HelperUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static org.integation.mpesaapp.Utils.Constans.*;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ApiImplementation implements ApiImplementationA {
    private final MpesaConfigs mpesaConfigs;
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public ApiImplementation(MpesaConfigs mpesaConfigs, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        this.mpesaConfigs = mpesaConfigs;
        this.objectMapper = objectMapper;
        this.okHttpClient = okHttpClient;
    }

    /** Daraja api response acees token */

    @Override
    public AccessToken getAccessToken() {
        String encodedCredentials = HelperUtil.toBase64String(String.format("%s:%s",mpesaConfigs.getConsumerKey(), mpesaConfigs.getConsumerSecret()));

        Request request = new Request.Builder()
                .url(String.format("%s?grant_type=%s", mpesaConfigs.getOauthEndpoint(), mpesaConfigs.getGrantType()))
                .get()
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodedCredentials))
                .addHeader(CACHE_CONTROL_HEADER,CACHE_CONTROL_HEADER_VALUE)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            return objectMapper.readValue(response.body().string(), AccessToken.class);
        } catch (IOException e) {
            log.error(String.format("Could not get -> %s", e.getLocalizedMessage()));
            return null;
        }
    }
}
