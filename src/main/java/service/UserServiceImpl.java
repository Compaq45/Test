package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
