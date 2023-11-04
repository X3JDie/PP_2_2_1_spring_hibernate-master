package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("1", "L1", "user1@mail.ru", new Car("Audi",1)));
      userService.add(new User("2", "L2", "user2@mail.ru", new Car("Ford",2)));
      userService.add(new User("3", "L3", "user3@mail.ru", new Car("Honda",3)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+ user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Audi", 1));

      context.close();
   }
}
