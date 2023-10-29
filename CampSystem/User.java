package CampSystem;

public class User {
    private String name, userID, password, faculty;

    public User (String name, String userID, String password, String faculty){
        this.name = name;
        this.userID = userID;
        this.password = "password";
        this.faculty = faculty;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID = userID;}

    public String getFaculty() {return faculty;}
    public void setFaculty(String faculty) {this.faculty = faculty;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}