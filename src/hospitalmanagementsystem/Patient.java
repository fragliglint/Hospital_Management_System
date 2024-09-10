
package hospitalmanagementsystem;

class Patient extends Person {

    private String address;
    private String phone;
    private String disease;

    Patient(String name, int age, String gender, String address, String phone, String disease) {
        super(name, age, gender);
        this.address = address;
        this.phone = phone;
        this.disease = disease;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public void displayDetails() {
        System.out.print(name + "-");
        System.out.print(age + "-");
        System.out.print(gender + "-");
        System.out.print(address + "-");
        System.out.print(phone + "-");
        System.out.println(disease);
    }
}
