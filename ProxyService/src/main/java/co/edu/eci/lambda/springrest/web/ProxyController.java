package co.edu.eci.lambda.springrest.web;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import co.edu.eci.lambda.springrest.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ProxyController {

    private final String URL1 = "http://ec2-3-83-102-27.compute-1.amazonaws.com:8080";
    private final String URL2 = "http://ec2-44-210-91-34.compute-1.amazonaws.com:8080";

    @GetMapping("/fibwin")
    public String chooseFibonnaci(@RequestParam(value = "n", defaultValue = "0") int n) throws IOException {
        try {
            return chooseFibonnaci(n, URL1);
        } catch (Exception e){
            return chooseFibonnaci(n, URL2);
        }
    }


    public String chooseFibonnaci(int n, String URL) throws IOException {

        String GET_URL = URL + "/fibwin?n=" + n;


        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

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
            System.out.println("GET request didn't work");
            return "suerte";

        }
    }


}
