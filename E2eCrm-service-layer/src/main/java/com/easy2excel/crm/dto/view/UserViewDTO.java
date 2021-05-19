package com.easy2excel.crm.dto.view;

import com.esay2excel.crm.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserViewDTO {

    private String userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String phoneNo;

    private String dialCode;

    private String alternateNo;

    private String dialCode1;

    private String email;

    public UserViewDTO(String userId, String firstName, String middleName, String lastName, String phoneNo, String dialCode, String alternateNo, String dialCode1, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.dialCode = dialCode;
        this.alternateNo = alternateNo;
        this.dialCode1 = dialCode1;
        this.email = email;
    }

    public static UserViewDTO from(User user) {
        UserViewDTO userViewDTO;
        if (user == null) {
            userViewDTO = null;
        } else {
            userViewDTO = new UserViewDTO(user.getId(), user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getPhoneNo(), user.getDialCode(), user.getAlternativeNo(), user.getDialCode1(), user.getEmail());
        }
        return userViewDTO;
    }

/*private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNo;
    private String dialCode;
    private String alternateNo;
    private String dialCode1;
    private String email;*/

}
