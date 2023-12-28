package com.website_muasamtructuyen_api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDTO extends TimeAuditingDTO{
	private int id;

	@NotBlank(message = "Product name not blank")
	private String name;

	private double purchasePrice;

	private double buyPrice;

	private String description;

	private String image;

	@Min(value = 0)
	private int availableQuantity;

	@Min(value = 0)
	private int soldQuantity;

	private String size;

	private CategoryDTO category;
	
	@JsonIgnore
	private MultipartFile fileImage;
}
