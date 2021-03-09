package com.example.json.boot_json;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class RestClient {

    private static final String GET_USERS_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String GET_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users/{id}";
    private static final String CREATE_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String UPDATE_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users";
    private static final String DELETE_USER_ENDPOINT_URL = "http://91.241.64.178:7081/api/users/{id}";

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) throws IOException {
        RestClient restClient = new RestClient();
        System.out.println(restClient.getSession());
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

        System.out.println(result.getHeaders());      //String cookie = result.getHeaders("Set-Cookie").split(";")[0];

    }

//        private void createUser() {
//        User newUser = new User(3L, "James", "Brown", (byte) 12);
//        RestTemplate restTemplate = new RestTemplate();
//        User result = restTemplate.postForObject(CREATE_USER_ENDPOINT_URL, newUser, User.class);
//        System.out.println(result);
//    }
//    private void updateUser() {
//        Map <String, String> params = new HashMap <String, String> ();
//        params.put("id", "3");
//        User updatedEmployee = new User("Thomas" , "Shelby", 13);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.put(UPDATE_USER_ENDPOINT_URL, updatedEmployee, params);
//    }
String getSession() throws IOException {
    URL url = new URL("http://91.241.64.178:7081/api/users");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    final StringBuilder content = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
        String cookie = con.getHeaderField("Set-Cookie").split(";")[0];
    }

    return inputLine;
}
}

