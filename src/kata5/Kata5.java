package kata5;

public class Kata5 {

    public static void main(String[] args) {
        DataBase db = new DataBase("PEOPLE.db");
        db.connect();
        //db.selectAll();
        db.createNewTable("MAIL");
    }
    
    
}
