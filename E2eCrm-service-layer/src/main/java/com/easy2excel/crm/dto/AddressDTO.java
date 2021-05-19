package com.easy2excel.crm.dto;


import com.esay2excel.crm.domain.AddressType;
import com.esay2excel.crm.domain.UserAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressDTO {


	@JsonProperty("address1")
	private String address1;

	@JsonProperty("address2")
	private String address2;

	@JsonProperty("city")
	private String city;

	@JsonProperty("country")
	private String country;

	@JsonProperty("state")
	private String state;

	@JsonProperty("pinCode")
	private String pinCode;

	@JsonProperty("county")
	private String county;

	@JsonProperty("addressType")
	private AddressType addressType;

	@JsonProperty("userId")
	private String userId;

	public static AddressDTO from(UserAddress address) {
		AddressDTO addressDTO;
		if (null == address) {
			return null;
		} else {
			addressDTO = new AddressDTO(address.getAddress1(),address.getAddress2(),address.getCity(),address.getCountry()
					,address.getState(),address.getPincode(),address.getCounty(),address.getAddressType());

		}
		return addressDTO;
	}

	public AddressDTO( String address1, String address2, String city, String country, String state,
			String pinCode, String county, AddressType addressType) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.pinCode = pinCode;
		this.county = county;
		this.addressType = addressType;
		
	}

}
