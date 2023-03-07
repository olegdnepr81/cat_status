package org.example;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {


    public String getStatusImage(int code) {
        int statusCode;
        String url;
        String path = "https://http.cat/";
        try {
            Connection.Response loginForm = Jsoup.connect(path + code + ".jpg")
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();
            statusCode = loginForm.statusCode();
        } catch (IOException e) {
            statusCode = 404;
        }
        if (statusCode != 404) {
            url = path + code + ".jpg";
        } else {
            url = "404";
        }
        return url;
    }
}
