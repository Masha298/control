package com.example.lab_5.controllers;

import com.example.lab_5.entity.QuestEntity;
import com.example.lab_5.entity.UserEntity;
import com.example.lab_5.repositories.QuestsRepository;
import com.example.lab_5.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    QuestsRepository questsRepository;
    @GetMapping("/index")
    public String users(Model model) {
        List<UserEntity> users = usersRepository.findAllUsers();
        List<QuestEntity> quests  = questsRepository.findAllQuests();
        model.addAttribute("users", users);
        model.addAttribute("quests", quests);
        return "index";
    }
}
