package com.recycling.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.recycling.untils.GeoSpatialUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GeoSpatialService {

    private static String openCageApi = "c4d8799cdb484ee7b6a2398dc7397726";

    public String geocoding(String address) {

        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(openCageApi);
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);

        request.setRestrictToCountryCode("au");
        request.setMinConfidence(1);
        request.setNoAnnotations(false);
        request.setNoDedupe(true);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();

        return firstResultLatLng.getLng().toString() + "," + firstResultLatLng.getLat().toString();

    }

    public String geoShapeQuery(Double lng, Double lat) throws IOException {
//        System.out.println(System.currentTimeMillis());

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

//        System.out.println(System.currentTimeMillis());

        JSONObject jsonObject = JSONObject.parseObject(jsonFile);
        List<String> features = JSON.parseArray(jsonObject.getJSONArray("features").toJSONString(), String.class);

//        System.out.println(System.currentTimeMillis());

        for (String feature : features) {

            String geometry = JSONObject.parseObject(feature).getString("geometry");
            List<String> coordinates = JSON.parseArray(
                    JSONObject.parseObject(geometry).getJSONArray("coordinates").toJSONString(),
                    String.class);

            if (GeoSpatialUtils.geoShapeQuery(coordinates,lng,lat)) {

//                System.out.println(System.currentTimeMillis());

                return GeoSpatialUtils.getLgaId(feature);
            }
        }

//                System.out.println(System.currentTimeMillis());

        return "-1";
    }

}
