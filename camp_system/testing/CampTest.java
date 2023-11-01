package camp_system.testing;

import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.date_parser.DateParse;
import camp_system.user.User;
import camp_system.user.Faculty;
import camp_system.user.Role;

public class CampTest {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        DateParse dateParse = new DateParse();
        User staff1 = new User("staff1", "staff1", "password", Faculty.NTU, Role.STAFF);
        User student1 = new User("student1", "student1", "password", Faculty.NTU, Role.STUDENT);
        User student2 = new User("student2", "student2", "password", Faculty.NTU, Role.STUDENT);
        CampControl campControl = new CampControl();
        while (true) {
            System.out.println("1: Add Camp");
            System.out.println("2: Add Template Camp");
            System.out.println("3: View Available Camps");
            System.out.println("4: View Involved Camps");
            System.out.println("5: Edit Camp");
            System.out.println("6: Delete Camp");
            System.out.println("7: Register Attendee");
            System.out.println("8: Register Committee");
            System.out.println("9: Withdraw Camp");
            System.out.printf("Enter Option: ");
            int option = scan.nextInt(); scan.nextLine();
            switch (option) {
                case 1: {
                    System.out.printf("Name: "); String name = scan.nextLine();
                    System.out.printf("Group: "); Faculty group = Faculty.fromString(scan.nextLine());
                    System.out.printf("Location: "); String location = scan.nextLine();
                    System.out.printf("Description: "); String description = scan.nextLine();
                    System.out.printf("Start Date: "); Date startDate = dateParse.date(scan.nextLine());
                    System.out.printf("End Date: "); Date endDate = dateParse.date(scan.nextLine());
                    System.out.printf("Register By: "); Date registerBy = dateParse.date(scan.nextLine());
                    System.out.printf("Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
                    System.out.printf("Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
                    Camp campAdd = new Camp(name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, staff1);
                    campControl.addCamp(staff1, campAdd);
                    break;
                }
                case 2: {
                    campControl.addTemplate(staff1);
                    break;
                }
                case 3: {
                    ArrayList <Camp> availableCamps = campControl.getCamps(student1.getFaculty());
                    if (availableCamps.size() <= 0) {
                        System.out.println("No Camps Available");
                        break;
                    }
                    campControl.printCamps(availableCamps);
                    break;
                }
                case 4: {
                    ArrayList <Camp> registeredCamps = campControl.getCamps(student1);
                    if (registeredCamps.size() <= 0) {
                        System.out.println("No Camps Registered");
                        break;
                    }
                    campControl.printCamps(registeredCamps);
                    break;
                }
                case 5: {
                    ArrayList <Camp> createdCamps = campControl.getCamps(staff1);
                    campControl.printCamps(createdCamps);
                    // campControl.editCamp(student1);
                    break;
                }
                case 6: {
                    // campControl.deleteCamp(student1);
                    break;
                }
                case 7: {
                    // campControl.registerAttendee(student1);
                    break;
                }
                case 8: {
                    // campControl.registerCommittee(student1);
                    break;
                }
                case 9: {
                    // campControl.withdrawAttendee(student1);
                    break;
                }
            }
        }
    }
}
