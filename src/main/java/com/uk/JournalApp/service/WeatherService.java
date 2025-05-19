package com.uk.JournalApp.service;

import com.uk.JournalApp.api.response.WeatherResponse;
import com.uk.JournalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private final String apiKey = "fab538c50ce10a395c83480457deaf3e";

    private final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI = API.replace("CITY",city).replace("API_KEY",apiKey);

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key","value");
//        User user = User.builder().userName("vipul").password("vipul").build();
//        HttpEntity<User> httpEntity = new HttpEntity<>(user,httpHeaders);

        ResponseEntity<WeatherResponse> response =  restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
