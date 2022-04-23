package models;

import props.Users;

public interface IUsers {
    boolean usersLogin(String email, String password);
    int usersUpdate(Users users);
    int usersInsert(Users users);
    int usersForgotPassword(Users users);
}
