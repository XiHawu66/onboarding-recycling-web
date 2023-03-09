package com.recycling;

import com.recycling.untils.GeoSpatialUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(DemoApplication.class, args);

        // test for geo query
        Resource resource = new ClassPathResource("static/location.json");
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

        boolean result = GeoSpatialUtils.geoShapeQuery(jsonFile,147.2600,-36.8595);

        System.out.println(result);

    }

}
