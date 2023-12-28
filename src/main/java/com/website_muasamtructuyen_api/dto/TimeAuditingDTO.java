package com.website_muasamtructuyen_api.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TimeAuditingDTO {
	private Date CreateAt;

	private Date updateAtDate;
}
