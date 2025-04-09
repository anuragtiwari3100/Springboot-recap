package com.tiwari.JournalApplication.repositary;

import com.tiwari.JournalApplication.entity.JournalEntry;
import com.tiwari.JournalApplication.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositary extends MongoRepository<User, ObjectId> {
    User findByUserName(String useName);

    }
