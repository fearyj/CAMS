package camp_system.testing;

// import java.text.ParseException;
// import java.util.ArrayList;
// import java.util.Scanner;

// import CampSystem.Camp;
// import CampSystem.CampControl;
// import CampSystem.Staff;
// import CampSystem.Student;

public class CampTest {
    // public static Scanner scan = new Scanner(System.in);

    // public static void printCamps(ArrayList <Camp> camps) {
    //     for (int i = 0; i < camps.size(); i ++) {
    //         System.out.printf(i + ": ");
    //         camps.get(i).printCampDetails();
    //         System.out.println();
    //     }
    // }
    // public static void main(String[] args) throws ParseException {
    //     Staff staff1 = new Staff();
    //     Student student1 = new Student();
    //     CampControl campControl = new CampControl();
    //     while (true) {
    //         System.out.println("1: Add Camp");
    //         System.out.println("2: Add Template Camp");
    //         System.out.println("3: View Camps");
    //         System.out.println("4: Edit Camp");
    //         System.out.println("5: Delete Camp");
    //         System.out.println("6: Register Attendee");
    //         System.out.println("7: Register Committee");
    //         System.out.println("8: Withdraw Camp");
    //         System.out.printf("Enter Option: ");
    //         int option = scan.nextInt(); scan.nextLine();
    //         switch (option) {
    //             case 1: {
    //                 campControl.addCamp(staff1);
    //                 break;
    //             }
    //             case 2: {
    //                 campControl.addTemplate(staff1);
    //                 break;
    //             }
    //             case 3: {
    //                 ArrayList <Camp> camps = campControl.getCamps(staff1);
    //                 if (camps.size() <= 0) {
    //                     System.out.println("No Camps Available");
    //                     break;
    //                 }
    //                 printCamps(camps);
    //                 break;
    //             }
    //             case 4: {
    //                 ArrayList <Camp> camps = campControl.getCamps(staff1);
    //                 if (camps.size() <= 0) {
    //                     System.out.println("No Camps Available");
    //                     break;
    //                 }
    //                 printCamps(camps);
    //                 System.out.println("Enter Camp to Edit: ");
    //                 int index = scan.nextInt(); scan.nextLine();
    //                 campControl.editCamp(index);
    //                 break;
    //             }
    //             case 5: {
    //                 ArrayList <Camp> camps = campControl.getCamps(staff1);
    //                 if (camps.size() <= 0) {
    //                     System.out.println("No Camps Available");
    //                     break;
    //                 }
    //                 System.out.println("Enter Camp to Delete: ");
    //                 int index = scan.nextInt(); scan.nextLine();
    //                 campControl.deleteCamp(index);
    //                 break;
    //             }
    //             case 6: {
    //                 ArrayList <Camp> camps = campControl.getCamps(staff1);
    //                 if (camps.size() <= 0) {
    //                     System.out.println("No Camps Available");
    //                     break;
    //                 }
    //                 System.out.println("Enter Camp to Register as Attendee: ");
    //                 int index = scan.nextInt(); scan.nextLine();
    //                 campControl.registerAttendee(camps.get(index), student1);
    //                 break;
    //             }
    //             case 7: {
    //                 ArrayList <Camp> camps = campControl.getCamps(staff1);
    //                 if (camps.size() <= 0) {
    //                     System.out.println("No Camps Available");
    //                     break;
    //                 }
    //                 System.out.println("Enter Camp to Register as Committee: ");
    //                 int index = scan.nextInt(); scan.nextLine();
    //                 campControl.registerCommittee(camps.get(index), student1);
    //                 break;
    //             }
    //             case 8: {
    //                 ArrayList <Camp> camps = campControl.getCamps(staff1);
    //                 if (camps.size() <= 0) {
    //                     System.out.println("No Camps Available");
    //                     break;
    //                 }
    //                 System.out.println("Enter Camp to Withdraw as Attendee: ");
    //                 int index = scan.nextInt(); scan.nextLine();
    //                 campControl.withdrawAttendee(camps.get(index), student1);
    //                 break;
    //             }
    //         }
    //     }
    // }
}
