package kata5;

import java.util.List;

public class Kata5 {
    public static void main(String[] args) {
        DataBase db = new DataBase("PEOPLE.db");
        db.connect();
        //db.selectAll();
        db.createNewTable("MAIL");
        List<String> mailList = new MailListReader().read("emails.txt");
        
        for (String mail : mailList) {
            db.insertEmail(mail);
        }
    }
}
