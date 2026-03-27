package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.model.AddressBookData;
import java.util.List;

public interface IAddressBookService {

    List<AddressBookData> getAddressBookData();

    AddressBookData getAddressBookDataById(long id);

    AddressBookData createAddressBookData(
            AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(
            long id, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(long id);
}