package com.example.json.boot_json;


import com.example.json.boot_json.models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.springframework.http.HttpMethod.POST;

public class RestClient {

    private static final String GET_USERS_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String GET_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users/{id}";
    private static final String CREATE_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String UPDATE_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String DELETE_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users/{id}";

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        RestClient restClient = new RestClient();

        restClient.getUsers();
        //restClient.createUser();
        // restClient.updateUser();
        // restClient.deleteUser();
        //System.out.println(restClient.getSession());

    }


    private void getUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_USERS_ENDPOINT_URL, HttpMethod.GET, entity,
                String.class);

        System.out.println(result.getHeaders());

        User newUser = new User(3L, "James", "Brown", (byte) 12);
        User result1 = restTemplate.postForObject(CREATE_USER_ENDPOINT_URL,  newUser, User.class);


    }

//        private void createUser() {
//        User newUser = new User(3L, "James", "Brown", (byte) 12);
//        RestTemplate restTemplate = new RestTemplate();
//        User result = restTemplate.postForObject(CREATE_USER_ENDPOINT_URL, newUser, User.class);
//        System.out.println(result);
    }
//    private void updateUser() {
//        Map <String, String> params = new HashMap <String, String> ();
//        params.put("id", "3");
//        User updatedEmployee = new User("Thomas" , "Shelby", 13);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.put(UPDATE_USER_ENDPOINT_URL, updatedEmployee, params);
//    }


