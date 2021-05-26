package com.upgrade.frontEnd.Fixtures;

public class BasicInformationFixture {

    public String firstName = "firstName";
    public String lastName = "lastName";
    public String homeAddress = "21155 Maryland Road";
    public String city = "Big Bear Lake";
    public String state = "CA";
    public String zipCode = "92315";
    public String dateOfBirth = "05/01/1990";

    public BasicInformationFixture setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BasicInformationFixture setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BasicInformationFixture setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
        return this;
    }

    public BasicInformationFixture setCity(String city) {
        this.city = city;
        return this;
    }

    public BasicInformationFixture setState(String state) {
        this.state = state;
        return this;
    }

    public BasicInformationFixture setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public BasicInformationFixture setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }


}
