package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.model.AddressBookData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService
        implements IAddressBookService {

    // In-memory list to store contacts
    private List<AddressBookData> addressBookList
            = new ArrayList<>();

    // Auto increment ID counter
    private AtomicLong idCounter = new AtomicLong(1);

    // GET all contacts
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    // GET contact by ID
    @Override
    public AddressBookData getAddressBookDataById(long id) {
        return addressBookList.stream()
                .filter(contact -> contact.id == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE contact
    @Override
    public AddressBookData createAddressBookData(
            AddressBookDTO addressBookDTO) {
        AddressBookData data = new AddressBookData(
                idCounter.getAndIncrement(),
                addressBookDTO.getName(),
                addressBookDTO.getAddress(),
                addressBookDTO.getPhone(),
                addressBookDTO.getEmail()
        );
        addressBookList.add(data);
        return data;
    }

    // UPDATE contact
    @Override
    public AddressBookData updateAddressBookData(
            long id, AddressBookDTO addressBookDTO) {
        AddressBookData data = getAddressBookDataById(id);
        if (data != null) {
            data.name = addressBookDTO.getName();
            data.address = addressBookDTO.getAddress();
            data.phone = addressBookDTO.getPhone();
            data.email = addressBookDTO.getEmail();
        }
        return data;
    }

    // DELETE contact
    @Override
    public void deleteAddressBookData(long id) {
        AddressBookData data = getAddressBookDataById(id);
        if (data != null) {
            addressBookList.remove(data);
        }
    }
}