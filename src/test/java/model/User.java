package model;

public class User {
    String username;
    String password;

    public User () {
    }
    public String GetUsername () {
        return username;
    }

    public void SetUsername (String username) {
         this.username = username;
    }

    public String GetPassword() { return password;
    }
}
