package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user); // Метод для добавления пользователя
    List<User> listUsers(); // Метод для получения всех пользователей

    // Новый метод для получения пользователя по модели и серии автомобиля
    User getUserByCar(String model, int series);
}
