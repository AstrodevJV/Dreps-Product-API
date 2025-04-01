package com.dreps.Controller;


import com.dreps.Model.ProductoModel;
import com.dreps.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dreps/api/v1")
public class ProductoController {


    @Autowired
    private ProductoService productoService;


   @GetMapping("/findall")
    public List<ProductoModel> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/productos")
    public ResponseEntity<Page<ProductoModel>> getProductosPage(@RequestParam int page, @RequestParam int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<ProductoModel> productos = productoService.getProductosByPage(pageable);

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/Hello")
    public String Hello() {
       return "Hello World";
    }

}
