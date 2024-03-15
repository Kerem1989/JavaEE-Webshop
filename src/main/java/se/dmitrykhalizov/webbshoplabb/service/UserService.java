package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.database.EnumSelection;
import se.dmitrykhalizov.webbshoplabb.repository.UserRepo;
import se.dmitrykhalizov.webbshoplabb.ui.IO;

@Service
public class UserService {
    UserRepo userRepo;
    IO io;

    @Autowired
    public UserService(UserRepo userRepo, IO io){
        this.userRepo = userRepo;
        this.io = io;
    }

    public EnumSelection login(String username, String password) {
        boolean userExist = userRepo.existsUserByUsernameAndPassword(username, password);
        EnumSelection status;
        if (userExist) {
            System.out.println("Welcome " + username);
           status = EnumSelection.ok;
        } else {
            System.out.println("Wrong username or password");
            status = EnumSelection.denied;
        }
        return status;
    }
}