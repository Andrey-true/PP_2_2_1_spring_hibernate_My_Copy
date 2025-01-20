package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      // Создаем контекст Spring
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      // Получаем сервис для работы с пользователями
      UserService userService = context.getBean(UserService.class);

      // Создаем несколько машин
      Car car1 = new Car("Model1", 1001);
      Car car2 = new Car("Model2", 1002);
      Car car3 = new Car("Model3", 1003);
      Car car4 = new Car("Model4", 1004);

      // Создаем пользователей и ассоциируем их с машинами
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

      // Выводим список всех пользователей
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
         }
         System.out.println();
      }

      // Пример поиска пользователя по модели и серии машины
      User user = userService.getUserByCar("Model2", 1002);
      System.out.println("Found User: ");
      System.out.println("Id = " + user.getId());
      System.out.println("First Name = " + user.getFirstName());
      System.out.println("Last Name = " + user.getLastName());
      System.out.println("Email = " + user.getEmail());
      if (user.getCar() != null) {
         System.out.println("Car Model = " + user.getCar().getModel());
         System.out.println("Car Series = " + user.getCar().getSeries());
      }

      // Закрываем контекст
      context.close();
   }
}
