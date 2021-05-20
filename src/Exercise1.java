import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        Scanner kbd = new Scanner(System.in);

        //reading file from Scanner kbd
        System.out.print("Enter the filename to read from: ");
        String fileName = kbd.nextLine();
       // kbd.close();

        //Hashmap for username and password
        Map<String, String> loginDeets = new HashMap<>();
        //Hashmap for username and fullname
        Map<String,String>  uName_fName= new HashMap<>();

        String fullName, userName, password;

        Scanner inputFile = new Scanner(new File(fileName));
        while (inputFile.hasNext())
        {
            /**
             * getting information from each line provided and assigning each to their label
             */
            String[] details = inputFile.nextLine().split("\t");
            fullName = details[0];
            userName = details[1];
            password = details[2];

            //mapping data to hashmaps
            loginDeets.put(userName,password);
            uName_fName.put(userName,fullName);
        }
        inputFile.close();

        //number of tries the user has to login into the system
        int attempts = 3;

        String uName = null, pWord = null;

        while(attempts > 0){
            attempts--;
            System.out.print("Login: ");
            uName = kbd.next();
            System.out.print("Password: ");
            pWord = kbd.next();


            if(pWord.equals(loginDeets.get(uName))){
                System.out.println("Login successful");
                System.out.println(("Welcome "+ uName_fName.get(uName)));
                break;
            }
            else{
                if(attempts == 2){
                    System.out.println("Either the username or password is incorrect. You have 2 more attempts");
                }
                else if(attempts == 1){
                    System.out.println("Either the username or password is incorrect. You have 1 more attempt");
                }
                else{
                    System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
                }
            }
        }

    }

}
