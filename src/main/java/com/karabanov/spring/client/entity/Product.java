package com.karabanov.spring.client.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 23.03.2017.
 */

public class Product  implements DomainObject{
    
    private Long id;

    private String name;

    private int weight;

    private String color;

    private List<Order> orders =  new ArrayList<Order>();
}
