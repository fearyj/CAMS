package camp_system.camp;

import java.util.ArrayList;
import java.util.Date;

import camp_system.user.User;

public class Camp extends CampInformation {
    private Boolean active;
    private ArrayList <User> attendeeList, committeeList, withdrawedList;

    public Camp(
        String name, String group, String location, String description,
        Date startDate, Date endDate, Date registerBy,
        int totalSlots, int committeeSlots,
        User staffInCharge
    ) {
        super(
            name, group, location, description, 
            startDate, endDate, registerBy, 
            totalSlots, committeeSlots, 
            staffInCharge
        );
        this.active = true;
        this.committeeList = new ArrayList <User> ();
        this.attendeeList = new ArrayList <User> ();
        this.withdrawedList = new ArrayList <User> ();
    }

    public Boolean getActive() { return active; }
    protected void setActive(Boolean active) { this.active = active; }

    // Enrollment Validity Methods
    public Boolean withinDate(Date date) {
        if (date.compareTo(getRegisterBy()) <= 0) return true;
        return false;
    }
    public Boolean enrolledAttendee(User student) {
        if (attendeeList.contains(student)) return true;
        return false;
    }
    public Boolean enrolledCommittee(User student) {
        if (committeeList.contains(student)) return true;
        return false;
    }
    public Boolean enrolledStaff(User staffInCharge) {
        if (getStaffInCharge() == staffInCharge) return true;
        return false;
    }
    public Boolean withdrawed(User student) {
        if (withdrawedList.contains(student)) return true;
        return false;
    }
    public Boolean vacancyAttendee() {
        int attendeeSlots = getTotalSlots() - getCommitteeSlots();
        if (attendeeList.size() < attendeeSlots) return true;
        return false;
    }
    public Boolean vacancyCommittee() {
        if (committeeList.size() < getCommitteeSlots()) return true;
        return false;
    }

    public ArrayList <User> getAttendeeList() { return attendeeList; }
    public void addAttendee(User student) {
        if (
            vacancyAttendee() && 
            !enrolledAttendee(student) && 
            !enrolledCommittee(student) && 
            !withdrawed(student) &&
            withinDate(new Date())
        ) attendeeList.add(student);
    }
    public void removeAttendee(User student) {
        if (enrolledAttendee(student)) {
            attendeeList.remove(student);
            withdrawedList.add(student);
        }
    }

    public ArrayList <User> getCommitteeList() { return committeeList; }
    public void addCommittee(User student) {
        if (
            vacancyCommittee() && 
            !enrolledAttendee(student) && 
            !enrolledCommittee(student) && 
            !withdrawed(student) &&
            withinDate(new Date())
        ) committeeList.add(student);
    }

    public Boolean isGroup(String group) {
        if (getGroup().toLowerCase() == group.toLowerCase() || group.toLowerCase().strip() == "ntu") return true;
        return false;
    }

    public void printCampRole(User student) {
        if (enrolledAttendee(student)) System.out.println(getName() + ": Attendee");
        if (enrolledCommittee(student)) System.out.println(getName() + ": Committee");
    }

    public void printCampDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Start Date: " + getStartDate().toString());
        System.out.println("End Date: " + getEndDate().toString());
        System.out.println("Register By: " + getRegisterBy().toString());
        System.out.println("Group: " + getGroup());
        System.out.println("Location: " + getLocation());
        System.out.println("Description: " + getDescription());
        System.out.println("Attendee Slots Remaining: " + (getTotalSlots() - getCommitteeSlots() - attendeeList.size()));
        System.out.println("Committee Slots Remaining: " + (getCommitteeSlots() - committeeList.size()));
    }
}
