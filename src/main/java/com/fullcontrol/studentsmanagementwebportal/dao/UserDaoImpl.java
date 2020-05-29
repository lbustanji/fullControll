/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullcontrol.studentsmanagementwebportal.dao;

import com.fullcontrol.studentsmanagementwebportal.classes.User;
import com.fullcontrol.studentsmanagementwebportal.controllers.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbust
 */
public class UserDaoImpl implements UserDao {

    List<User> usersList = null;
    User user = null;

    @Override
    public List<User> get() {
        String sql = "SELECT * FROM students_managment.users";
        usersList = new ArrayList();
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("User_Id"));
                user.setLoginId(rs.getString("Login_Id"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPrivilegeSchema(rs.getInt("Privilege_schema"));
                user.setStatus(rs.getInt("status"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try {
            user = new User();
            String sql = "SELECT * FROM students_managment.users where User_Id=" + id;
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("User_Id"));
                user.setLoginId(resultSet.getString("Login_Id"));
                user.setEmail(resultSet.getString("fullName"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setPrivilegeSchema(resultSet.getInt("Privilege_schema"));
                user.setStatus(resultSet.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean flag = false;
        try {
            String sql = "UPDATE students_managment.users SET Email = '" + user.getEmail() + "', "
                    + "status = '" + user.getStatus() + "', Privilege_schema = '" + user.getPrivilegeSchema() + "' where User_Id=" + user.getId();
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<User> getUsersByPrivilegeSchema(int privilegeSchema) {
        String sql = "SELECT * FROM students_managment.users where Privilege_schema=" + privilegeSchema;
        usersList = new ArrayList();
        try {
            Connection connection = DBConnectionUtil.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("User_Id"));
                user.setLoginId(rs.getString("Login_Id"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setPrivilegeSchema(rs.getInt("Privilege_schema"));
                user.setStatus(rs.getInt("status"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

}
