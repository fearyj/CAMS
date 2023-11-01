package camp_system.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserControl {
    private String csvFilePath;
    private  ArrayList<User> users;
    public UserControl(String csvFilePath) {
        this.csvFilePath = csvFilePath;
        this.users = new ArrayList<>();
        readExcel(this.csvFilePath);
    }

    public void readExcel(String csvFilePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            if (values.length >= 3) {
                String name = values[0];
                String email = values[1];
                String faculty = values[2];
                String userID = email.split("@")[0]; // Extract the user ID from the email

                User user = new User(name, userID, "password", faculty); // Create a User object with a default password
                users.add(user);
            } else {
                System.err.println("Error: CSV line does not have enough values: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public ArrayList<User> getUsers() {
        return users;
    }

    public User login(String userID, String password) {

        for (User user : this.users) {
            // Check if the user ID and password match.
            if (user.getUserID().equals(userID) && user.getPassword().equals(password)) {
                // Return the user object.
                return user;
            }
        }
        // If the user ID and password do not match, return null.
        return null;
    }
    public void printUserList() {
        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getUserID());
            System.out.println("Faculty: " + user.getFaculty());
            System.out.println("Password: " + user.getPassword());
            System.out.println();
        }
    }
    public static void main(String[] args) {
        UserControl userControl = new UserControl("C:\\Users\\qzq99\\OneDrive\\Documents\\GitHub\\CAMS\\staffs.csv");
        userControl.readExcel("C:\\Users\\qzq99\\OneDrive\\Documents\\GitHub\\CAMS\\staffs.csv");
        userControl.printUserList();

        // Test case 1: A valid login
        String validUserID = "ARVI";
        String validPassword = "password";
        User validUser = userControl.login(validUserID, validPassword);

        if (validUser != null) {
            System.out.println("Login successful for user: " + validUser.getName());
        } else {
            System.out.println("Login failed for user with ID: " + validUserID);
        }

        // Test case 2: An invalid login
        String invalidUserID = "abc"; 
        String invalidPassword = "password1";
        User invalidUser = userControl.login(invalidUserID, invalidPassword);

        if (invalidUser != null) {
            System.out.println("Login successful for user: " + invalidUser.getName());
        } else {
            System.out.println("Login failed for user with ID: " + invalidUserID);
        }
    }
}
    


