package com.tiwari.JournalApplication.repositary;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tiwari.JournalApplication.entity.JournalEntry;

public interface JournalEntryRepositary extends MongoRepository<JournalEntry, ObjectId> {

    }
