package com.uk.JournalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    private Current current;

    @Getter
    @Setter
    public class Current {
        @JsonProperty("observation_time")
        private String observationTime;
        private int temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
        @JsonProperty("wind_speed")
        private int windSpeed;
        private int pressure;
        private int precip;
        private int humidity;
        private int feelslike;

    }

}


