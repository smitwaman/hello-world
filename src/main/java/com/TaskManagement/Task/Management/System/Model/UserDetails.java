package com.TaskManagement.Task.Management.System.Model;

public class UserDetails {

    private Long userId;
    private String name;

    

    public UserDetails(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    /**
     * @return Integer return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
