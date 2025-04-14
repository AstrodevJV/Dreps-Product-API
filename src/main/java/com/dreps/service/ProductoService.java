package com.dreps.service;

import com.dreps.Model.ProductoModel;
import com.dreps.exception.ProductoNoEncontradoException;
import com.dreps.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Page<ProductoModel> getProductosByPage(int page,int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productoRepository.findAll(pageable);
    }

    public Page<ProductoModel> getProductosByCategoryAndGender(int page ,int size, String category, String gender) {

        Pageable pageable = PageRequest.of(page, size);

        return productoRepository.findByCategoryAndGender(category,gender,pageable);
    }


}
