package com.website_muasamtructuyen_api.dto;

import lombok.Data;

@Data
public class SearchDTO {
	protected String keyword;
	
	protected Integer currentPage;
	
	protected Integer size;
	
	protected String sortField;
	
	protected String sortType;
}
