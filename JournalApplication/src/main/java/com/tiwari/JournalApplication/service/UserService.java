package com.tiwari.JournalApplication.service;

import com.tiwari.JournalApplication.entity.JournalEntry;
import com.tiwari.JournalApplication.entity.User;
import com.tiwari.JournalApplication.repositary.JournalEntryRepositary;
import com.tiwari.JournalApplication.repositary.UserRepositary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepositary userRepositary;

    public void  saveEntery(User user){
        userRepositary.save(user);
    }

    public List<User> getAll(){
        return  userRepositary.findAll();
    }

    public Optional<User>  findById(ObjectId id){
        return  userRepositary.findById(id);
    }

    public void  deleteById(ObjectId id){
        userRepositary.deleteById(id);
    }
    public User findByUserName(String userName){
        return  userRepositary.findByUserName(userName);
    }
}
