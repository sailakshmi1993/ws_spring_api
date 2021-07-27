package com.example.crud6.Service;

import com.example.crud6.Document.UserInfo;
import com.example.crud6.Repo.Userinterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Userservice {
    @Autowired
    Userinterface userinterface;
    public UserInfo insertRecord(UserInfo userInfo) {
        return userinterface.save(userInfo);
    }
    public void fetchRecord(String email) { userinterface.findByEmail(email);
   }

    public List<UserInfo> fetchAllRecords() {
        return userinterface.findAll();
    }
   public UserInfo updateRecord(UserInfo userInfo){
       UserInfo obj= userinterface.findByEmail(userInfo.getEmail());
       obj.setFirstname(userInfo.getFirstname());
        obj.setLastname(userInfo.getLastname());
      obj.setPassword(userInfo.getPassword());
       return userinterface.save(userInfo);
 }

    public void deleteRecord(Integer id) {
        userinterface.deleteById(id);
    }
}