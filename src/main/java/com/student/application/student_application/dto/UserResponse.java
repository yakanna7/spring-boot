package com.student.application.student_application.dto;

import java.util.List;

public class UserResponse {
    List<UserDTO> userList;
    int  statusCode;
    String message;
    public UserResponse(List<UserDTO> userList, int statusCode, String message) {
        this.userList = userList;
        this.statusCode = statusCode;
        this.message = message;
    }

    public  UserResponse(){};

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
