package sample.database;

import sample.User;

import java.sql.*;

import static sample.Constants.*;

public class DatabaseHandler extends Configs {

    static Connection dbConnection = null;
    static Statement statement = null;

    public static Connection getDbConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:users.db");
            System.out.println("Connected!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void closeConnection() {

        try{
            if (statement != null) statement.close();

            if (dbConnection != null) dbConnection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createTables(String nameTable){

        String newTable = "CREATE TABLE IF NOT EXISTS " + nameTable +
                "( iduser INTEGER PRIMARY KEY AUTOINCREMENT," +
                "loginname VARCHAR(50)," +
                "password VARCHAR(50)," +
                "gender VARCHAR(10));";
        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            statement.execute(newTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + USER_TABLE + "(" +
                USERS_LOGIN_NAME + "," + USERS_PASSWORD + "," + USERS_GENDER + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,  user.getLoginName());
            prSt.setString(2,  user.getPassword());
            prSt.setString(3,  user.getGender());
            prSt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String selectDataUser = "SELECT * FROM " + USER_TABLE + " WHERE " + USERS_LOGIN_NAME + "=? AND "
                + USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectDataUser);
            prSt.setString(1,  user.getLoginName());
            prSt.setString(2,  user.getPassword());
            resSet = prSt.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return resSet;
    }
}
