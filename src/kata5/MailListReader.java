package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MailListReader {
    
    public List<String> read(String fileName){
        
        List<String> mails = new ArrayList<>();
                
        try{
            BufferedReader bf = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = bf.readLine();
                if(line == null) break;
                if(isMail(line)){
                    mails.add(line);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Fallo de FileNotFoundException");
        }catch (IOException ex) {
            System.out.println("Fallo de IOException");
        }
        
        //System.out.println(mails.get(0));
        
        return mails;
        
    }
    
    private boolean isMail(String line){
        String emailRegex = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        return Pattern.matches(emailRegex,line);
    }
    
}
