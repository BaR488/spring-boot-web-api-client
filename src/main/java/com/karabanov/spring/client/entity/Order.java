package com.karabanov.spring.client.entity;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 23.03.2017.
 */
public class Order implements DomainObject {

    private Long id;

    private Customer customer;

    private ZonedDateTime created;

    private List<Product> products = new ArrayList<Product>();

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }
}
