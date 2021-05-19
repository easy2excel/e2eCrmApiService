package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.AddressDTO;
import com.esay2excel.crm.domain.User;
import com.esay2excel.crm.domain.UserAddress;
import com.esay2excel.crm.repository.UserAddressRepository;
import com.esay2excel.crm.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    UserAddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        UserAddress address = new UserAddress();
        setPropertyOnInput(addressDTO, address);
        UserAddress dbAddress = addressRepository.save(address);
        return AddressDTO.from(dbAddress);
    }

    private void setPropertyOnInput(AddressDTO addressDTO, UserAddress address) {
        address.setAddress1(addressDTO.getAddress1());
        address.setAddress2(addressDTO.getAddress2());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setState(addressDTO.getState());
        address.setPincode(addressDTO.getPinCode());
        address.setCounty(addressDTO.getCounty());
        address.setAddressType(addressDTO.getAddressType());
        User user =userRepository.findById(addressDTO.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found " + addressDTO.getUserId()));
        address.setUser(user);
    }

    @Override
    public AddressDTO updateAddress(String addressId, AddressDTO addressDTO) {

        UserAddress address = addressRepository.findById(addressId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found " + addressId));
        setPropertyOnInput(addressDTO, address);
        UserAddress updatedAddress=addressRepository.save(address);
        return AddressDTO.from(updatedAddress);
    }

    @Override
    public void deleteAddress(String addressId) {
        if (null != addressId) {
            UserAddress s = addressRepository.findById(addressId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found " + addressId));
        }
    }

    @Override
    public AddressDTO getAddress(String addressId) {
        UserAddress address = addressRepository.findById(addressId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found " + addressId));
        return AddressDTO.from(address);
    }
}
