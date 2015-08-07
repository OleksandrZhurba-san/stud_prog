package database;

import constants.Constants;
import entity.Role;
import entity.Students;
import entity.Users;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBConnection {
    private Connection connection = null;
    private ResultSet resultSet = null;

    private static PreparedStatement getRoleById;
    private static PreparedStatement loadRoles;
    private static PreparedStatement getUserDataByLogin;
    private static PreparedStatement getUserRoleByUserId;
    private static PreparedStatement loadStudents;
    private static PreparedStatement createNewStudent;
    private static PreparedStatement loadDisciplines;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Constants.CONNECTION_URL,Constants.CONNECTION_LOGIN,Constants.CONNECTION_PASSWORD);
            loadPreparedStatements();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPreparedStatements() {
        try {
            loadRoles = connection.prepareStatement("SELECT * FROM role");
            getRoleById = connection.prepareStatement("SELECT * FROM role WHERE id = ?");
            getUserDataByLogin = connection.prepareStatement("SELECT * FROM user WHERE login = ?");
            getUserRoleByUserId = connection.prepareStatement("SELECT * FROM user_role WHERE id_user = ?");
            loadStudents = connection.prepareStatement("SELECT * FROM students");
            createNewStudent = connection.prepareStatement("INSERT INTO students (name, group, date) VALUES (?, ?, ?, ?)");
            loadDisciplines = connection.prepareStatement("SELECT * FROM discipline");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closePreparedStatements() {
        try {
            loadRoles.close();
            getRoleById.close();
            getUserDataByLogin.close();
            getUserRoleByUserId.close();
            loadDisciplines.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Role getRoleById(int id){
        resultSet = null;
        Role role = new Role();
        try {
            getRoleById.setInt(1, id);
            resultSet = getRoleById.executeQuery();
            while (resultSet.next()) {
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
    public List<Role> loadRoles() {
        resultSet = null;
        List<Role> roles = new LinkedList<Role>();
        try {
            resultSet = loadRoles.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
    public Users getUserDataByLogin (String login) {
        resultSet = null;
        Users user = new Users();
        try {
            getUserDataByLogin.setString(1, login);
            resultSet = getUserDataByLogin.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public List<Role> getUserRoleByUserId(int id) {
        resultSet = null;
        List<Role> roles = new LinkedList<Role>();
        try {
            getUserRoleByUserId.setInt(1, id);
            resultSet = getUserRoleByUserId.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id_role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public List<Students> loadStudents() {
        resultSet = null;
        List<Students> studentsList = new LinkedList<Students>();
        try {
            resultSet = loadStudents.executeQuery();
            while (resultSet.next()) {
                Students student = new Students();
                student.setFirst_name(resultSet.getString("name"));
                student.setLast_name(resultSet.getString("last_name"));
                student.setGroup(resultSet.getString("group"));
                student.setDate(resultSet.getString("date"));
                studentsList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }
    public void CreateNewStudent (){

    }

    public List<String> loadDiscipline() {
        resultSet = null;
        List<String> disciplines = new LinkedList<String>();
        try{
            resultSet = loadDisciplines.executeQuery();
            while (resultSet.next()) {
                disciplines.add(resultSet.getString("discipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }
}
