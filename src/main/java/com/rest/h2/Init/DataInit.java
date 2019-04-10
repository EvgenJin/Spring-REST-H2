package com.rest.h2.Init;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import com.rest.h2.dao.PersonDao;
import com.rest.h2.entity.Person;
import com.rest.h2.dao.OrderDao;
import com.rest.h2.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
 
@Component
public class DataInit implements ApplicationRunner {

    private PersonDao personDAO;
    private OrderDao orderDAO;
 
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

     @Autowired
    public DataInit(OrderDao orderDAO, PersonDao personDAO) {
        this.orderDAO = orderDAO;
        this.personDAO = personDAO;
    }

//    public DataInit(OrderDao orderDAO) {
//        this.orderDAO = orderDAO;
//    }
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = personDAO.count();
 
        if (count == 0) {
            Person p1 = new Person();
 
            p1.setFullName("John");
 
            Date d1 = df.parse("1980-12-20");
            p1.setDateOfBirth(d1);
            //
            Person p2 = new Person();
 
            p2.setFullName("Smith");
            Date d2 = df.parse("1985-11-11");
            p2.setDateOfBirth(d2);
 
            personDAO.save(p1);
            personDAO.save(p2);

            Order o1 = new Order();
//            o1.setPerson_id(1);
            o1.setTitle("item1");
            o1.setPrice(15);

            Order o2 = new Order();
//            o2.setPerson_id(1);
            o2.setTitle("item2");
            o2.setPrice(19);

            orderDAO.save(o1);
            orderDAO.save(o2);
        }
 
    }
     
}