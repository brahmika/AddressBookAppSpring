package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.AddressBookData;
import com.bridgelabz.AddressBookApp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    // GET all
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> dataList =
                addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Address Book Data", dataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // GET by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(
            @PathVariable("id") long id) {
        AddressBookData data =
                addressBookService.getAddressBookDataById(id);
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Address Book Data for ID: " + id, data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // POST create
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(
            @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData data =
                addressBookService
                        .createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO(
                "Created Address Book Data Successfully", data);
        return new ResponseEntity<>(responseDTO,
                HttpStatus.CREATED);
    }

    // PUT update
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(
            @PathVariable("id") long id,
            @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData data =
                addressBookService
                        .updateAddressBookData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO(
                "Updated Address Book Data Successfully", data);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(
            @PathVariable("id") long id) {
        addressBookService.deleteAddressBookData(id);
        ResponseDTO responseDTO = new ResponseDTO(
                "Deleted Address Book Data for ID: " + id, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}