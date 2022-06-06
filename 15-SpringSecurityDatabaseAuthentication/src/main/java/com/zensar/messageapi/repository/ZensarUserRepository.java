package com.zensar.messageapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.messageapi.entity.ZensarUser;


public interface ZensarUserRepository extends JpaRepository<ZensarUser, Integer>{
	
	ZensarUser findByUsername(String username);

}
