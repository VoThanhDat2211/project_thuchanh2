package com.website_muasamtructuyen_api.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	
	@NotBlank(message =  "name not blank")
	private String name;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String email;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	
	List<RoleDTO> roles;
}
