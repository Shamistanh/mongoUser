package com.example.demo.entity;

import lombok.*;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class XUser implements Serializable {

    @Id
    @Field("_id")
    private int id;

    @Field
    private String name;

    @Field
    private String password;
}
