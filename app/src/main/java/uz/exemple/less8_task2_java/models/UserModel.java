package uz.exemple.less8_task2_java.models;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String user_name;
    private String user_email;
    private int phone;

    public UserModel(String user_name, String user_email, int phone) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.phone = phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "\nuser_name= " + user_name +
                ", \nuser_email= " + user_email +
                ", \nphone=" + phone +
                "}";
    }
}
