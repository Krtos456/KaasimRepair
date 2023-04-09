/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kaasimrepair;
import java.util.ArrayList;
/**
 *
 * @author Hadhif
 */
public class JobList {
    ArrayList<JobItem> JobList=new ArrayList<>();
    VehicleInformation Vehicle ;
    String IssuedDate;
    
    JobList(VehicleInformation IVehicle,String Date)
        {
            Vehicle=IVehicle;
            IssuedDate=Date;
        }
    public void AddItem(JobItem AddItem)
    {
        JobList.add(AddItem);
    }
}
