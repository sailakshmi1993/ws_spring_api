package com.example.crud2.controller;

import com.example.crud2.Entities.SpringTutorial;
import com.example.crud2.Service.SpringService;
import com.example.crud2.SpringDTO.EmailValidationDTO;
import com.example.crud2.SpringDTO.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController{
    @Autowired
    private SpringService springService;
    @PostMapping("/create")
    public SpringTutorial createRecord(@RequestBody SpringTutorial springTutorial){
      return springService.insertRecord(springTutorial);
    }
    @GetMapping("/fetchRecord/{id}")
    public Optional<SpringTutorial> getRecord(@PathVariable Long id){
        return springService.fetchRecord(id);
    }
    @GetMapping("/fetchAllRecords")
    public List <SpringTutorial >getAllRecords(){
      return  springService.fetchAllRecords();
}
    @DeleteMapping("/deleteRecord/{id}")
    public void deleteRecord(@PathVariable Long id){
        springService.deleteRecord(id);
    }
    @PutMapping("/updateRecord")
    public SpringTutorial updateRecord( SpringTutorial springTutorial){
        return springService.updateRecord(springTutorial);
    }
    @PostMapping("/checkLogin")
    public String checkUserLogin(@RequestBody UserLoginDTO userLoginDTO){
        return springService.checkUserLogin(userLoginDTO);
    }
    @PostMapping("/checkEmail")
    public  String checkEmail(@RequestBody EmailValidationDTO emailValidationDTO){
        return springService.checkEmail(emailValidationDTO);
    }


}

