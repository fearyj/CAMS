package CampSystem;

public class Report {
     public void participantReport (Camp camp) throws IOException
    {
        String path = //"path to csv file";
        File file = new File(path);
        
        try (FileWriter fw = new FileWriter(file, false);
                BufferedWriter bw = new BufferedWriter(fw)) 
        {
             //camp->name is camp name or participant name?
             bw.write(camp.getName());
             bw.newLine();
               
             bw.write("Start Date: "+String.valueOf(camp.getStartDate()));
             bw.newLine();
            
             bw.write("End Date: "+String.valueOf(camp.getEndDate()));
             bw.newLine();
            
             bw.write("Registration Closing Date: "+String.valueOf(camp.getRegisterBy()));
             bw.newLine();
            
             bw.write("Group: "+camp.getGroup());
             bw.newLine();
            
             bw.write("Location: "+camp.getLocation());
             bw.newLine();
            
             bw.write("Total Slots: "+camp.getTotalSlots());
             bw.newLine();
            
             bw.write("Camp Committee Slots: "+camp.getCommitteeSlots());
             bw.newLine();
            
             bw.write("Description: "+camp.getDescription());
             bw.newLine();
            
             bw.write("Staff in Charge: "+camp.getStaffInCharge());
             bw.newLine();
            
             bw.write("Attendee List: "+camp.getAttendeeList());
             bw.newLine();
            
             bw.write("Camp Committee List: "+camp.getCommitteeList());
             bw.newLine();
             
            /*if (camp.enrolledAttendee(student)) 
            {
            	bw.write(camp.getName() + ": Attendee");
            	
            }
            if (enrolledCommittee(student)) 
            {
            	bw.write(camp.getName() + ": Committee");
            }*/
               
           }
    }
    public void performanceReport(Camp camp)
    {
    	
    }
    //in CampApp
    /*public static void main(String[] args)
    {
    	
    	Report report = new Report();
        try {
            report.participantReport(camp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
}
