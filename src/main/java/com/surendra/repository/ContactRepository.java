package com.surendra.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surendra.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Serializable>{

}
