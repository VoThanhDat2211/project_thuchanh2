package com.website_muasamtructuyen_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website_muasamtructuyen_api.entity.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
}
