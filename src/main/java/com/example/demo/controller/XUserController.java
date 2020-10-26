package com.example.demo.controller;

import com.example.demo.entity.XUser;
import com.example.demo.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@AllArgsConstructor
@RestController
public class XUserController {

    private final UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/users")
    public List<XUser> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void add(XUser xuser){
        userRepository.save(xuser);
    }
    @PostMapping("/removeById")
    public void remove(int id){
        userRepository.removeById(id);
    }
    @PostMapping("/update_name")
    public void update(String old_name, String new_name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(old_name));
        Update update = new Update();
        update.set("name", new_name);
        XUser user = mongoTemplate.findAndModify(query, update, XUser.class);

    }
}
