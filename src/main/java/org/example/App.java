package org.example;

import org.example.Configuration.MyConfig;

import org.example.Entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class App {


    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication",Communication.class);

        String cookies = communication.getAllUser();
        String new_cookies = cookies.substring(0,43);
        User user = new User(3L,"James","Brown", (byte) 20);
        communication.saveUser(user,new_cookies);
        User user1 = new User(3L,"Thomas","Shelby", (byte) 20);
        communication.updateUser(user1, new_cookies);
        communication.deleteUser(3, new_cookies);
    }
}
