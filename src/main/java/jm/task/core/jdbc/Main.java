package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("John", "Do", (byte) 35);
        userService.saveUser("Kim", "Kiduk", (byte) 55);
        userService.saveUser("Ingrid", "Stark", (byte) 25);
        userService.saveUser("Denzel ", "Washington", (byte) 69);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
