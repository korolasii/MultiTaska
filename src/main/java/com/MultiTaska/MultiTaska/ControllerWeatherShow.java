package com.MultiTaska.MultiTaska;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ControllerWeatherShow {
    @PostMapping("/weather2")
    public String getWeather(@RequestParam String city, Model model) {
        String apiKey = "89bb100d056a438d883135347240302";
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city;

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(apiUrl, WeatherResponse.class);

        if (weatherResponse != null && weatherResponse.getCurrent() != null) {
            WeatherInfo weatherInfo = new WeatherInfo(
                    weatherResponse.getCurrent().getTempC(),
                    weatherResponse.getCurrent().getHumidity(),
                    weatherResponse.getCurrent().getCloud(),
                    weatherResponse.getCurrent().getPressureMb()
            );
            model.addAttribute("city", city);
            model.addAttribute("weatherInfo", weatherInfo);
            return "weather2";
        } else {
            return "error";
        }
    }
}
