package camp_system.camp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CampFilter {
    public Scanner scan = new Scanner(System.in);

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public static Date date(String source) throws ParseException {
        return dateFormatter.parse(source);
    }

    public void filterMenu() {
        System.out.println("Select Filter Field:");
        System.out.println("0: Group");
        System.out.println("1: Location");
        System.out.println("2: Start after Specific Date");
        System.out.println("3: End before Specific Date");
        System.out.println("4: No Filter");
    }
    public void sortMenu() {
        System.out.println("Select Sort Method:");
        System.out.println("0: Group");
        System.out.println("1: Location");
        System.out.println("2: Start Date");
        System.out.println("3: End Date");
        System.out.println("4: Alphabetical Order (Default)");
    }
    public void orderMenu() {
        System.out.println("Select Order:");
        System.out.println("0: Ascending");
        System.out.println("1: Descending");
    }
    
    public ArrayList <Camp> filterCamps(ArrayList <Camp> camps) throws ParseException {
        ArrayList <Camp> result = new ArrayList <Camp> ();

        filterMenu();
        int option = scan.nextInt(); scan.nextLine();
        switch (option) {
            case 0: {
                System.out.printf("Enter Group: ");
                String group = scan.nextLine();
                for (Camp camp: camps) {
                    if (camp.getGroup().toLowerCase() == group.toLowerCase()) {
                        result.add(camp);
                    }
                }
                break;
            }
            case 1: {
                System.out.printf("Enter Location: ");
                String location = scan.nextLine();
                for (Camp camp: camps) {
                    if (camp.getLocation().toLowerCase() == location.toLowerCase()) {
                        result.add(camp);
                    }
                }
                break;
            }
            case 2: {
                System.out.printf("Enter Start Date: ");
                String startDate = scan.nextLine();
                for (Camp camp: camps) {
                    if (camp.getStartDate().compareTo(date(startDate)) > 0) {
                        result.add(camp);
                    }
                }
                break;
            }
            case 3: {
                System.out.printf("Enter End Date: ");
                String endDate = scan.nextLine();
                for (Camp camp: camps) {
                    if (camp.getEndDate().compareTo(date(endDate)) < 0) {
                        result.add(camp);
                    }
                }
                break;
            }
            default: {
                result = camps;
                break;
            }
        }

        return result;
    }

}
