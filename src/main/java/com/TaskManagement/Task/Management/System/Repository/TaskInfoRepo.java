package com.TaskManagement.Task.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManagement.Task.Management.System.Entity.TaskInfo;

public interface TaskInfoRepo extends JpaRepository<TaskInfo,Long> {
    public List<TaskInfo> findByAsignTo(Long managerId);
     
}
