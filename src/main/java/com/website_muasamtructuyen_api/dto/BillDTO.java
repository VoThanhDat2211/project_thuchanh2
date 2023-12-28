package com.website_muasamtructuyen_api.dto;

import java.util.List;

import com.website_muasamtructuyen_api.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BillDTO extends TimeAuditingDTO{
	private int id;

	private User user;

	private List<BillItemsDTO> billItems;
}
