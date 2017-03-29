/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karabanov.spring.client.utils;

import com.google.gson.Gson;
import com.karabanov.spring.client.entity.Customer;
import com.karabanov.spring.client.entity.Order;
import com.karabanov.spring.client.entity.Product;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author boris
 */
public class ApiHelper {

    private static final String baseUri = "http://localhost:8080/api/";

    private static final Map<Class, String> entityUriMap;

    static {
        entityUriMap = new HashMap();
        entityUriMap.put(Order.class, "orders");
        entityUriMap.put(Customer.class, "orders");
        entityUriMap.put(Product.class, "orders");
    }

    public static String getUri(Class c) {
        return baseUri + getEntityUri(c);
    }

    public static String getEntityUri(Class c) {
        return entityUriMap.get(c);
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static Object getObjectFromUri(String uri, Class c) throws Exception {
        String json = readUrl(uri);

        Gson gson = new Gson();
        Object object = gson.fromJson(json, c);

        return object;
    }
}
