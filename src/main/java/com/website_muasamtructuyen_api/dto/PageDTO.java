package com.website_muasamtructuyen_api.dto;

import lombok.Data;

@Data
public class PageDTO<T> {
	private int totalPages;
	
	private long totalElement;
	
	private T data;
}
