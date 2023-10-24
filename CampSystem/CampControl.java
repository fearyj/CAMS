package CampSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CampControl {
    private ArrayList <Camp> camps = new ArrayList <Camp> ();
    public Scanner scan = new Scanner(System.in);

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public static Date date(String source) throws ParseException {
        return dateFormatter.parse(source);
    }

    public void addTemplate(Staff staff) throws ParseException {
        camps.add(new Camp("camp1", "ntu", "ntu", "camp1 in ntu!", date("12-12-2023 10:00"), date("15-12-2023 15:00"), date("10-12-2023 23:59"), 100, 10, staff));
    }

    public void addCamp(Staff staff) throws ParseException {
        System.out.println("Please enter the following details:");
        System.out.printf("Name: "); String name = scan.nextLine();
        System.out.printf("Group: "); String group = scan.nextLine();
        System.out.printf("Location: "); String location = scan.nextLine();
        System.out.printf("Description: "); String description = scan.nextLine();
        System.out.printf("Start Date (dd-MM-yyyy HH:mm): "); Date startDate = date(scan.nextLine());
        System.out.printf("End Date (dd-MM-yyyy HH:mm): "); Date endDate = date(scan.nextLine());
        System.out.printf("Register By (dd-MM-yyyy HH:mm): "); Date registerBy = date(scan.nextLine());
        System.out.printf("Total Slots (Inclusive of Committee Slots): "); int totalSlots = scan.nextInt(); scan.nextLine();
        System.out.printf("Committee Slots: "); int committeeSlots = scan.nextInt(); scan.nextLine();
        camps.add(new Camp(name, group, location, description, startDate, endDate, registerBy, totalSlots, committeeSlots, staff));
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
    public void editCamp(int index) throws ParseException {
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
                camps.get(index).setStartDate(date(startDate));
                break;
            }
            case 6: {
                System.out.printf("Enter New End Date: "); String endDate = scan.nextLine();
                camps.get(index).setEndDate(date(endDate));
                break;
            }
            case 7: {
                System.out.printf("Enter New Date to Register By: "); String registerBy = scan.nextLine();
                camps.get(index).setRegisterBy(date(registerBy));
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

    public void deleteCamp(int index) {
        camps.remove(index);
    }

    public Camp getCamp(int index) {
        return camps.get(index);
    }

    public ArrayList <Camp> getCamps() {
        return camps;
    }

    public ArrayList <Camp> getCamps(String group) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getGroup() == group) {
                result.add(camp);
            }
        }
        return result;
    }

    public ArrayList <Camp> getCamps(Student student) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp : camps) {
            if (camp.enrolledAttendee(student) || camp.enrolledCommittee(student)) {
                result.add(camp);
            }
        }
        return result;
    }

    public ArrayList <Camp> getCamps(Staff staff) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp : camps) {
            if (camp.enrolledStaff(staff)) {
                result.add(camp);
            }
        }
        return result;
    }

    public void registerAttendee(Camp camp, Student student) {
        camp.addAttendee(student);
    }

    public void registerCommittee(Camp camp, Student student) {
        for (Camp campItem : camps) {
            if (campItem.enrolledCommittee(student)) return;
        }
        camp.addCommittee(student);
    }

    public void withdrawAttendee(Camp camp, Student student) {
        camp.removeAttendee(student);
    }
}
