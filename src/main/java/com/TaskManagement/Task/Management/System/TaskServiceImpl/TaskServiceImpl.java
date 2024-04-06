package com.TaskManagement.Task.Management.System.TaskServiceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;

import com.TaskManagement.Task.Management.System.Entity.TaskInfo;
import com.TaskManagement.Task.Management.System.Model.AddTask;
import com.TaskManagement.Task.Management.System.Model.ManagerTaskInfo;
import com.TaskManagement.Task.Management.System.Repository.TaskInfoRepo;
import com.TaskManagement.Task.Management.System.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskInfoRepo taskRepository;

    // to add a Task.
    @Override
    public String addTask(AddTask addTask) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Timestamp startDate = new Timestamp(sdf.parse(addTask.getStartDate()).getTime());
            Timestamp endDate = new Timestamp(sdf.parse(addTask.getEndDate()).getTime());
            TaskInfo taskinfo = new TaskInfo(addTask.getTaskName(), addTask.getDescription(), startDate, endDate,
                    addTask.getStatus(), addTask.getAsignTo());
            taskRepository.save(taskinfo);
            return "Task successfully Added";
        } catch (Exception e) {
            return "Task addition failed";
        }
    }

    // To get the specific task using specific id.
    @Override
    public List<ManagerTaskInfo> getManagerTask(Long managerId) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {

            List<ManagerTaskInfo> response = new ArrayList<>();
            List<TaskInfo> taskInfos = taskRepository.findByAsignTo(managerId);
            for (TaskInfo taskInfo : taskInfos) {
                ManagerTaskInfo managerTaskInfo = new ManagerTaskInfo();
                managerTaskInfo.setTaskName(taskInfo.getTaskName());
                managerTaskInfo.setDescription(taskInfo.getDescription());
                // to change date formate
                managerTaskInfo.setStartDate(sdf.format(new Date(taskInfo.getStartDate().getTime())));
                managerTaskInfo.setEndDate(sdf.format(new Date(taskInfo.getEndDate().getTime())));
                managerTaskInfo.setStatus(taskInfo.getStatus());
                response.add(managerTaskInfo);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    // To update details the specific task using id.
    @Override
    public String updateTask(Long taskId, AddTask updatedTask) {
        Optional<TaskInfo> optional = taskRepository.findById(taskId);
        if (!optional.isPresent()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // to convert client side date into Timestap format to add in database.
            Timestamp startDate = new Timestamp(sdf.parse(updatedTask.getStartDate()).getTime());
            Timestamp endDate = new Timestamp(sdf.parse(updatedTask.getEndDate()).getTime());

            TaskInfo taskInfo = optional.get();
            taskInfo.setTaskName(updatedTask.getTaskName());
            taskInfo.setDescription(updatedTask.getDescription());
            taskInfo.setStartDate(startDate);
            taskInfo.setEndDate(endDate);
            taskInfo.setStatus(updatedTask.getStatus());
            taskInfo.setAsignTo(updatedTask.getAsignTo());

            // to save in database
            taskRepository.save(taskInfo);
            return "details are successfully Updated";
        } catch (Exception e) {
            return "Error: details not added";
        }
    }

    @Override
    public boolean DeleteTask(Long taskId) {
        Optional<TaskInfo> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }

    @Override
    public List<AddTask> getTaskList() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<AddTask> response = new ArrayList<>();
       List<TaskInfo> taskLists = taskRepository.findAll(Sort.by("taskId").descending());
       for(TaskInfo taskList : taskLists){
        AddTask addTask = new AddTask();
        addTask.setTaskName(taskList.getTaskName());
        addTask.setDescription(taskList.getDescription());
        addTask.setStartDate(sdf.format(new Date(taskList.getStartDate().getTime())));
        addTask.setEndDate(sdf.format(new Date(taskList.getEndDate().getTime())));
        addTask.setStatus(taskList.getStatus());
        addTask.setAsignTo(taskList.getAsignTo());

        response.add(addTask);
    }
    return response;
    }

}
