package com.apontador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apontador.data.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
