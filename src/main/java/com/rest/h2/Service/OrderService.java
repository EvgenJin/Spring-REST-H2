package com.rest.h2.Service;

import com.rest.h2.dao.OrderDao;
import com.rest.h2.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public List<Order> getAll() {
        return this.orderDao.findAll();
    }
    public Optional<Order> getById(int id) {
        return this.orderDao.findById(id);
    }
    public Order addOrder (Order person) {
        return this.orderDao.save(person);
    }
    public Order updateOrder(Order person) {
        return this.orderDao.save(person);
    }
    public void deleteOrderById(int id) {
        this.orderDao.deleteById(id);
    }

}
