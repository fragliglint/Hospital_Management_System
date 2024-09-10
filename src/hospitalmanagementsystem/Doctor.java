
package hospitalmanagementsystem;


class Doctor extends Person {

    private String specialization;
    private boolean availability;

    Doctor(String name, int age, String gender, String specialization, boolean availability) {
        super(name, age, gender);
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getDoctorName() {
        return name;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public void displayDetails() {
        System.out.print(name + "-");
        System.out.print(age + "-");
        System.out.print(gender + "-");
        System.out.print(specialization + "-");
        System.out.println(availability);
    }
}

