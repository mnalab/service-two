package com.mna.lab.service_two.endpoints;

import com.mna.lab.service_two.config.ConfigProperties;
import com.mna.lab.service_two.dto.DataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceTwoEndpoint {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConfigProperties configProperties;

    @RequestMapping("/")
    public String HelloServiceTwo(){
        return "Hello Service from ServiceTwo \n";
    }

    @RequestMapping("/data")
    public String DataServiceOne(){
        return "Data Service from ServiceTwo \n";
    }

    @RequestMapping("/userdata")
    public DataBean getUserData(){
        DataBean dataBean = new DataBean();
        dataBean.setId(1);
        dataBean.setName("khadija");
        return dataBean;
    }

    @RequestMapping("/data/service-a")
    public String getSvcAData(){
        String serviceAUrl = "http://" +
                configProperties.getHost() +
                ":" +
                configProperties.getPort() +
                "/data";
        ResponseEntity<String> response = restTemplate.getForEntity(serviceAUrl, String.class);
        return response.getBody();
    }



}
