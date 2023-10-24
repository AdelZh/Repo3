package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        UserServiceImpl userService = new UserServiceImpl();
        UserServiceImpl userService1=new UserServiceImpl();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Get jdbc connection");
            System.out.println("2. Create users table using jdbc");
            System.out.println("3. Save users by using jdbc");
            System.out.println("4. Remove users by using jdbc");
            System.out.println("5. Get all users by jdbc");
            System.out.println("6. Drop users table by using jdbc");
            System.out.println("7. Clean users table by using jdbc");
            System.out.println("8. Get Hibernate connection");
            System.out.println("9. Save users by using Hibernate");
            System.out.println("10. Get all users by using Hibernate");
            System.out.println("11. Remove users by using Hibernate");
            System.out.println("12. Drop table by using Hibernate");
            System.out.println("13. Clean users table by using Hibernate");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Util.getConnection();
                case 2:
                    userService.createUsersTable();
                case 3:
                    userService.saveUser("Adel", "Sam", (byte) 24);
                    userService.saveUser("Michelle", "Obama", (byte) 20);
                    break;
                case 4:
                    userService.removeUserById(1L);
                    break;
                case 5:
                    System.out.println(userService.getAllUsers());
                    break;
                case 6:
                    userService.dropUsersTable();
                    break;
                case 7:
                    userService.cleanUsersTable();
                    break;
                case 8:
                    Util.getSession();
                    break;
                case 9:
                    userService.saveUser("Adel", "Sam", (byte) 23);
                    userService.saveUser("Alina", "Smith", (byte) 21);
                    userService.saveUser("Tunuk", "Michell", (byte) 20);
                    break;
                case 10:
                    System.out.println(userService1.getAllUsers());
                    break;
                case 11:
                    userService1.removeUserById(1L);
                    break;
                case 12:
                    userService1.dropUsersTable();
                    break;
                case 13:
                    userService1.cleanUsersTable();
            }

        }
    }
}



