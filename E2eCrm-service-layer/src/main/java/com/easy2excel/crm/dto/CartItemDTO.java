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
public class CartItemDTO {

	@JsonProperty("token")
	private String token;
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("orgId")
	private String orgId;
	
	@JsonProperty("quantity")
	private String quantity;
	
	@JsonProperty("discount")
	private String discount;
	
	@JsonProperty("amount")
	private String amount;


}
