package com.recycling.service;

import com.recycling.untils.GeoSpatialUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GeoSpatialService {

    public boolean geoShapeQuery(Double lng, Double lat) throws IOException {
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

        return GeoSpatialUtils.geoShapeQuery(jsonFile,lng,lat);
    }

}
