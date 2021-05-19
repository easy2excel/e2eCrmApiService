package com.easy2excel.crm.controller;


import com.easy2excel.crm.dto.AddressDTO;
import com.easy2excel.crm.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("api/v1/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.saveAddress(addressDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable("id") String id) {
        return ResponseEntity.ok(addressService.getAddress(id));
    }

   /* @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressDTO>> getAddressListByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(addressService.getAddressListByUserId());
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable("id") String id,@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.updateAddress(id,addressDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") String id) {
        addressService.deleteAddress(id);
    }

}
