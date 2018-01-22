package com.openplugins.utils.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {

    private String url, slug;

    public Request(String url, String slug) {
        this.url=url+slug;
        this.slug=slug;
    }

    public String request(String type) {

        BufferedReader br;

        try {
            URL url = new URL(this.url);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            StringBuilder builder = new StringBuilder();

            while ((line = br.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }

            String data = builder.toString();

            if (data.contains(type)) {
                data = data.replace("{'"+type+"':","");
                data = data.replace("}","");

                return data;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
