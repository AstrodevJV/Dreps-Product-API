package com.dreps.repository;

import com.dreps.Model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Long> {

    @Query("SELECT p FROM ProductoModel p WHERE p.categoria.id = :categoriaId")
    List<ProductoModel> findByCategoriaId(@Param("categoriaId") Long categoriaId);


}
