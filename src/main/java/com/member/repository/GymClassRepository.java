package com.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.member.entity.ClassName;



@Repository
public interface GymClassRepository extends JpaRepository<ClassName, Long> {

}
