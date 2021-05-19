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
public class OrderDTO {
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("orgId")
	private String orgId;
	
	@JsonProperty("orderId")
	private String orderId;
	
	@JsonProperty("price")
	private String price;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("discount")
	private String discount;
	
	@JsonProperty("quantity")
	private String quantity;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("orderDate")
	private String orderDate;
	
	@JsonProperty("status")
	private String status;



}
