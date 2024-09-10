package hospitalmanagementsystem;

class AppointmentManager {

    String patientname;
    String doctorname;
    String date;

    public AppointmentManager() {

    }

    AppointmentManager(String patientname, String doctorname, String date) {

        this.patientname = patientname;
        this.doctorname = doctorname;
        this.date = date;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    
    public void displayappointment(){
        System.out.println("Doctorname: "+doctorname);
        System.out.println("patientname: "+patientname);
        System.out.println("date: "+date);
    }
}
