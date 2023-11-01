package camp_system.camp;

import java.util.Date;

import camp_system.user.Faculty;
import camp_system.user.User;

public class CampInformation {
    private String name, location, description;
    private Date startDate, endDate, registerBy;
    private int totalSlots, committeeSlots;
    private User staffInCharge;
    Faculty group;
    
    public CampInformation(
        String name,
        Faculty group,
        String location,
        String description,
        Date startDate,
        Date endDate,
        Date registerBy,
        int totalSlots,
        int committeeSlots,
        User staffInCharge
    ) {
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
    }

    public String getName() { return name; }
    protected void setName(String name) { this.name = name; }

    public Date getStartDate() { return startDate; }
    protected void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    protected void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getRegisterBy() { return registerBy; }
    protected void setRegisterBy(Date registerBy) { this.registerBy = registerBy; }

    public Faculty getGroup() { return group; }
    protected void setGroup(Faculty group) { this.group = group; }

    public String getLocation() { return location; }
    protected void setLocation(String location) { this.location = location; }

    public int getTotalSlots() { return totalSlots; }
    protected void setTotalSlots(int totalSlots) { this.totalSlots = totalSlots; }

    public int getCommitteeSlots() { return committeeSlots; }
    protected void setCommitteeSlots(int committeeSlots) { this.committeeSlots = committeeSlots; }
    
    public String getDescription() { return description; }
    protected void setDescription(String description) { this.description = description; }

    public User getStaffInCharge() { return staffInCharge; }
    protected void setStaffInCharge(User staffInCharge) { this.staffInCharge = staffInCharge; }
}
