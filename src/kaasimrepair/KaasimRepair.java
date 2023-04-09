/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kaasimrepair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
        
/**
 *
 * @author Hadhif
 */
public class KaasimRepair {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<LoginDetails> LoginDetailList=new ArrayList<>();
    private static LoginScreen LoginRef =null;
    public static void main(String[] args) {
        try{
        File LoginDetails = new File("LoginDetails.txt");
        Scanner FileReader = new Scanner (LoginDetails);
        parseFileValue(FileReader);
        }
        catch(FileNotFoundException e){
        System.out.println("LoginDetails file not Found");
        e.printStackTrace();
        System.exit(1);
        }
        finally{
        
        LoginRef =new LoginScreen();
        LoginRef.setVisible(true);
        }
    }
    
    private static void parseFileValue(Scanner FileReaders)
    {
        LoginDetailList =new ArrayList<>();
        while(FileReaders.hasNext()){
            String LineRead =FileReaders.nextLine();
            String[] SplitDetails =LineRead.split(",");
            LoginDetails NewItem= new LoginDetails(SplitDetails[0],SplitDetails[1],SplitDetails[2]);
            LoginDetailList.add(NewItem);
            System.out.println(SplitDetails[0]);
        }
    }
    
    public static void Login(String UserName, String Password){
        //System.out.println(UserName+Password);
        
        for(int x=0;x<LoginDetailList.size();x++){
            if(LoginDetailList.get(x).Username.equals(UserName) && LoginDetailList.get(x).Password.equals(Password))
            {
                LoginRef.dispose();
                switch(LoginDetailList.get(x).Type)
                {
                    case"SysAdmin":
                        new SysAdminHome().setVisible(true);
                        break;
                    case"Mechanic":
                        new MechanicHome().setVisible(true);
                        break;
                    case"SalAdmin":
                        new SalesAdminHome().setVisible(true);
                        break;
                    default: 
                        break;
                }
                break;
            }
         } 
                LoginRef.LoginCallBack(1); System.out.println(UserName+Password);
    }
}
