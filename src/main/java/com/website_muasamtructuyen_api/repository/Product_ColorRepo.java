package com.website_muasamtructuyen_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website_muasamtructuyen_api.entity.Product_Color;

@Repository
public interface Product_ColorRepo extends JpaRepository<Product_Color, Integer>{
	
}
