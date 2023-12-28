package com.website_muasamtructuyen_api.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.website_muasamtructuyen_api.dto.CategoryDTO;
import com.website_muasamtructuyen_api.entity.Category;
import com.website_muasamtructuyen_api.repository.CategoryRepo;

public interface CategoryService {
	void create(CategoryDTO categoryDTO);

	void update(CategoryDTO categoryDTO);

	void delete(int id);

	CategoryDTO findById(int id);
}

@Service
class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo catetegoryRe;

	@Override
	@Transactional
	public void create(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		catetegoryRe.save(category);
	}

	@Override
	@Transactional
	public void update(CategoryDTO categoryDTO) {
		Category category = catetegoryRe.findById(categoryDTO.getId())
				.orElseThrow(() -> new NotFoundException("Category not found"));
		if (category != null) {
			category.setName(categoryDTO.getName());
			catetegoryRe.save(category);
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
		Category category = catetegoryRe.findById(id).orElse(null);
		if (category != null) {
			catetegoryRe.deleteById(id);
		}
	}

	@Override
	public CategoryDTO findById(int id) {
		Category category = catetegoryRe.findById(id).orElse(null);
		CategoryDTO categoryDTO = convert(category);

		return categoryDTO;
	}

	private CategoryDTO convert(Category category) {
		return new ModelMapper().map(category, CategoryDTO.class);
	}
}