package com.TaskManagement.Task.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManagement.Task.Management.System.Model.AddTask;
import com.TaskManagement.Task.Management.System.Model.ManagerTaskInfo;
import com.TaskManagement.Task.Management.System.TaskServiceImpl.TaskServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskInfoController {

    @Autowired
    TaskServiceImpl taskServiceImpl;
    
    //to add new task and assign it.
    @PostMapping("/addTask")
    public ResponseEntity<String> task(@RequestBody AddTask task){
        String response = taskServiceImpl.addTask(task);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //get the List of all Task
    @GetMapping("/TaskList")
    public ResponseEntity<List<AddTask>> getList(){
        List<AddTask> list =taskServiceImpl.getTaskList();
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
    

    //get the task by specific manager by managerId 
    @GetMapping("/getTask/{managerId}")
    public ResponseEntity<List<ManagerTaskInfo>> getTask(@PathVariable Long managerId){
        try {
            return new ResponseEntity<>(taskServiceImpl.getManagerTask(managerId),HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    // To update the task Details 
    @PutMapping("updateTask/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody AddTask updatedTask){
        try{
            String update=taskServiceImpl.updateTask(id, updatedTask);
            if(update == null){
                return new ResponseEntity<>("Task Not found",HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(update,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error found while update Task: "+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // To Delete the specific Task
    @DeleteMapping("deleteTask/{taskId}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long taskId){
        try {
            boolean response = taskServiceImpl.DeleteTask(taskId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
    }
}
