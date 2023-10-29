package CampSystem;

public class Student extends User{
    private boolean campCommittee = false;
    
    public Student(String name, String userID, String password, String facultyInfo){
        super(name, userID, password, facultyInfo);
    }
        
}
