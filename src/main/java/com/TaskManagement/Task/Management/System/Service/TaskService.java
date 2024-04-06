package com.TaskManagement.Task.Management.System.Service;

import java.util.List;

import com.TaskManagement.Task.Management.System.Model.AddTask;
import com.TaskManagement.Task.Management.System.Model.ManagerTaskInfo;

public interface TaskService {
    public String addTask(AddTask addTask);
    public List<ManagerTaskInfo> getManagerTask(Long managerId);
    public String updateTask(Long taskId, AddTask task);
    public boolean DeleteTask(Long taskId);
    public List<AddTask> getTaskList();
}
