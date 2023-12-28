package com.website_muasamtructuyen_api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CategoryDTO {
	private int id;

	@NotBlank(message = "Category name not blank")
	private String name;
}
