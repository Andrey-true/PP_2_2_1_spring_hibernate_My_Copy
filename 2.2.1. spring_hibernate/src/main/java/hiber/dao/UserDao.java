package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user); // Метод для добавления пользователя
   List<User> listUsers(); // Метод для получения всех пользователей

   // Новый метод для получения пользователя по модели и серии автомобиля
   User getUserByCar(String model, int series);
}
