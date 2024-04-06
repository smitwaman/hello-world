package com.TaskManagement.Task.Management.System.Entity;


import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="taskinfo")
public class TaskInfo {
    @Id
    @Column(name="task_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long taskId;

    @Column(name="task_name")
    private String taskName;

    @Column(name="description")
    private String description;

    @Column(name="start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name ="status")
    private String status;

    @Column(name="asign_to")
    private Long asignTo;

    public TaskInfo() {
    }

    public TaskInfo(String taskName, String description, Timestamp startDate, Timestamp endDate, String status,
            Long asignTo) {
        this.taskName = taskName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.asignTo = asignTo;
    }

    /**
     * @return Long return the taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * @return String return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
 
     
    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return int return the startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * @return int return the endDate
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Long return the asignTo
     */
    public Long getAsignTo() {
        return asignTo;
    }

    /**
     * @param asignTo the asignTo to set
     */
    public void setAsignTo(Long asignTo) {
        this.asignTo = asignTo;
    }

}
