package com.website_muasamtructuyen_api.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.website_muasamtructuyen_api.dto.ProductDTO;
import com.website_muasamtructuyen_api.entity.Category;
import com.website_muasamtructuyen_api.entity.Product;
import com.website_muasamtructuyen_api.repository.ProductRepo;

public interface ProductService {
	void create(ProductDTO productDTO);

	void update(ProductDTO productDTO);

	void delete(int id);

	ProductDTO findById(int id);
}

@Service
class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRe;

	@Override
	@Transactional
	public void create(ProductDTO productDTO) {
		Product p = new ModelMapper().map(productDTO, Product.class);
		productRe.save(p);
	}

	@Override
	@Transactional
	public void update(ProductDTO productDTO) {
		Product p = productRe.findById(productDTO.getId())
				.orElseThrow(() -> new NotFoundException("Product not found"));
		if (p != null) {
			p.setName(productDTO.getName());
			p.setPurchasePrice(productDTO.getPurchasePrice());
			p.setBuyPrice(productDTO.getBuyPrice());
			p.setDescription(productDTO.getDescription());
			p.setImage(productDTO.getImage());
			p.setAvailableQuantity(productDTO.getAvailableQuantity());
			p.setSoldQuantity(productDTO.getSoldQuantity());
			p.setSize(productDTO.getSize());
			p.setCategory(new ModelMapper().map(productDTO.getCategory(), Category.class));

			productRe.save(p);
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
		Product p = productRe.findById(id).orElse(null);
		if (p != null) {
			productRe.deleteById(id);
		}

	}

	@Override
	public ProductDTO findById(int id) {
		Product p = productRe.findById(id).orElse(null);
		ProductDTO pDTO = convert(p);
		
		return pDTO;
	}
	
	private ProductDTO convert(Product p ) {
		return new ModelMapper().map(p, ProductDTO.class);
	}

}