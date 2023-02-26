public String specialityType[];
public String subSpecialityType[];
public String doctor[];
//public String patient;
public String day;
public String time;
public int bookingId;

methods:
public Patient getPatient(int patientid){
for(Patient p:patients){
if(p.getID==patientid)
return p;
}
return null;
} 
