/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.dao;

import com.fullcontrol.studentsmanagementwebportal.classes.ResulReturn;
import com.fullcontrol.studentsmanagementwebportal.classes.User;
import com.fullcontrol.studentsmanagementwebportal.controllers.DBConnectionUtil;
import com.fullcontrol.studentsmanagementwebportal.util.Constant;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lbust
 */
public class LoginDAOImpl implements LoginDAO {

    @Override
    public ResulReturn authenticate(User user) {
        ResulReturn resulReturn = new ResulReturn();
        resulReturn.setResultId(Constant.OPERATION_FAILURE);
        String sql = "SELECT * FROM students_managment.users where Login_Id=? and Password=?";
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getLoginId());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resulReturn.setResultId(Constant.OPERATION_SUCCESSFULLY);
                resulReturn.setIntValue(rs.getInt("User_Id"));
                resulReturn.setStringValue(String.valueOf(rs.getInt("Privilege_schema")));
                return resulReturn;
            } else {
                resulReturn.setResultId(Constant.OPERATION_NO_DATA);
                return resulReturn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resulReturn;
    }

    @Override
    public boolean signUp(User user) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO students_managment.users (Login_Id, Email, Password, Privilege_schema, fullName) VALUES ("
                    + "'"
                    + user.getLoginId() + "' , '"
                    + user.getEmail() + "' , '"
                    + user.getPassword() + "' , '"
                    + user.getPrivilegeSchema() + "' , '"
                    + user.getFullName() + "')";
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

}
