package com.recycling.untils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.util.List;

public class GeoSpatialUtils {

    public static boolean geoShapeQuery(List<String> multiPolygonCoordinates, Double lng, Double lat) {
        boolean result = false;

        Coordinate coordinate = new Coordinate(lng,lat);
//        List<String> multiPolygonCoordinates = readCoordinatesList(geoJsonString);

        for (String polygonCoordinates : multiPolygonCoordinates) {

            String[] multiRingCoordinates = polygonCoordinates
                    .replace("]],", "]]*")
                    .replace("[[[","[[").replace("]]]","]]")
                    .split("[*]");


            String[] outerRingCoordinates = ringFormatter(multiRingCoordinates[0]);
            Coordinate[] outerCoordinateArray = stringToCoordinate(outerRingCoordinates);

            if (pointWithinPolygon(outerCoordinateArray, coordinate)) {
                result = true;

                for (int i = 1; i < multiRingCoordinates.length; i++) {
                    String[] innerRingCoordinates = ringFormatter(multiRingCoordinates[i]);
                    Coordinate[] innerCoordinateArray = stringToCoordinate(innerRingCoordinates);

                    if (pointWithinPolygon(innerCoordinateArray, coordinate)) {
                        result = false;
                        break;
                    }

                }

            }

        }

        return result;
    }

    public static String getLgaId(String geoJsonString) {
        JSONObject jsonObject = JSONObject.parseObject(geoJsonString);
        String properties = jsonObject.getString("properties");

        return JSONObject.parseObject(properties).getString("lga_pid");

    }

    private static List<String> readCoordinatesList(String geoJsonString) {
        JSONObject jsonObject = JSONObject.parseObject(geoJsonString);
        String geometry = jsonObject.getString("geometry");

        return JSON.parseArray(
                JSONObject.parseObject(geometry).getJSONArray("coordinates").toJSONString(),
                String.class
        );

    }

    private static Coordinate[] stringToCoordinate(String[] ringCoordinates) {

        Coordinate[] coordinates = new Coordinate[ringCoordinates.length];

        for (int i = 0; i < ringCoordinates.length; i++) {
            String[] lngLat = ringCoordinates[i].replace("[","").replace("]","").split(",");

            Coordinate coordinate = new Coordinate(Double.parseDouble(lngLat[0]), Double.parseDouble(lngLat[1]));
            coordinates[i] = coordinate;
        }

        return coordinates;

    }

    private static String[] ringFormatter(String ringCoordinates) {

        return ringCoordinates
                .replace("],", "]*")
                .replace("[[","[").replace("]]","]")
                .split("[*]");

    }

    private static boolean pointWithinPolygon(Coordinate[] coordinateArray, Coordinate coordinate) {

        boolean result = false;

        if (coordinateArray.length < 3) {
            return false;
        }

        if (!(coordinateArray[0].equals2D(coordinateArray[coordinateArray.length - 1]))) {
            return false;
        }

        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(coordinate);
        Polygon polygon = geometryFactory.createPolygon(coordinateArray);

        if (point.within(polygon) || point.intersects(polygon)) {
            result = true;
        }

        return result;
    }

}
