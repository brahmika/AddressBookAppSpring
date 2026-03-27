package com.bridgelabz.AddressBookApp.dto;

public class AddressBookDTO {

    private String name;
    private String address;
    private String phone;
    private String email;

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "AddressBookDTO: name=" + name
                + ", address=" + address
                + ", phone=" + phone
                + ", email=" + email;
    }
}