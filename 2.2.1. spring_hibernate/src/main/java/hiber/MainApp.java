package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car carFisrt = new Car("Peugeot",4007);
      User userFirst = new User("Mihail", "Berezin", "baumanka0299@gmail.com");
      userFirst.setCar(carFisrt);

      Car carSenond = new Car("Porsche",718);
      User userSecond = new User("Alexandra", "Berezina", "aiberezina98@gmail.com");
      userSecond.setCar(carSenond);

      userService.add(userFirst);
      userService.add(userSecond);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Model = "+user.getCar().getModel());
         System.out.println("Series = "+user.getCar().getSeries());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Porsche",718));

      context.close();
   }
}
