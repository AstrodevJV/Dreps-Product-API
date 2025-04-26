package com.dreps.repository;

import com.dreps.Model.ProductoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Long> {

    @Query("SELECT p FROM ProductoModel p ORDER BY p.id ASC")
    List<ProductoModel> findAllOrderByIdAsc(Pageable pageable);

    @Query("SELECT p FROM ProductoModel p JOIN p.categoria c " +
            "WHERE (:category IS NULL OR c.nombre = :category) " +
            "AND (:gender IS NULL OR c.genero = :gender)")
    Page<ProductoModel> findByCategoryAndGender(@Param("category") String category,@Param("gender") String gender,Pageable pageable);

    @Query("SELECT p FROM ProductoModel p WHERE p.nombre ILIKE CONCAT('%', :name,'%')")
    Page<ProductoModel> findByNombre(@Param("name") String name, Pageable pageable);

}
