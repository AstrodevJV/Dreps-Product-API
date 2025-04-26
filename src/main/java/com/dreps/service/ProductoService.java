package com.dreps.service;

import com.dreps.Model.ProductoModel;
import com.dreps.exception.ProductNotFoundException;

import com.dreps.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoModel> findAllAsc(){
        return productoRepository.findAllOrderByIdAsc();
    }

    public Page<ProductoModel> getProductosByPage(int page,int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productoRepository.findAll(pageable);
    }

    public Page<ProductoModel> getProductosByCategoryAndGender(int page ,int size, String category, String gender) {

        Pageable pageable = PageRequest.of(page, size);

        return productoRepository.findByCategoryAndGender(category,gender,pageable);
    }

    public Page<ProductoModel> getProductosByName(int page, int size, String name) {

        Pageable pageable = PageRequest.of(page, size);

        Page<ProductoModel> products = productoRepository.findByNombre(name,pageable);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Nombre no encontrado " + name);
        }
        return products;
    }



}
