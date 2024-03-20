package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.repository.UserRepo;
import se.dmitrykhalizov.webbshoplabb.ui.IO;

@Service
public class UserService {
    UserRepo userRepo;
    IO io;

    @Autowired
    public UserService(UserRepo userRepo, IO io) {
        this.userRepo = userRepo;
        this.io = io;
    }

    public String login(String username, String password) {
        boolean userExist = userRepo.existsUserByUsernameAndPassword(username, password);
        if (userExist) {
            return "ok";
        } else {
            return "Wrong username or password";
        }
    }
}
