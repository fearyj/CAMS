package camp_system.date_parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {
    public SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public Date date(String source) throws ParseException {
        return dateFormatter.parse(source);
    }
}
