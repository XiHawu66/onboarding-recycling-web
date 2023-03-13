package com.recycling;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    public static List<String> features;

    public static void main(String[] args) throws IOException {

        Resource resource = new ClassPathResource("static/geo_json.json");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        String jsonFile = null;
        while((data = br.readLine()) != null) {
            jsonFile = data;
        }

        br.close();
        isr.close();
        is.close();

        JSONObject jsonObject = JSONObject.parseObject(jsonFile);
        features = JSON.parseArray(jsonObject.getJSONArray("features").toJSONString(), String.class);

        SpringApplication.run(DemoApplication.class, args);

    }

}
