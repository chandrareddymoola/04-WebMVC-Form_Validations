package com.chandra.service;

import com.chandra.entity.User;
import com.chandra.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    // two methods we have write
    // insert data
    public boolean saveUser(User user){
        user=userRepo.save(user);

        return user.getUserId()>0;
    }
    // and retrieve the data
    public List<User> getAllUsers(){
        return userRepo.findAll();
        //will return all the records availble in DB
    }
}
