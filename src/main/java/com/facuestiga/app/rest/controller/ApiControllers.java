package com.facuestiga.app.rest.controller;

import com.facuestiga.app.rest.models.User;
import com.facuestiga.app.rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired //handles all dependency injection for us
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "welcome";
    }

    /**
     * Return all of our User from the database
     */
    @GetMapping(value = "/users")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    /**
     * Saving a user
     * When we are saving something to the database it'll be a Post (@PostMapping)
     * @return
     */
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }

    /**
     * Update a user from the database
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        //find a user...
        User updateUser = userRepo.findById(id).get();
        //set the user attribute from the parameter to the updated user
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "Updating...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);//passing the user that we want to DELETE
        return "Delete user with id: " + id + "...";
    }

}
