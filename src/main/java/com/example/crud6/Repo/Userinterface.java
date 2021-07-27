package com.example.crud6.Repo;

import com.example.crud6.Document.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.web.bind.annotation.RequestParam;
public interface Userinterface extends MongoRepository<UserInfo, Integer> {
    UserInfo findByEmail(@RequestParam String email);
  void deleteById(Integer id);

}
