package com.website_muasamtructuyen_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class BillItemsDTO {
	private int id;

	@JsonIgnoreProperties("billItems")
	private BillDTO bill;


	private ProductDTO product;

	private Product_ColorDTO productColor;

	private int quantity;

	private double buyPrice;
}
