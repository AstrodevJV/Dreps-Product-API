package com.dreps.service;

import com.dreps.Model.ProductoModel;
import com.dreps.exception.ProductoNoEncontradoException;
import com.dreps.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoModel> findAll(){
        return productoRepository.findAll();
    }

    public Page<ProductoModel> getProductosByPage(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }



}
