package com.easy2excel.crm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoteDTO {
	
	@JsonProperty("noteType")
	private String noteType;
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("orgId")
	private String orgId;
	


}
