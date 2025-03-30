
//Playing with restfull Apis
package com.tiwari.JournalApplication.controller;

import com.tiwari.JournalApplication.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/journal")
public class JournalEntryController2{

    @GetMapping
    public List<JournalEntry> getAll() {

    }

    @PostMapping
    public  boolean createEntry(@RequestBody JournalEntry myEntry){


        return true;
    }

    @GetMapping("/id/{myid}")
    public JournalEntry  getEntryById(@PathVariable long myid){
       return null;
    }

    @DeleteMapping("/id/{myid}")
    public JournalEntry deleteEntryById(@PathVariable long myid){
        return null;
    }

    @PutMapping(" /id/{id}")
    public JournalEntry updateHournelById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return null;
    }
}
