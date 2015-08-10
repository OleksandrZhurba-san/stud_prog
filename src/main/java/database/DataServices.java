package database;

import constants.Constants;
import entity.Role;
import entity.Students;
import entity.Users;

import java.util.ArrayList;
import java.util.List;

public class DataServices {
    private static List<DBConnection> connectionsPool = new ArrayList<DBConnection>();
    private static Object monitor = new Object();

    public boolean init() {
        try {
            for (int i = 0; i < Constants.CONNECTION_POOL_SIZE; i++) {
                newConnection();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void newConnection() {
        DBConnection connection = new DBConnection();
        synchronized (monitor) {
            connectionsPool.add(connection);
        }
    }
    public DBConnection getDBConnection(){
        synchronized (monitor){
            if (connectionsPool.isEmpty()) {
                newConnection();
            }
            DBConnection connection = connectionsPool.remove(0);
            return connection;
        }
    }
    public void putDBConnection(DBConnection connection) {
        synchronized (monitor) {
            connectionsPool.add(connection);
        }
    }
    public void closeConnection(){
        DBConnection connection = getDBConnection();
        connection.closePreparedStatements();
        this.putDBConnection(connection);
    }
    public Role getRoleRoleId (int id) {
        DBConnection connection = getDBConnection();
        Role role = connection.getRoleById(id);
        return role;
    }
    public List<Role> loadRoles(){
        DBConnection connection = getDBConnection();
        List<Role> roles = connection.loadRoles();
        return roles;
    }
    public Users getUserDataByLogin (String login) {
        DBConnection connection = getDBConnection();
        Users user = connection.getUserDataByLogin(login);
        return user;
    }
    public List<Role> getUserRoleByUserId(int id) {
        DBConnection connection = getDBConnection();
        List<Role> roles = connection.getUserRoleByUserId(id);
        return roles;
    }
    public List<Students> loadStudents (){
        DBConnection connection = getDBConnection();
        List<Students> students = connection.loadStudents();
        return students;
    }
    public void addStudent(String first_name, String second_name, String group, String date){
        DBConnection connection = getDBConnection();
        connection.addStudent(first_name,second_name,group,date);
    }

    public List<String> loadDiscipline() {
        DBConnection connection = getDBConnection();
        List<String> discipline = connection.loadDiscipline();
        return discipline;
    }
    public void addDiscipline (String discipline) {
        DBConnection connection = getDBConnection();
        connection.addDiscipline(discipline);
    }
}
