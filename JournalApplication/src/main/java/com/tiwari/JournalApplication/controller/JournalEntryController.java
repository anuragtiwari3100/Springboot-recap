
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
public class JournalEntryController {

     private Map<Long,JournalEntry> journalEntries = new HashMap<>();

     @GetMapping
    public List<JournalEntry> getAll() {
        return  new ArrayList<>(journalEntries.values());
    }

     @PostMapping
    public  boolean createEntry(@RequestBody JournalEntry myEntry){
         journalEntries.put(myEntry.getId(),myEntry);
         System.out.println("Inserted succeafully");
         return true;
     }

     @GetMapping("/id/{myid}")
      public JournalEntry  getEntryById(@PathVariable long myid){
         return journalEntries.get(myid);
      }

      @DeleteMapping("/id/{myid}")
      public JournalEntry deleteEntryById(@PathVariable long myid){
         return journalEntries.remove(myid);
      }

      @PutMapping(" /id/{id}")
    public JournalEntry updateHournelById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
         return  journalEntries.put(id,myEntry);
      }
}
