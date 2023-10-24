package CampSystem;

import java.util.ArrayList;
import java.util.Date;

public class Camp {
    private Boolean active;
    private String name, group, location, description;
    private Date startDate, endDate, registerBy;
    private int totalSlots, committeeSlots;
    private ArrayList <Student> attendeeList, committeeList, withdrawedList;
    private Staff staffInCharge;

    public Camp(
        String name,
        String group,
        String location,
        String description,
        Date startDate,
        Date endDate,
        Date registerBy,
        int totalSlots,
        int committeeSlots,
        Staff staffInCharge
    ) {
        this.active = true;
        this.name = name;
        this.group = group;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registerBy = registerBy;
        this.totalSlots = totalSlots;
        this.committeeSlots = committeeSlots;
        this.staffInCharge = staffInCharge;
        this.committeeList = new ArrayList <Student> ();
        this.attendeeList = new ArrayList <Student> ();
        this.withdrawedList = new ArrayList <Student> ();
    }

    // Accessors and Mutators
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getRegisterBy() { return registerBy; }
    public void setRegisterBy(Date registerBy) { this.registerBy = registerBy; }

    public int getTotalSlots() { return totalSlots; }
    public void setTotalSlots(int totalSlots) { this.totalSlots = totalSlots; }

    public int getCommitteeSlots() { return committeeSlots; }
    public void setCommitteeSlots(int committeeSlots) { this.committeeSlots = committeeSlots; }

    public Staff getStaffInCharge() { return staffInCharge; }
    public void setStaffInCharge(Staff staffInCharge) { this.staffInCharge = staffInCharge; }

    // Enrollment Validity Methods
    public Boolean withinDate(Date date) {
        if (date.compareTo(registerBy) <= 0) return true;
        return false;
    }
    public Boolean enrolledAttendee(Student student) {
        if (attendeeList.contains(student)) return true;
        return false;
    }
    public Boolean enrolledCommittee(Student student) {
        if (committeeList.contains(student)) return true;
        return false;
    }
    public Boolean enrolledStaff(Staff staffInCharge) {
        if (this.staffInCharge == staffInCharge) return true;
        return false;
    }
    public Boolean withdrawed(Student student) {
        if (withdrawedList.contains(student)) return true;
        return false;
    }
    public Boolean vacancyAttendee() {
        int attendeeSlots = totalSlots - committeeSlots;
        if (attendeeList.size() < attendeeSlots) return true;
        return false;
    }
    public Boolean vacancyCommittee() {
        if (committeeList.size() < committeeSlots) return true;
        return false;
    }

    public ArrayList <Student> getAttendeeList() { return attendeeList; }
    public void addAttendee(Student student) {
        if (
            vacancyAttendee() && 
            !enrolledAttendee(student) && 
            !enrolledCommittee(student) && 
            !withdrawed(student) &&
            withinDate(new Date())
        ) attendeeList.add(student);
    }
    public void removeAttendee(Student student) {
        if (enrolledAttendee(student)) {
            attendeeList.remove(student);
            withdrawedList.add(student);
        }
    }

    public ArrayList <Student> getCommitteeList() { return committeeList; }
    public void addCommittee(Student student) {
        if (
            vacancyCommittee() && 
            !enrolledAttendee(student) && 
            !enrolledCommittee(student) && 
            !withdrawed(student) &&
            withinDate(new Date())
        ) committeeList.add(student);
    }

    public Boolean isGroup(String group) {
        if (this.group == group || group.toLowerCase().strip() == "ntu") return true;
        return false;
    }

    public void printCampRole(Student student) {
        if (enrolledAttendee(student)) System.out.println(name + ": Attendee");
        if (enrolledCommittee(student)) System.out.println(name + ": Committee");
    }

    public void printCampDetails() {
        System.out.println("Name: " + name);
        System.out.println("Start Date: " + startDate.toString());
        System.out.println("End Date: " + endDate.toString());
        System.out.println("Register By: " + registerBy.toString());
        System.out.println("Group: " + group);
        System.out.println("Location: " + location);
        System.out.println("Description: " + description);
        System.out.println("Attendee Slots Remaining: " + (totalSlots - committeeSlots - attendeeList.size()));
        System.out.println("Committee Slots Remaining: " + (committeeSlots - committeeList.size()));
    }
}
