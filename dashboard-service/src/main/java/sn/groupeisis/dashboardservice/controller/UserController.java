package sn.groupeisis.dashboardservice.controller;


import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sn.groupeisis.dashboardservice.domain.AppUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/userdashbord")
@AllArgsConstructor
public class UserController {
    @GetMapping
    public List<AppUser> getAll() {
   //     String apivaluefromadminserviceUri = "http://localhost:8889/ADMINS-SERVICES/user";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<AppUser>> responseEntity = restTemplate.exchange(
                "http://localhost:8889/ADMINS-SERVICES/user",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AppUser>>() {
                });
        List<AppUser> pojoObjList = responseEntity.getBody();

        return pojoObjList;

    }
    @GetMapping("/test0")
    public String getAll1() {
        String apivaluefromadminserviceUri = "http://172.20.10.3:8082/user";
        RestTemplate restTemplate = new RestTemplate();
        String val = restTemplate.getForObject(apivaluefromadminserviceUri, String.class);
        return val;

    }
    @RequestMapping(value = "/{id}")
    public String getTestMessage(@PathVariable int id) {
        String apivaluefromadminserviceUri = "http://172.20.10.3:8082/user/"+id;
        RestTemplate restTemplate = new RestTemplate();
        String val = restTemplate.getForObject(apivaluefromadminserviceUri, String.class);
        return val;

    }
    @RequestMapping(value = "/sn/{id}")
    public AppUser getUser(@PathVariable int id) {
       // String apivaluefromadminserviceUri = "http://localhost:8889/ADMINS-SERVICES/user/"+id;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AppUser> responseEntity = restTemplate.exchange(
                "http://localhost:8889/ADMINS-SERVICES/user/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<AppUser>() {
                });
        AppUser pojoOb = responseEntity.getBody();

        return pojoOb;

    }

}
