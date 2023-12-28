package com.website_muasamtructuyen_api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends TimeAuditing{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String name;

	private double purchasePrice;

	private double buyPrice;

	private String description;

	private String image;

	private int availableQuantity;

	private int soldQuantity;

	private String size;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Product_Color> productColors;

	@ManyToOne
	private Category category;
}
