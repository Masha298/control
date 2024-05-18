package com.example.lab_5.Crud;

import com.example.lab_5.entity.QuestEntity;
import com.example.lab_5.repositories.QuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestCrud{
    @Autowired
    QuestsRepository questsRespository;
    @PostMapping("/questadd")
    public void addUser(@RequestBody QuestEntity quest) {
        questsRespository.addQuest(quest);
    }

    @DeleteMapping("/questdelete/{id}")
    public ResponseEntity<Void> deleteQuest(@PathVariable Integer id) {
        questsRespository.deleteQuestById(id);
        return ResponseEntity.noContent().build();
    }
}