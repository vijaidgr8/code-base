package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
