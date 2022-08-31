package edu.eci.arep.http;

import edu.eci.arep.http.Cache;
import edu.eci.arep.http.HttpConnectionExample;

import static spark.Spark.*;

public class tareaArep {

    public static void main(String[] args) {
        Cache cache = new Cache();
        boolean firstTime = true;
        port(getPort());
        HttpConnectionExample connection = new HttpConnectionExample();
        staticFiles.location("/public");

        //Path to get from AlphaAPI
        get("/find", (req, res) -> {
            res.type("application/json");
            String symbol = req.queryParams("symbol");
            String date = req.queryParams("date");
            if (date == null) {
                date = "";
            }
            if (!cache.isInCache(symbol+date)) {
                cache.putInCache(symbol,date, connection.getAlphaReportWithDate(symbol,date));
                return connection.getAlphaReportWithDate(symbol, date);
            } else {
                return cache.getFromCache(symbol+date);
            }
        });
        //Path to get from edu.eci.arep.http.PolygonAPI
        get("/search", (req, res) -> {
            res.type("application/json");
            String symbol = req.queryParams("symbol");
            if (!cache.isInCache(symbol+"P")){
                cache.putInCache(symbol,connection.getPolygonAPIData(symbol));
                return connection.getPolygonAPIData(symbol);
            }else {
                return cache.getFromCache(symbol+"P");

            }
        });


    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
