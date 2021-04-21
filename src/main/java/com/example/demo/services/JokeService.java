package com.example.demo.services;

import com.example.demo.json.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    public static final String BASE = "http://api.icndb.com/jokes/random?limitToo=[nerdy";
    private RestTemplate restTemplate;

    //khi service bean dc khai bao, neu class co ham tao thi construc se tu dong autowired, khong can khai bao them
    //khai bao phia duoi giup nguoi doc sau doc 1 cach tuong minh hon
    @Autowired
    public JokeService(RestTemplateBuilder builder) {
       restTemplate = builder.build();
    }

    public String getJoke(String firsName, String lastName){
        String output = "";

        String url = String.format("%s&firstName=%s&lastName=%s", BASE, firsName, lastName);
        JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
        if (response != null) {
            output = response.getValue().getJoke();
        }
        return output;
    }
}
