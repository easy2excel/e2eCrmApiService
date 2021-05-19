package com.easy2excel.crm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserPasswordDTO {

	@NotEmpty
	@Email(message="please provide registered email address")
	@JsonProperty("emailId")
	private String emailId;

	@NotEmpty(message="password must be provided")
	@JsonProperty("password")
	private String password;
}
