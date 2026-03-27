package com.bridgelabz.AddressBookApp.model;

public class AddressBookData {

    public long id;
    public String name;
    public String address;
    public String phone;
    public String email;

    // Default Constructor
    public AddressBookData() {}

    // Constructor
    public AddressBookData(long id, String name,
                           String address, String phone,
                           String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBookData: id=" + id
                + ", name=" + name
                + ", address=" + address
                + ", phone=" + phone
                + ", email=" + email;
    }
}
