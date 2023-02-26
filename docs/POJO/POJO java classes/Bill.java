private static int UID;
public int id;
public Patient patient;
public Prescription [] prescriptions;
public int roomCharge; 
public int surgeryCharge; 
public String insuranceID; 
public String schemeID; 
public int insuranceDeduction;
public int schemeDeduction;
public int totalAmount;
public boolean paid;


public int calculateTotal(){
    totalAmount=(roomCharge+surgeryCharge)-(insuranceDeduction+schemeDeduction);
    return totalAmount;
}
public boolean addPrescription(Prescription p){
    this.prescriptions.add(p);
}
public boolean removePrescription(Prescription p_id){
    for(Prescription pr:prescriptions){
        if(pr.getID==p_id){
            pr.remove();
            return true;
        }
        return false;
    }
}