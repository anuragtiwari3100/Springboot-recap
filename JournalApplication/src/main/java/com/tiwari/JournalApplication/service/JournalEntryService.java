package com.tiwari.JournalApplication.service;

import com.tiwari.JournalApplication.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import   com.tiwari.JournalApplication.repositary.JournalEntryRepositary;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepositary journalRepository;

    public void  saveEntery(JournalEntry journalEntry){
        journalRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return  journalRepository.findAll();
    }

    public Optional<JournalEntry>  findById(ObjectId id){
        return  journalRepository.findById(id);
    }

    public void  deleteById(ObjectId id){
        journalRepository.deleteById(id);
    }
}
