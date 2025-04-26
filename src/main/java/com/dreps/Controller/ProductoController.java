package com.dreps.Controller;


import com.dreps.Model.ProductoModel;
import com.dreps.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<ProductoModel>> getProductosPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(productoService.getProductosByPage(page, size));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findByCategoryAndGender")
    public ResponseEntity<Page<ProductoModel>> getProductosByCategoryAndGender(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String category,
            @RequestParam String gender) {

        return ResponseEntity.ok(productoService.getProductosByCategoryAndGender(page, size, category, gender));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findByName")
    public ResponseEntity<Page<ProductoModel>> getProductosByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String name) {
        return ResponseEntity.ok(productoService.getProductosByName(page, size , name));
    }

    @GetMapping("/Hello")
    public String Hello() {
       return "Hello World";
    }

}
