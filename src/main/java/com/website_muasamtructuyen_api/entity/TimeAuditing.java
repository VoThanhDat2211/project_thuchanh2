package com.website_muasamtructuyen_api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
@Data
@EntityListeners(AuditingEntityListener.class)
public class TimeAuditing {
	@CreatedDate
	@Column(updatable = false)
	protected Date  CreateAt;
	
	@LastModifiedDate
	protected Date updateAtDate;
}
