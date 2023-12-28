package com.website_muasamtructuyen_api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RoleDTO {
	private int id;
	
	@NotBlank(message = "Role not blank")
	private String name;
}
