package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.AddressDTO;

public interface AddressService {
	
	public AddressDTO saveAddress(AddressDTO addressDTO);
	
	public AddressDTO updateAddress(String addressId, AddressDTO addressDTO);
	
	public void deleteAddress(String addressId);
	
	public AddressDTO getAddress(String addressId);

	//public List<AddressDTO> getAddressListByUserId(String userId);

}
