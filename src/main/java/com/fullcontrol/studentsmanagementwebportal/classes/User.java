/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fullcontrol.studentsmanagementwebportal.classes;

/**
 *
 * @author lbust
 */
public class User {
    private  int Id;
    private  int status;
    private  int privilegeSchema;
    private  String loginId;
    private  String password;
    private  String email;
    private  String fullName;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrivilegeSchema() {
        return privilegeSchema;
    }

    public void setPrivilegeSchema(int privilegeSchema) {
        this.privilegeSchema = privilegeSchema;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
