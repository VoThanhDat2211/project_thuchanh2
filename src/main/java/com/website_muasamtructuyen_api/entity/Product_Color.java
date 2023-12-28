package com.website_muasamtructuyen_api.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Product_Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int availableQuantity;
	
	private int soldQuantity;
	
	@ManyToOne
	private Color color;
	
	@ManyToOne 
	private Product product;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="product_image",joinColumns  = @JoinColumn(name="product_color_id"))
	@Column(name="image")
	private List<String> images;
	
	
}
