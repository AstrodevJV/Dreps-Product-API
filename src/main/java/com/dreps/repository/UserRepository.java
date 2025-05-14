package com.dreps.repository;

import com.dreps.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByNombre(String nombre);



}
