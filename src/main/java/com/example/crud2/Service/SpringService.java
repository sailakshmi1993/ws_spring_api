package com.example.crud2.Service;

import com.example.crud2.Entities.SpringTutorial;
import com.example.crud2.Repo.UserRepo;
import com.example.crud2.SpringDTO.EmailValidationDTO;
import com.example.crud2.SpringDTO.UserLoginDTO;
import com.example.crud2.customException.CustomException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SpringService {
    @Autowired
    private UserRepo userRepo;
    public SpringTutorial insertRecord(@PathVariable SpringTutorial springTutorial) {
        return userRepo.save(springTutorial);
    }
    public Optional<SpringTutorial> fetchRecord(Long id) {
        return userRepo.findById(id);
    }
    public List<SpringTutorial> fetchAllRecords() {
        return userRepo.findAll();
    }
    public SpringTutorial updateRecord( SpringTutorial springTutorial){
       SpringTutorial obj= userRepo.findByEmail(springTutorial.getEmail());
        obj.setFirstName(springTutorial.getFirstName());
        obj.setLastName(springTutorial.getLastName());
        obj.setPassword(springTutorial.getPassword());
        return userRepo.save(springTutorial);
    }
    public void deleteRecord(Long id) {
        userRepo.deleteById(id);
    }
    public String checkEmail(EmailValidationDTO emailValidationDTO) {
        if (emailValidationDTO.getEmail() != null) {
            SpringTutorial obj = userRepo.findByEmail(emailValidationDTO.getEmail());
            if (Objects.nonNull(obj)) {
                return "Email address is already exist";
            } else {
                return  "Email address not exist";
            }
        }
        else{
            throw new CustomException("Enter valid email");
        }
    }
    public String checkUserLogin(UserLoginDTO userLoginDTO) {
        if (userLoginDTO.getEmail() != null && userLoginDTO.getPassword() != null) {
            SpringTutorial obj = userRepo.findByEmailAndPassword(userLoginDTO.getPassword(), (userLoginDTO.getEmail()));
            if (Objects.nonNull(obj)) {
                return "Login Success";
            }
            else {
                return "Wrong";
            }
        }
        else {
            throw new CustomException("please enter valid data");
        }
    }

    }








