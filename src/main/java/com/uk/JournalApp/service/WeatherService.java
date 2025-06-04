package com.uk.JournalApp.service;

import com.uk.JournalApp.api.response.WeatherResponse;
import com.uk.JournalApp.cache.AppCache;
import com.uk.JournalApp.constants.PlaceHolders;
import com.uk.JournalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if(weatherResponse != null){
            return weatherResponse;
        } else {
            String finalAPI = appCache.appCache.get(PlaceHolders.Weather_Api).replace(PlaceHolders.CITY,city).replace(PlaceHolders.API_KEY,apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body != null){
                redisService.set("weather_of_"+city, body, 300l);
            }
            return body;
        }

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key","value");
//        User user = User.builder().userName("vipul").password("vipul").build();
//        HttpEntity<User> httpEntity = new HttpEntity<>(user,httpHeaders);


    }
}
// voic id for rachael : 21m00Tcm4TlvDq8ikWAM-