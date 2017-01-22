package week1_aco15.secondTry.contactApp.model;

import week1_aco15.secondTry.contactApp.enums.MobileOperator;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber; // in format 380637123456
    private MobileOperator mobileOperator;

    public Contact(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        mobileOperator = MobileOperator.getMobileOperator(phoneNumber);
    }

    public String getFirstName(){return firstName;}

    public String getLastName(){return lastName;}

    public String getPhoneNumber(){return phoneNumber;}

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public MobileOperator getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(MobileOperator mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    @Override
    public String toString(){
        return String.format("Contact: [ firstName: %s, lastName: %s, phoneNumber %s]",
                firstName, lastName, phoneNumber);
    }

    //TODO: understand equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
        return phoneNumber != null ? phoneNumber.equals(contact.phoneNumber) : contact.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
