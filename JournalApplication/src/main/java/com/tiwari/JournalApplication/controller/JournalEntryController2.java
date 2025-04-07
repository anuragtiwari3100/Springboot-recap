//Playing with restfull Apis
package com.tiwari.JournalApplication.controller;
import com.tiwari.JournalApplication.entity.JournalEntry;
import com.tiwari.JournalApplication.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;



@RestController
@RequestMapping("/journal")
public class JournalEntryController2{

    @Autowired
    private JournalEntryService journalEntryService;

/*
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntery(myEntry);
        return myEntry;
    }
* */

    @PostMapping
    public ResponseEntity<JournalEntry>  createEntry(@RequestBody JournalEntry  myEntry){
        try{
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntery(myEntry);
            return  new ResponseEntity<>(myEntry,HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




    /*
       @GetMapping
    public List<JournalEntry> getAll(){
       return journalEntryService.getAll();
    }
    */
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<JournalEntry> all = journalEntryService.getAll();
        if (all != null && !all.isEmpty()){
            return  new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





    @GetMapping("id/{myId}")
    public ResponseEntity<?> getJournalEntryById(@PathVariable String myId) {

        if (!ObjectId.isValid(myId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
        }
        ObjectId objectId = new ObjectId(myId);
        Optional<JournalEntry> journalEntry = journalEntryService.findById(objectId);
        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
        if (!ObjectId.isValid(myId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
    }

/*

    @DeleteMapping("id/{myId}")
    public boolean deleteJOurnalEntrybyId(@PathVariable ObjectId myId){
     journalEntryService.deleteById(myId);
     return true;
    }
*/

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("id/{id}")
    public ResponseEntity<?> updateJournalByID(@PathVariable String id, @RequestBody JournalEntry newEntry) {
        if (!ObjectId.isValid(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Journal entry not found");
        }
        ObjectId objectId = new ObjectId(id);
        JournalEntry old = journalEntryService.findById(objectId).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntery(old);
            return  new ResponseEntity<>(old,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }




}
