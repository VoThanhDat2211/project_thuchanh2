package com.website_muasamtructuyen_api.dto;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Product_ColorDTO {
	private int id;

	@Min(value = 0)
	private int availableQuantity;
	
	@Min(value = 0)
	private int soldQuantity;

	private ColorDTO color;

	private ProductDTO product;

	private List<String> images;

	@JsonIgnore
	private List<MultipartFile> fileImages;
}
