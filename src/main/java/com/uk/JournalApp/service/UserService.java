package com.uk.JournalApp.service;

import com.uk.JournalApp.entity.JournalEntry;
import com.uk.JournalApp.entity.User;
import com.uk.JournalApp.repository.JournalEntryRepository;
import com.uk.JournalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        user.setDate(LocalDateTime.now());
        userRepository.save(user);
    }

    public List<?> getAll() {
        return userRepository.findAll();
    }

    public Optional<?> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteBYId(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
