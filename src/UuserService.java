import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UuserService {
	
	public int records;
	public Uuser randuseinfo;
	
	
public void readUserdata() {

	 try {
         File f = new File("u.user");
         Scanner sc = new Scanner(f);

         List<Uuser> userlist = new ArrayList<Uuser>();

         while(sc.hasNextLine()){
             String line = sc.nextLine();
             //System.out.println(line);
             String[] details = line.split("\\|");
             //for( int i =0; i < details.length; i++)
             //System.out.println(details[i]);
         
             	int userId = Integer.parseInt(details[0]);
                 int age = Integer.parseInt(details[1]);
             	
                 char gender = details[2].charAt(0);
             
             String occupation = details[3];
             int zipcode = Integer.parseInt(details[4]);
            
             Uuser user = new Uuser(userId, age, gender, occupation, zipcode);
             
             userlist.add(user);
         }
         
	 

         //for(Uuser user: userlist){
             //System.out.println(user.toString());       
         //s}
         
        
     } catch (FileNotFoundException e) {         
         e.printStackTrace();
     }
 
	}
	 
    
	}
	 

