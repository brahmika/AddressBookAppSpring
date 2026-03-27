package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // GET all contacts
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Address Book Data", "Working");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // GET contact by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(
            @PathVariable("id") long id) {
        AddressBookData data = new AddressBookData(
                id, "Test Contact", "123 Street",
                "9999999999", "test@email.com");
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Address Book Data for ID: " + id, data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // POST create contact
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(
            @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData data = new AddressBookData(
                0,
                addressBookDTO.getName(),
                addressBookDTO.getAddress(),
                addressBookDTO.getPhone(),
                addressBookDTO.getEmail()
        );
        ResponseDTO responseDTO = new ResponseDTO(
                "Created Address Book Data Successfully", data);
        return new ResponseEntity<>(responseDTO,
                HttpStatus.CREATED);
    }

    // PUT update contact
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(
            @PathVariable("id") long id,
            @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData data = new AddressBookData(
                id,
                addressBookDTO.getName(),
                addressBookDTO.getAddress(),
                addressBookDTO.getPhone(),
                addressBookDTO.getEmail()
        );
        ResponseDTO responseDTO = new ResponseDTO(
                "Updated Address Book Data Successfully", data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // DELETE contact
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(
            @PathVariable("id") long id) {
        ResponseDTO responseDTO = new ResponseDTO(
                "Deleted Address Book Data for ID: " + id, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}