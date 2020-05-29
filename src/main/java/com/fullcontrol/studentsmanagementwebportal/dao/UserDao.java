/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.dao;

import com.fullcontrol.studentsmanagementwebportal.classes.User;
import java.util.List;

/**
 *
 * @author lbust
 */
public interface UserDao {

    List<User> get();

    List<User> getUsersByPrivilegeSchema(int privilegeSchema);

    User getUser(int id);

    boolean update(User user);
}
