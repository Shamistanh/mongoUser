package com.example.demo.repo;

import com.example.demo.entity.XUser;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<XUser, ObjectId> {

    void removeById(int id);
}
