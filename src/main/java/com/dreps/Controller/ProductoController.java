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

    @CrossOrigin(origins = "*")
    @GetMapping("/findall")
    public List<ProductoModel> findAll() {
        return productoService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/productos")
    public ResponseEntity<Page<ProductoModel>> getProductosPage(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(productoService.getProductosByPage(page, size));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findByCategoryAndGender")
    public ResponseEntity<Page<ProductoModel>> getProductosByCategoryAndGender(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String gender) {

        return ResponseEntity.ok(productoService.getProductosByCategoryAndGender(page, size, category, gender));
    }

    @GetMapping("/Hello")
    public String Hello() {
       return "Hello World";
    }

}
