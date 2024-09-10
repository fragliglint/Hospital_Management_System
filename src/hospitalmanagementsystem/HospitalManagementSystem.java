package hospitalmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class HospitalManagementSystem {
    private static final String DOCTOR_LIST_FILE = "doctor_data.txt";
    private static final int LINES_TO_REMOVE = 5;
    private static final String PATIENT_LIST_FILE ="patient_data.txt";
    private static final int LINES_TO_REMOVE1 = 6;
    private static final String APPOINTMENT_LIST_FILE ="appointment_data.txt";
    private static final int LINES_TO_REMOVE2 = 3;

    public static void main(String[] args) throws IOException {
        Scanner ss = new Scanner(System.in);

        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList<AppointmentManager> appointList = new ArrayList<>();
        

        System.out.println("                      -------------------------------------------");
        System.out.println("                      |                                         |");
        System.out.println("                      |      Welcome to Happy Happy Hospital    |");
        System.out.println("                      |                                         |");
        System.out.println("                      -------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("Press 1 to Add");
            System.out.println("Press 2 to Remove");
            System.out.println("Press 3 for Appointment");
            System.out.println("Press 4 to Print");
            System.out.println("Press 5 to Exit");
            System.out.println("-------------------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.print("Enter your choice: ");
            int option = ss.nextInt();

            switch (option) {

                case 1:
                    System.out.println("-------------------------------------------");
                    System.out.println("Press 1 to Add Doctor");
                    System.out.println("Press 2 to Add Patient");
                    System.out.println("Press 3 to go back");
                    System.out.println("Press 4 to Exit");
                    System.out.println("-------------------------------------------");
                    System.out.print("Enter your choice: ");
                    int addOption = ss.nextInt();

                    switch (addOption) {
                        case 1:
                            System.out.println("------------------------------------------------");
                            System.out.print("Enter the name of the Doctor: ");
                            String doctorName = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the Age of the Doctor: ");
                            int doctorAge = ss.nextInt();

                            System.out.print("Enter the Gender of the Doctor: ");
                            String doctorGender = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the Specialization of the Doctor: ");
                            String doctorSpecialization = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the availability of the Doctor: ");
                            boolean doctorAvailability = ss.nextBoolean();
                            ss.nextLine();
                            System.out.println("------------------------------------------------");
                            Doctor doctor = new Doctor(doctorName, doctorAge, doctorGender, doctorSpecialization,
                                    doctorAvailability);
                            doctorList.add(doctor);
                            writeDoctorDataToFile(doctor);
                            break;

                        case 2:
                            System.out.println("------------------------------------------------");
                            System.out.print("Enter the name of the Patient: ");
                            String patientName = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the Age of the Patient: ");
                            int patientAge = ss.nextInt();
                            System.out.print("Enter the Gender of the Patient: ");
                            String patientGender = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the address of the Patient: ");
                            String patientAddress = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the Contact Number of the Patient: ");
                            String patientPhone = ss.next();
                            ss.nextLine();
                            System.out.println("Enter the disease of the Patient: ");
                            String patientDisease = ss.next();
                            ss.nextLine();
                            System.out.println("------------------------------------------------");
                            Patient patient = new Patient(patientName, patientAge, patientGender, patientAddress,
                                    patientPhone, patientDisease);
                            patientList.add(patient);
                            writePatientDataToFile(patient);

                            break;

                        case 3:

                            break;

                        case 4:
                            System.exit(0);
                            break;
                    }
                    break;

                case 2:
                    System.out.println("-------------------------------------------");
                    System.out.println("Press 1 to remove Doctor");
                    System.out.println("Press 2 to remove Patient");
                    System.out.println("Press 3 to go back");
                    System.out.println("Press 4 to Exit");
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                    System.out.print("Enter your choice: ");
                    int removeOption = ss.nextInt();

                    switch (removeOption) {
                        case 1:
                            System.out.print("Enter Doctor name to remove: ");
                            String doctorNameToRemove = ss.next();


                            removeDoctorDataFromFile(doctorNameToRemove);
                            boolean removed = false;
                            for (int i = 0; i < doctorList.size(); i++) {
                                Doctor currentDoctor = doctorList.get(i);
                                if (currentDoctor.getDoctorName().equals(doctorNameToRemove)) {
                                    doctorList.remove(i);
                                    System.out.println("Successfully removed Doctor " + doctorNameToRemove);
                                    break;
                                }
                            }
                            break;

                        case 2:
                            System.out.print("Enter Patient name to remove: ");
                            String patientNameToRemove = ss.next();


                            removePatientDataFromFile(patientNameToRemove);
                            boolean removed1 = false;
                            for (int i = 0; i < patientList.size(); i++) {
                                Patient currentpatient = patientList.get(i);
                                if (currentpatient.getName().equals(patientNameToRemove)) {
                                    patientList.remove(i);
                                    System.out.println("Successfully removed patient " + patientNameToRemove);

                                    break;
                                }
                            }

                            break;

                        case 3:

                            break;

                        case 4:
                            System.exit(0);
                            break;
                    }
                    break;

                case 3:
                    System.out.println("-------------------------------------------");
                    System.out.println("Press 1 to book an appointment");
                    System.out.println("Press 2 to cancel an appointment");
                    System.out.println("Press 3 to go back");
                    System.out.println("Press 4 to Exit");
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                    System.out.print("Enter your choice: ");
                    int appointmentOption = ss.nextInt();

                    switch (appointmentOption) {
                        case 1:
                            System.out.println("------------------------------------------------");
                            System.out.print("Enter the name of the Patient: ");
                            String patientName = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the name of the Doctor: ");
                            String doctorName = ss.next();
                            ss.nextLine();
                            System.out.print("Enter the Appointment Date: ");
                            String appointmentDate = ss.next();
                            ss.nextLine();
                            System.out.println("");
                            System.out.println("------------------------------------------------");

                            AppointmentManager appointmentManager = new AppointmentManager(patientName, doctorName, appointmentDate);
                            appointList.add(appointmentManager);
                            writeAppointmentDataToFile(appointmentManager);

                            break;

                        case 2:
                            System.out.print("Enter the name of the Patient: ");
                            String patientNameToRemove = ss.next();


                            removeAppointmentDataFromFile(patientNameToRemove);
                            boolean removed2 = false;
                            for (int i = 0; i < appointList.size(); i++) {
                                AppointmentManager currentappoint = appointList.get(i);
                                if (currentappoint.getPatientname().equals(patientNameToRemove)) {
                                    appointList.remove(i);
                                    System.out.println("Successfully cancel the Appointment ");
                                    break;
                                }
                            }

                            break;

                        case 3:

                            break;

                        case 4:
                            System.exit(0);
                            break;
                    }
                    break;

                case 4:
                    System.out.println("-------------------------------------------");
                    System.out.println("Press 1 to print Patient List");
                    System.out.println("Press 2 to print Doctor List");
                    System.out.println("Press 3 to print Appointment List");
                    System.out.println("Press 4 to go back");
                    System.out.println("Press 5 to Exit");
                    System.out.println("-------------------------------------------");
                    System.out.println("");
                    System.out.print("Enter your choice: ");
                    int printOption = ss.nextInt();

                    switch (printOption) {
                        case 1:
                            try {
                                File myObj = new File("patient_data.txt");
                                Scanner myReader = new Scanner(myObj);
                                while (myReader.hasNextLine()) {
                                    String data = myReader.nextLine();
                                    System.out.println(data);
                                }
                                myReader.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            try {
                                File myObj = new File("doctor_data.txt");
                                Scanner myReader = new Scanner(myObj);
                                while (myReader.hasNextLine()) {
                                    String data = myReader.nextLine();
                                    System.out.println(data);
                                }
                                myReader.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            break;

                        case 3:
                            try {
                                File myObj = new File("appointment_data.txt");
                                Scanner myReader = new Scanner(myObj);
                                while (myReader.hasNextLine()) {
                                    String data = myReader.nextLine();
                                    System.out.println(data);
                                }
                                myReader.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            break;

                        case 4:

                            break;

                        case 5:
                            System.exit(0);
                            break;
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void writeDoctorDataToFile(Doctor doctor) {
        try (FileWriter writer = new FileWriter("doctor_data.txt", true)) {

            String name = doctor.getName();
            int age = doctor.getAge();
            String gender = doctor.getGender();
            String specialization = doctor.getSpecialization();
            boolean availability = doctor.isAvailable();
            writer.write("---------------------------------------------\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Gender: " + gender + "\n");
            writer.write("specialization: " + specialization + "\n");
            writer.write("Availabilty: " + availability + "\n");
            writer.write("\n");
            writer.write("---------------------------------------------");
            System.out.println("Doctor added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the doctor.");
            e.printStackTrace();
        }
    }

    public static void writePatientDataToFile(Patient patient) {
        try (FileWriter writer = new FileWriter("patient_data.txt", true)) {
            String name = patient.getName();
            int age = patient.getAge();
            String gender = patient.getGender();
            String adress = patient.getAddress();
            String phone = patient.getPhone();
            String disease = patient.getDisease();
            writer.write("---------------------------------------------\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Gender: " + gender + "\n");
            writer.write("Adress: " + adress + "\n");
            writer.write("Phone: " + phone + "\n");
            writer.write("Disease: " + disease + "\n");
            writer.write("\n");
            writer.write("---------------------------------------------");
            System.out.println("Patient added successfully.");
            
        } catch (IOException e) {
            System.out.println("An error occurred while adding the Patient.");
            e.printStackTrace();
        }
    }

    public static void writeAppointmentDataToFile(AppointmentManager appointment) {
        try (FileWriter writer = new FileWriter("appointment_data.txt", true)) {
            String patientname = appointment.getPatientname();
            String doctorname = appointment.getDoctorname();
            String date = appointment.getDate();
            writer.write("---------------------------------------------\n");
            writer.write("Patientname: " + patientname + "\n");
            writer.write("Doctorname: " + doctorname + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("\n");
            writer.write("---------------------------------------------");
            System.out.println("Appointments added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred whi1e adding the appointments.");
            e.printStackTrace();
        }
    }
     private static void removeDoctorDataFromFile(String doctorNameToRemove) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTOR_LIST_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTOR_LIST_FILE + ".tmp"))) {
            String line;
            boolean removeNextLines = false;
            int linesRemoved = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ") && line.substring("Name: ".length()).equals(doctorNameToRemove)) {
                    removeNextLines = true;
                }

                if (!removeNextLines) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    linesRemoved++;
                    if (linesRemoved >= LINES_TO_REMOVE) {
                        removeNextLines = false;
                        linesRemoved = 0;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while removing doctor data from file.");
            e.printStackTrace();
        }

        try {
            Files.move(Paths.get(DOCTOR_LIST_FILE + ".tmp"), Paths.get(DOCTOR_LIST_FILE), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Doctor data removed from file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while renaming the temporary file.");
            e.printStackTrace();
        }
    }
     private static void removePatientDataFromFile(String patientNameToRemove) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_LIST_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENT_LIST_FILE + ".tmp"))) {
            String line;
            boolean removeNextLines = false;
            int linesRemoved = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ") && line.substring("Name: ".length()).equals(patientNameToRemove)) {
                    removeNextLines = true;
                }

                if (!removeNextLines) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    linesRemoved++;
                    if (linesRemoved >= LINES_TO_REMOVE1) {
                        removeNextLines = false;
                        linesRemoved = 0;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while removing patient data from file.");
            e.printStackTrace();
        }

        try {
            Files.move(Paths.get(PATIENT_LIST_FILE + ".tmp"), Paths.get(PATIENT_LIST_FILE), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Patient data removed from file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while renaming the temporary file.");
            e.printStackTrace();
        }
    }
     private static void removeAppointmentDataFromFile(String patientNameToRemove) {
        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENT_LIST_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(APPOINTMENT_LIST_FILE + ".tmp"))) {
            String line;
            boolean removeNextLines = false;
            int linesRemoved = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Patientname: ") && line.substring("Patientname: ".length()).equals(patientNameToRemove)) {
                    removeNextLines = true;
                }

                if (!removeNextLines) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    linesRemoved++;
                    if (linesRemoved >= LINES_TO_REMOVE2) {
                        removeNextLines = false;
                        linesRemoved = 0;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while removing appointment data from file.");
            e.printStackTrace();
        }

        try {
            Files.move(Paths.get(APPOINTMENT_LIST_FILE + ".tmp"), Paths.get(APPOINTMENT_LIST_FILE), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Appointment data removed from file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while renaming the temporary file.");
            e.printStackTrace();
        }
    }
}
