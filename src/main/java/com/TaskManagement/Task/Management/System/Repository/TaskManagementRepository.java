package com.TaskManagement.Task.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManagement.Task.Management.System.Entity.TaskManagementAdmin;

public interface TaskManagementRepository extends JpaRepository<TaskManagementAdmin,Long> {
    List<TaskManagementAdmin> findByUserType(String userType);

}
 