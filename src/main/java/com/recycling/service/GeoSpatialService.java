package com.recycling.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.recycling.untils.GeoSpatialUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GeoSpatialService {

    public String geoShapeQuery(Double lng, Double lat) throws IOException {
        System.out.println(System.currentTimeMillis());

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

        System.out.println(System.currentTimeMillis());

        JSONObject jsonObject = JSONObject.parseObject(jsonFile);
        List<String> features = JSON.parseArray(jsonObject.getJSONArray("features").toJSONString(), String.class);

        System.out.println(System.currentTimeMillis());

        for (String feature : features) {

            if (GeoSpatialUtils.geoShapeQuery(feature,lng,lat)) {

                System.out.println(System.currentTimeMillis());

                return GeoSpatialUtils.getLgaId(feature);
            }
        }

        return "-1";
    }

}
