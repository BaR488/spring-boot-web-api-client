/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karabanov.spring.client.businessServers;

import com.karabanov.spring.client.entity.Order;
import com.karabanov.spring.client.utils.ApiHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author boris
 */
public class OrderBs {

    private static Integer _page = 0;
    private static Integer _limit = 5;
    private static String _sortBy = "created";
    private static String _direction = "DESC";

    private static String _pageName = "page";
    private static String _limitName = "limit";
    private static String _sortByName = "sortBy";
    private static String _directionName = "direction";

    public static List<Order> getOrders() {
        String uri = ApiHelper.getUri(Order.class)
                + "?"
                + _pageName + "=" + _page + "&"
                + _limitName + "=" + _limit + "&"
                + _sortByName + "=" + _sortBy + "&"
                + _directionName + "=" + _direction;
        try {
            Order[] orders = (Order[]) ApiHelper.getObjectFromUri(uri, Order[].class);
            return new ArrayList<Order>(Arrays.asList(orders));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
