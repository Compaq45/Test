package service;

import model.User;

import java.util.List;

public interface UserService {
    User getById(Long id);

    void save(User user);

    void delete(Long id);

    List<User> getAll();
}
