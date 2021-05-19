package com.easy2excel.crm.dto.view;


import com.esay2excel.crm.domain.AddressType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAddressViewDTO {
    @JsonProperty("addressId")
    private String addressId;

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
}
