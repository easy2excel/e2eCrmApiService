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
public class EmailValidationDTO {
	@JsonProperty("userId")
	private String userId;
	
	@NotEmpty
	@Email(message="please provide valid email address")
	@JsonProperty("emailId")
	private String emailId;
	
	@NotEmpty(message="token has been expired")
	@JsonProperty("token")
	private String token;
	
	@JsonProperty("organizationId")
	private String organizationId;
	
	@JsonProperty("ipAddress")
	private String ipAddress;

}
