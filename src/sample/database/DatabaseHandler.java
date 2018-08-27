package sample.database;

import sample.User;

import java.sql.*;

import static sample.Constants.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    /*public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + dbTimeZone;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }*/

    public Connection getDbConnection(){
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

    public void signUpUser(User user){
        String insert = "INSERT INTO " + USER_TABLE + "(" +
                USERS_LOGIN_NAME + "," + USERS_PASSWORD + "," + USERS_GENDER + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,  user.getLoginName());
            prSt.setString(2,  user.getPassword());
            prSt.setString(3,  user.getGender());
            prSt.executeUpdate();
            //Statement statement = getDbConnection().createStatement();
            //statement.executeUpdate(insert);

        } catch (SQLException e) {
            e.printStackTrace();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
