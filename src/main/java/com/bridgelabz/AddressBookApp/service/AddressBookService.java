package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.model.AddressBookData;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookService
        implements IAddressBookService {

    @Override
    public List<AddressBookData> getAddressBookData() {
        return null;
    }

    @Override
    public AddressBookData getAddressBookDataById(long id) {
        return null;
    }

    @Override
    public AddressBookData createAddressBookData(
            AddressBookDTO addressBookDTO) {
        return null;
    }

    @Override
    public AddressBookData updateAddressBookData(
            long id, AddressBookDTO addressBookDTO) {
        return null;
    }

    @Override
    public void deleteAddressBookData(long id) {
    }
}