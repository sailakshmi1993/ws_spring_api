package com.example.crud6.Crudcontroller;
import com.example.crud6.Document.UserInfo;
import com.example.crud6.Service.Userservice;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class Crudcontroller {
    @Autowired
    Userservice userService;
    @PostMapping("/create")
    public UserInfo createRecord(@RequestBody UserInfo userInfo){
        return userService.insertRecord(userInfo);
    }
   @GetMapping("/fetchRecord/{email}")
    public void getRecord(@PathVariable String email){
       userService.fetchRecord(email);
    }
    @GetMapping("/fetchAllRecord")
    public List<UserInfo> getAllRecord(){
        return userService.fetchAllRecords();
    }
    @PutMapping("/updateRecord")
    public UserInfo updateRecord(UserInfo userInfo){
       return  userService.updateRecord(userInfo);
    }
    @DeleteMapping("/deleteRecord/{id}")
    public void deleteRecord(@PathVariable Integer id){
        userService.deleteRecord(id);
    }


}
