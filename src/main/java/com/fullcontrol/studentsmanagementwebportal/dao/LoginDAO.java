/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.dao;

import com.fullcontrol.studentsmanagementwebportal.classes.ResulReturn;
import com.fullcontrol.studentsmanagementwebportal.classes.User;

/**
 *
 * @author lbust
 */
public interface LoginDAO {

    ResulReturn authenticate(User user);

    boolean signUp(User user);
}
