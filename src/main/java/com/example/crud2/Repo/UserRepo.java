package com.example.crud2.Repo;

import com.example.crud2.Entities.SpringTutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
public interface UserRepo extends JpaRepository<SpringTutorial,Long> {
    SpringTutorial findByEmail(@RequestParam String email);
    SpringTutorial findByEmailAndPassword(@RequestParam String Email,@RequestParam String password);
    SpringTutorial findByFirstNameAndLastName(@RequestParam String FirstName,@RequestParam String LastName);

}
