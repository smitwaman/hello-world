package com.TaskManagement.Task.Management.System.Model;


public class AddTask {
    
    private String taskName;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private Long asignTo;

    public AddTask(){

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

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
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