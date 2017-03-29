package com.karabanov.spring.client.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer implements DomainObject {

    private Long id;

    private String name;

    private String email;

    private List<Order> orders = new ArrayList<Order>();
}
