package kata5;

import java.sql.SQLException;
import java.util.List;
import model.Histogram;
import model.Mail;
import persistence.MailListReader;
import view.HistogramDisplay;
import view.MailHistogramBuilder;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String query = "SELECT * FROM people WHERE state='CA'";
        List<Mail> mailList = MailListReader.read("org.sqlite.JDBC", query);
        
        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM",mailHistogram);
        histogramDisplay.execute();
        
    }
    
}
