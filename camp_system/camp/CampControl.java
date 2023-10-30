package camp_system.camp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import camp_system.date_parser.DateParse;
import camp_system.user.User;
import camp_system.user.UserRole;

public class CampControl {
    private ArrayList <Camp> camps = new ArrayList <Camp> ();
    public Scanner scan = new Scanner(System.in);
    public DateParse dateParse = new DateParse();

    public void addTemplate(User user) throws ParseException {
        if (!(user.getRole() == UserRole.Staff)) {
            System.out.println("Only Staff can add Camps");
            return;
        }
        camps.add(new Camp("camp1", "ntu", "ntu", "camp1 in ntu!", dateParse.date("12-12-2023 10:00"), dateParse.date("15-12-2023 15:00"), dateParse.date("10-12-2023 23:59"), 100, 10, user));
    }

    public void addCamp(User user) throws ParseException {
        if (!(user.getRole() == UserRole.Staff)) {
            System.out.println("Only Staff can add Camps");
            return;
        }
        System.out.println("Please enter the following details:");
        System.out.printf("Name: "); String name = scan.nextLine();
        System.out.printf("Group: "); String group = scan.nextLine();
        System.out.printf("Location: "); String location = scan.nextLine();
        System.out.printf("Description: "); String description = scan.nextLine();
        System.out.printf("Start Date (dd-MM-yyyy HH:mm): "); Date startDate = dateParse.date(scan.nextLine());
        System.out.printf("End Date (dd-MM-yyyy HH:mm): "); Date endDate = dateParse.date(scan.nextLine());
        System.out.printf("Register By (dd-MM-yyyy HH:mm): "); Date registerBy = dateParse.date(scan.nextLine());
        System.out.printf("Total Slots (Inclusive of Committee Slots): "); int totalSlots = scan.nextInt(); scan.nextLine();
        System.out.printf("Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
        camps.add(new Camp(name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, user));
    }

    private void editMenu() {
        System.out.println("Select Attribute to Edit:");
        System.out.println("0: Visibility");
        System.out.println("1: Name");
        System.out.println("2: Group");
        System.out.println("3: Location");
        System.out.println("4: Description");
        System.out.println("5: Start Date");
        System.out.println("6: End Date");
        System.out.println("7: Register By");
        System.out.println("8: Total Slots (Inclusive of Committee Slots)");
        System.out.println("9: Committee Slots");
    }
    public void printCamps(ArrayList <Camp> camps) {
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf(i + ": ");
            camps.get(i).printCampDetails();
            System.out.println();
        }
    }
    public void editCamp(User user) throws ParseException {
        if (!(user.getRole() == UserRole.Staff)) {
            System.out.println("Only Staff can Edit Camps");
            return;
        }

        ArrayList <Camp> campList = getCamps(user);
        if (campList.size() <= 0) {
            System.out.println("No Camps Available");
            return;
        }
        printCamps(camps);
        System.out.println("Enter Camp to Edit: ");
        int index = scan.nextInt(); scan.nextLine();

        editMenu();
        int option = scan.nextInt(); scan.nextLine();
        switch (option) {
            case 0: {
                System.out.printf("Enter New Visibility: "); Boolean active = scan.nextBoolean();
                camps.get(index).setActive(active);
                break;
            }
            case 1: {
                System.out.printf("Enter New Name: "); String name = scan.nextLine();
                camps.get(index).setName(name);
                break;
            }
            case 2: {
                System.out.printf("Enter New Group: "); String group = scan.nextLine();
                camps.get(index).setGroup(group);
                break;
            }
            case 3: {
                System.out.printf("Enter New Location: "); String location = scan.nextLine();
                camps.get(index).setLocation(location);
                break;
            }
            case 4: {
                System.out.printf("Enter New Description: "); String description = scan.nextLine();
                camps.get(index).setDescription(description);
                break;
            }
            case 5: {
                System.out.printf("Enter New Start Date: "); String startDate = scan.nextLine();
                camps.get(index).setStartDate(dateParse.date(startDate));
                break;
            }
            case 6: {
                System.out.printf("Enter New End Date: "); String endDate = scan.nextLine();
                camps.get(index).setEndDate(dateParse.date(endDate));
                break;
            }
            case 7: {
                System.out.printf("Enter New Date to Register By: "); String registerBy = scan.nextLine();
                camps.get(index).setRegisterBy(dateParse.date(registerBy));
                break;
            }
            case 8: {
                System.out.printf("Enter New Total Slots: "); int totalSlots = scan.nextInt(); scan.nextLine();
                camps.get(index).setTotalSlots(totalSlots);
                break;
            }
            case 9: {
                System.out.printf("Enter New Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
                camps.get(index).setCommitteeSlots(committeeSlots);
                break;
            }
            default: {
                System.out.println("Invalid Option");
                break;
            }
        }
    }

    public void deleteCamp(User user) {
        if (!(user.getRole() == UserRole.Staff)) {
            System.out.println("Only Staff can Delete Camps");
            return;
        }

        ArrayList <Camp> campList = getCamps(user);
        if (campList.size() <= 0) {
            System.out.println("No Camps Available");
            return;
        }

        printCamps(campList);
        System.out.println("Enter Camp to Delete: ");
        int index = scan.nextInt(); scan.nextLine();
        camps.remove(campList.get(index));
    }

    public ArrayList <Camp> getAllCamps(User user) {
        if (user.getRole() == UserRole.Staff) return camps;
        return null;
    }

    public ArrayList <Camp> getCamps(String group) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.isGroup(group)) {
                result.add(camp);
            }
        }
        return result;
    }

    public ArrayList <Camp> getCamps(User user) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.enrolledAttendee(user) || camp.enrolledCommittee(user) || camp.getStaffInCharge() == user) {
                result.add(camp);
            }
        }
        return result;
    }

    public void registerAttendee(User student) {
        ArrayList <Camp> availableCamps = getCamps(student.getFaculty());
        if (camps.size() <= 0) {
            System.out.println("No Camps Available");
            return;
        }
        printCamps(availableCamps);
        System.out.println("Enter Camp to Register as Attendee: ");
        int index = scan.nextInt(); scan.nextLine();
        availableCamps.get(index).addAttendee(student);
    }

    public void registerCommittee(User student) {
        ArrayList <Camp> availableCamps = getCamps(student.getFaculty());
        if (camps.size() <= 0) {
            System.out.println("No Camps Available");
            return;
        }
        for (int i = 0; i < availableCamps.size(); i ++) {
            if (availableCamps.get(i).enrolledCommittee(student)) return;
        }
        printCamps(availableCamps);
        System.out.printf("Enter Camp to Register as Attendee: ");
        int index = scan.nextInt(); scan.nextLine();
        availableCamps.get(index).addCommittee(student);
    }

    public void withdrawAttendee(User student) {
        ArrayList <Camp> registeredCamps = getCamps(student);
        if (camps.size() <= 0) {
            System.out.println("Not Registered to any Camp");
            return;
        }
        printCamps(registeredCamps);
        System.out.printf("Enter Camp to Withdraw from as Attendee: ");
        int index = scan.nextInt(); scan.nextLine();
        registeredCamps.get(index).removeAttendee(student);
    }
}
