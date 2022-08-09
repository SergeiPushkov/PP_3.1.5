package org.example;

import org.example.Configuration.MyConfig;

import org.example.Entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication",Communication.class);
        System.out.println(communication.getAllUser());
//
        User user = new User(3L,"Sergei","Pushkov", (byte) 20);
        communication.saveUser(user);
        User user1 = new User(2L,"Sergei","Pushkov", (byte) 30);
        communication.updateUser(user1);
        communication.deleteUser(1);
    }
}
