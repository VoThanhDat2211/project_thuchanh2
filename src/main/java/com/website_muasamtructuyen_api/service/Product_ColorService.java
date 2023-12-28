package com.website_muasamtructuyen_api.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website_muasamtructuyen_api.dto.Product_ColorDTO;
import com.website_muasamtructuyen_api.entity.Product_Color;
import com.website_muasamtructuyen_api.repository.Product_ColorRepo;

public interface Product_ColorService {
	void create(Product_ColorDTO pcDTO);
	
	void update(Product_ColorDTO pcDTO);
	
	void delete(int id);
	
	Product_ColorDTO findById(int id);
}
@Service
class Product_ColorServiceImpl implements Product_ColorService{
	@Autowired
	Product_ColorRepo pcRe;
	
	@Override
	@Transactional
	public void create(Product_ColorDTO pcDTO) {
		Product_Color pc = new ModelMapper().map(pcDTO, Product_Color.class);
		pcRe.save(pc);
		
	}

	@Override
	public void update(Product_ColorDTO pcDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product_ColorDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
