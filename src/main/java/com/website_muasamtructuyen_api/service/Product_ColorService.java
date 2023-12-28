package com.website_muasamtructuyen_api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.website_muasamtructuyen_api.dto.Product_ColorDTO;
import com.website_muasamtructuyen_api.entity.Color;
import com.website_muasamtructuyen_api.entity.Product;
import com.website_muasamtructuyen_api.entity.Product_Color;
import com.website_muasamtructuyen_api.repository.Product_ColorRepo;

public interface Product_ColorService {
	void create(Product_ColorDTO pcDTO);

	void update(Product_ColorDTO pcDTO);

	void delete(int id);

	Product_ColorDTO findById(int id);
}

@Service
class Product_ColorServiceImpl implements Product_ColorService {
	@Autowired
	Product_ColorRepo pcRe;

	@Override
	@Transactional
	public void create(Product_ColorDTO pcDTO) {
		Product_Color pc = new ModelMapper().map(pcDTO, Product_Color.class);
		pcRe.save(pc);

	}

	@Override
	@Transactional
	public void update(Product_ColorDTO pcDTO) {
		Product_Color pc = pcRe.findById(pcDTO.getId())
				.orElseThrow(() -> new NotFoundException("Product_Color not found"));
		if (pc != null) {
			pc.setAvailableQuantity(pcDTO.getAvailableQuantity());
			pc.setSoldQuantity(pcDTO.getSoldQuantity());
			pc.setColor(new ModelMapper().map(pcDTO.getColor(), Color.class));
			pc.setProduct(new ModelMapper().map(pcDTO.getProduct(), Product.class));
			List<String> images = new ArrayList<String>();
			if (!pcDTO.getImages().isEmpty()) {
				for (String img : pcDTO.getImages()) {
					images.add(img);
				}
			}

			pc.setImages(images);
			pcRe.save(pc);
		}

	}

	@Override
	@Transactional
	public void delete(int id) {
		pcRe.deleteById(id);
	}

	@Override
	public Product_ColorDTO findById(int id) {
		Product_Color pc = pcRe.findById(id).orElse(null);
		Product_ColorDTO pcDTO = convert(pc);
		return pcDTO;
	}

	private Product_ColorDTO convert(Product_Color pc) {
		return new ModelMapper().map(pc, Product_ColorDTO.class);
	}

}
