package com.example.assignment8.repository;

import com.example.assignment8.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Short>, JpaSpecificationExecutor<Department>{

    public Department findByName(String name);

    public boolean existsByName(String name);

//    Delete all
    @Modifying
    @Transactional
    @Query("Delete FROM Department WHERE id IN(:ids)")
    public  void deleteByIds(@Param("ids") List<Short> ids);

}
