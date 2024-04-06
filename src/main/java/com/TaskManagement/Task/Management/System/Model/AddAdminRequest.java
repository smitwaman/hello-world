package com.TaskManagement.Task.Management.System.Model;


public class AddAdminRequest {

    private String adminName;

    private String mobileNumber;

    private String email;

    private String password;

    private String userType;
    
    private String reportsTo;

    /**
     * @return String return the adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName the adminName to set
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * @return String return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }       

    /**
     * @return String return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return String return the reportsTo
     */
    public String getReportsTo() {
        return reportsTo;
    }

    /**
     * @param reportsTo the reportsTo to set
     */
    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }
}
