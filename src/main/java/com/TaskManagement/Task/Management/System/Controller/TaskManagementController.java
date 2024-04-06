package com.TaskManagement.Task.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManagement.Task.Management.System.Model.AddAdminRequest;
import com.TaskManagement.Task.Management.System.Model.UserDetails;
import com.TaskManagement.Task.Management.System.Service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class TaskManagementController {

    @Autowired
    AdminService adminService;

    @PostMapping("/addAdmin")
    public ResponseEntity<String> addPerson(@RequestBody AddAdminRequest admin) {
        String response = adminService.addAdmin(admin);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    //for drop down
    @CrossOrigin
    @GetMapping("/manager")
    public ResponseEntity<List<UserDetails>> getManagerName() {
        List<UserDetails> userDetails = adminService.getmanagers();
        return new ResponseEntity<>(userDetails, HttpStatus.FOUND);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<String> deletPerson(@PathVariable Long id) {
        boolean deleteResponse = adminService.deletePerson(id);
        if (deleteResponse) {
            return new ResponseEntity<>("Person has been Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePersonDetails/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody AddAdminRequest person ){
        try{
            String update = adminService.updatePerson(id, person);
            if(update==null){
                return new ResponseEntity<>("person not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("person details updated", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error while updating person's details: "+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

