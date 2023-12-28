package com.website_muasamtructuyen_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class BillItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Bill bill;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Product_Color productColor;

	private int quantity;

	private double buyPrice;

}
