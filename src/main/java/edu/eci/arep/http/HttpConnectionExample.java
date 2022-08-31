package edu.eci.arep.http;

import edu.eci.arep.http.AlphAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionExample implements AlphAPI, PolygonAPI {
    private static final String USER_AGENT = "Mozilla/5.0";


    @Override
    /**
     * check daily action, given a specific symbol from the company name
     * @param symbol of the company name
     * @return Response from the API as a String
     * @throws IOException
     */
    public String getAlphaAPIData(String symbol) throws IOException {
        String apiURL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=demo";
        URL obj = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "{Error}";
    }
    @Override
    /**
     * Check actions, given the symbol of the company and the date(intraDay,daily,weekly and montly options);
     * @param symbol of the company that you´ll search
     * @param date of the actions report
     * @return
     * @throws IOException
     */
    public String getAlphaReportWithDate(String symbol, String date) throws IOException {
        if(!date.equals("")){
            String apiURL= "https://www.alphavantage.co/query?function="+date+"&symbol="+symbol+"&apikey=demo";
            if(date.equals("intra")){
                apiURL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+symbol+"&interval=5min&apikey=demo";
            }else if(date.equals("daily")){
                date = "TIME_SERIES_DAILY";
                 apiURL= "https://www.alphavantage.co/query?function="+date+"&symbol="+symbol+"&apikey=demo";
            }else if (date.equals("weekly")){
                date = "TIME_SERIES_WEEKLY";
                apiURL= "https://www.alphavantage.co/query?function="+date+"&symbol="+symbol+"&apikey=demo";
            }else if(date.equals("monthly")){
                date = "TIME_SERIES_MONTHLY";
                apiURL= "https://www.alphavantage.co/query?function="+date+"&symbol="+symbol+"&apikey=demo";
            }
            System.out.println("This is date"+date);

            URL obj = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                return response.toString();
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
            return "{Error}";
        }
        return getAlphaAPIData(symbol);
    }

    /**
     * check and get from the polygon API
     * @param symbol of the company
     * @return actions
     * @throws IOException
     */
    @Override
    public String getPolygonAPIData(String symbol) throws IOException {
        String apiURL = "https://api.polygon.io/v1/open-close/"+symbol+"/2020-10-14?adjusted=true&apiKey=j6ULqebyDlTiFCFNVI328IzpGx8np0YX";
        URL obj = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "{Error}";
    }
}