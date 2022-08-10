package org.example;

import org.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class Communication {
    private final String URL = "http://94.198.50.185:7081/api/users";


    private final RestTemplate restTemplate;
    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAllUser() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(URL,String.class);
        String cookies = forEntity.getHeaders().get("Set-Cookie").get(0);
        return cookies;
    }


    public void saveUser(User user,String cookies) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", cookies);
        HttpEntity<User> entity = new HttpEntity<>(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
        System.out.println(responseEntity.getBody());

    }

    public void updateUser(User user, String cookies) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", cookies);
        HttpEntity<User> entity = new HttpEntity<>(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class);
        System.out.println(responseEntity.getBody());

    }

    public void deleteUser(int id, String cookies) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", cookies);
        HttpEntity<User> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "/" + id, HttpMethod.DELETE, entity, String.class);
        System.out.println(responseEntity.getBody());

    }
}
