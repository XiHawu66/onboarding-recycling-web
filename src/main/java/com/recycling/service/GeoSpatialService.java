package com.recycling.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.recycling.untils.GeoSpatialUtils;

import java.io.IOException;
import java.util.List;

import static com.recycling.DemoApplication.features;

public class GeoSpatialService {

    private static String openCageApi = "c4d8799cdb484ee7b6a2398dc7397726";

    public String geocoding(String address) {

        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(openCageApi);
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);

        request.setMinConfidence(1);
        request.setNoAnnotations(false);
        request.setNoDedupe(true);

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();

        return firstResultLatLng.getLng().toString() + "," + firstResultLatLng.getLat().toString();

    }

    public String geoShapeQuery(Double lng, Double lat) throws IOException {

        for (String feature : features) {

            String geometry = JSONObject.parseObject(feature).getString("geometry");
            List<String> coordinates = JSON.parseArray(
                    JSONObject.parseObject(geometry).getJSONArray("coordinates").toJSONString(),
                    String.class);

            if (GeoSpatialUtils.geoShapeQuery(coordinates,lng,lat)) {

                return GeoSpatialUtils.getLgaId(feature);
            }
        }

        return "-1";
    }

}
