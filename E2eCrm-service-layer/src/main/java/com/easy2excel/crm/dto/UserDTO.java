package com.easy2excel.crm.dto;

import com.esay2excel.crm.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("phoneNo")
    private String phoneNo;

    @JsonProperty("dialCode")
    private String dialCode;

    @JsonProperty("alternateNo")
    private String alternateNo;

    @JsonProperty("dialCode1")
    private String dialCode1;

    @JsonProperty("email")
    private String email;



    public UserDTO( String firstName, String middleName, String lastName, String phoneNo, String dialCode, String alternateNo, String dialCode1, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.dialCode = dialCode;
        this.alternateNo = alternateNo;
        this.dialCode1 = dialCode1;
        this.email = email;

    }

    public static UserDTO from(User dbUser) {
        UserDTO userDTO;
        if (null == dbUser) {
            userDTO = null;
        } else {
            userDTO = new UserDTO(dbUser.getFirstName(), dbUser.getMiddleName(), dbUser.getLastName(), dbUser.getPhoneNo(), dbUser.getDialCode(), dbUser.getAlternativeNo(), dbUser.getDialCode1(), dbUser.getEmail());
        }
        return userDTO;
    }
}
