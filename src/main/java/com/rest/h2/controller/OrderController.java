package com.rest.h2.controller;

import com.rest.h2.dao.OrderDao;
import com.rest.h2.entity.Order;
import com.rest.h2.Service.OrderService;
import java.util.List;
import java.util.Optional;

import com.rest.h2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    OrderDao orderDao;

    // get All
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Order> all() {
        return this.orderService.getAll();
    }
    // get one by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Order> id(@PathVariable int id) {
        return this.orderService.getById(id);
    }
    // add
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order add(@RequestBody Order order) {
        return this.orderService.addOrder(order);
    }
    // update
    @RequestMapping(value = "/update", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order update(@RequestBody Order order) {
        return this.orderService.updateOrder(order);
    }

    // delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        this.orderService.deleteOrderById(id);
    }
}
